---
title: Mini-Project 9
subtitle: Blockchains
repo: <https://github.com/Grinnell-CSC207/mp-blockchains-maven>
summary: |
  In this assignment, you will practice working with linked structures
  by developing your own simple implementation of blockchains.
link: true
notes: |
  The next time through, I should have the validator take a byte array
    rather than a Hash.
---
Repository: {{ page.repo }}

Useful Javadoc:

* [`java.nio.ByteBuffer`]({{ site.java_api }}/java/nio/ByteBuffer.html)
* [`java.security.MessageDigest`]({{ site.java_api }}/java/security/MessageDigest.html)

More useful Javadoc

* [`Byte.toUnsignedInt`]({{ site.java_api }}/java/lang/Byte.html#toUnsignedInt(byte))
* [`String.format`]({{ site.java_api }}/java/lang/String.html#format(java.lang.String,java.lang.Object...))
* [`StringBuilder`]({{ site.java_api }}/java/lang/StringBuilder.html)

*Collaboration*: You must work with an assigned partner on this project.  I would prefer that you use a pair-programming approach, but you may choose any approaches the two of you decide are best.

---

Sequential structures are pervasive in all of computing.  One of the most recent innovations in sequential structures is the [*blockchain*](https://en.wikipedia.org/wiki/Blockchain_(database)) which is a sequence of records built to be highly resistant to change.  Blockchains were first used in 2008 to record transactions for the cryptocurrency [Bitcoin](https://en.wikipedia.org/wiki/Bitcoin).  In this context, the blockchain is a complete history of all Bitcoin transactions ever made, a *public ledger*, replicated, verified, and evolved by many computers a distributed network of machines connected through the Internet.  Since then, blockchains have been used in many other contexts, *e.g.*, other [cryptocurrencies](https://en.wikipedia.org/wiki/Cryptocurrency), crowd-funding and digital rights management, and supply chain management, anywhere where immutable public records of transactions are necessary.

Blockchains, as a *distributed data structure*, require careful coordination between the participating computers on the network.  As this is not a distributed systems course, we will not address these issues directly.  However, the blockchain itself is simply a list with a bit of extra information to ensure its integrity.  In this project, we will develop a blockchain data structure that will allow us to understand the essential operations that blockchain-based application perform.

## Background

### Hashes

At its core, a blockchain is simply a linked list augmented with *cryptographic hashes* of their contents.  A hash function is a mapping from values of a data type of arbitrary size to a fixed size bit string.  The output of a hash function is called a *hash* which can be thought of as a summary of that data type.  A [cryptographic hash function](https://en.wikipedia.org/wiki/Cryptographic_hash_function) is a hash function that obeys a number of additional properties, most notably:

1. *Resistance to inversion*: given a hash value, it is computationally infeasible to find the original value.
2. *Resistance to collisions*: given a hash, it is computationally infeasible to find two values that both produce the given hash.
3. *Sensitivity to change*: small changes to a value should result in significant changes to the resulting hash so that it is infeasible to determine an updated value given its hash coupled with the old value and the old value's hash.

Because of these properties, there is no easy way to find a value that produces a hash that meets some arbitrary property---*e.g.*, that the hash begins with three zeroes---other than a brute-force search of all the possibilities.  Blockchains exploit this property of cryptographic hashes to maintain the integrity of its recorded transactions.

### Cryptographic hashes in Java

There are many cryptographic hash functions available that strike balances between size of the outputted hash, computational complexity, likelihood of collisions, and other factors.  It is ill-advised to implement your own cryptographic hash functions as they tend to be complicated to implement and difficult to verify.
Instead, you should use some external library from a source that you trust, ideally, from the standard library of your chosen language.

Luckily, Java includes such functionality through its [`MessageDigest`]({{ site.java_api }}/java/security/MessageDigest.html) class.

A `MessageDigest` is an object that encapsulates the process of creating a hash value from some data.  To create a `MessageDigest`, we first create one through the static `getInstance` method of the `MessageDigest` class:

```java
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

  /**
   * Calculate the hash of a string.
   */
  public static byte[] calculateHash(String msg) 
      throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    // Remaining implementation below...
  } // calculateHash(String)
```

Rather than expose a constructor, `MessageDigest` provides a static *factory method* that creates instances of the class for you.  `getInstance` takes a single argument which is the hash algorithm to be employed by the object.  In the above example, we create a `MessageDigest` object that will use the [SHA-2](https://en.wikipedia.org/wiki/SHA-2) algorithm to perform hashing.

Finally note some other small details about using the `MessageDigest` class:

* The `getInstance` method potentially throws a `NoSuchAlgorithmException` which is a checked exception.  Because of this, we must add a `throws` clause to the enclosing method to signify that we are not explicitly dealing with this exception.  
* Both `MessageDigest` and `NoSuchAlgorithmException` exist within the `java.security` package, so we must add `import` declarations for each class to reference them.

Once we have created a `MessageDigest` object, we can add elements to it that will be hashed with `update`:

```java
    // Continued from above...
    md.update(msg.getBytes());
```

The `update` method takes the data to be hashed as an array of bytes (*i.e.*, a value of type `byte[]`).  Because of this, we must convert our data to bytes.  The way that we do this is specific to each data type.  For a string, we can simply call its `getBytes` method which produces an appropriate `byte[]` from the string.

We can continue adding data to hash to the `MessageDigest` in this fashion---note that the order matters!  Once we are done, we can ask the `MessageDigest` to compute the hash of all the accumulated data with the `digest` method:

```java
    // Still continued from above...
    byte[] hash = md.digest();
    return hash;
}
```

`digest` produces the hash as an array of bytes.  Finally note that this process "consumes" the data that was added to the `MessageDigest` via `update`.  If we wanted to compute another hash with this `MessageDigest` object, we would need to re-add everything. (That suggests that you can create the `MessageDigest` object once and keep using it.

### Blockchains as linked lists

A blockchain is essentially a linked list where each node contains a *block* of information.  Each block contains:

1. The number of the node in the list.
2. The data contained in the node.
3. The hash of the previous node's block in the list.
4. A *nonce value* which is an integer (explained shortly).
5. The block's own hash value which is computed from the previous four pieces of data.

Let's first consider a blockchain that consists of a single block.  Note that the particulars of the data are not relevant for this discussion (other than the fact that we can hash the data), so we'll simply let the data be a string.

```text
   Block 0
==============
data:     "A"
prevHash: none
nonce:    ??
hash:     ??
```

Because this is the first block in the list, it doesn't have a previous hash to refer to, so we'll ignore it for the purposes of hashing.  However, what do we fill in for the `nonce` value of this block so that we can compute its hash.  If our choice of `nonce` value was arbitrary, then our resulting hash value would also be arbitrary and thus would be of little use for verifying anything.

We therefore put an arbitrary restriction on our hash value which only allows us to accept certain hashes into our blockchain.  _For this project_, we place the following restriction on our hashes:

* A hash is *valid* for our block chain if it begins with three bytes that are all zeroes.

Thus, we cannot pick any nonce value; we must pick one such that the resulting hash of the block fulfills our validity criteria.  And thanks to the properties of cryptographic hashing, we are forced to brute-force search all possible nonce values to find one that fulfills our criteria!

This process of finding a nonce that, when combined with the rest of the block, produces a valid hash, is called *mining*.  This is because finding such a nonce is very time consuming.  Cryptographic hashing tells us that the only method of doing so is:

* Loop through all the possible nonce values. (We'll often do so randomly.)
* For each candidate nonce, compute the hash of the block with the nonce.
* If the hash is valid, then complete the block with that data.
  Otherwise, keep iterating.

Bitcoin mining is simply the process of finding nonces for new Bitcoin blocks.  The so-called "difficulty" of the mining operation is the restriction placed on valid hashes which scales as more blocks are created.

Returning back to our example, suppose that we add another block to the chain after adding block 0:

```text
   Block 0                 Block 1
=============           =============
data:     "A"           data:     "B"
prevHash: none    <-->  prevHash: 000f6c
nonce:    41209         nonce:    9810
hash:     000f6c        hash:     000ae1
```

Note that block 1 is tied to block 0 not just by a pointer but also by block 0's hash.  This architecture, coupled with the nature of cryptographic hashes, ensures that the data inside the blockchain cannot be tampered with.

For example, suppose a malicious person tried to change block 0's data:

```text
   Block 0               Block 1
=============         =============
data:     "Q"         data:     "B"
prevHash: none  <-->  prevHash: ???
nonce:    ???         nonce:    9810
hash:     ???         hash:     ???
```

Note that by changing the `data` field, someone can check via hashing block 0 again that the resulting hash is not consistent with the data!  Of course, if someone was this malicious, they could also simply calculate the value of the nonce for block 0.  However, since the hash of block 1 depends on block 0, they would also need to re-calculate the nonce for block 1 as well!

Now imagine that our blockchain has grown significantly:

```text
   Block 0                     Block 1279018
=============                  =============
data:     "Q"                  data:     "ZZZZZZZ"
prevHash: none  <--> ... <-->  prevHash: ???
nonce:    ???                  nonce:    410
hash:     ???                  hash:     ???
```

If someone tried to change block 0 now, they need to recalculate the nonces for the entire chain!  This intra-block dependency ensures that the blockchain is *resilient* to changes.  Once a block is set, it is computationally expensive to try to change it, especially if many blocks follow it in the chain.

However, what happens if an attacker manages re-mine the entire block chain?  This is where the distributed nature of a blockchain comes into play.  Recall that there does not exist one blockchain in isolation but many copies of the blockchain spread out on different machines.  We can determine what the *correct* blockchain is by consensus---do the majority of machines on the network have the same chain?  Furthermore, because of the architecture of the blockchain, it is sufficient to check only the *final block's hash* of all the replicas to determine the majority.

## The BlockChain program

In this project, we will write a program that simulates the development of a blockchain that records transfers of money between multiple parties. A transaction consists of three pieces of information:

* The _source_ of the transfer. This must either be someone who already has a positive balance in the system or from the Global Banking Cartel (which will be represented by the empty string). You can assume that the Global Banking Cartel has infinite funds.
* The _target_ of the transfer. This can either be someone already in the system or someone new.
* The _amount_ transfered. This will be an exact integer.

The first block of the system should have an empty source, empty target, and 0 transferred.

Subsequent blocks of the chain only store the transactions between people, rather than the overall amount in the system.  To tell if a new block is valid, we must not only check that its hashes are correct but also the transaction represents a legal exchange of cash given the history of blocks before it.  For example, the following transaction chain is valid:

```text
"","Alexis",50
"Alexis","Blake",25
"Alexis","Cassidy",10
"Blake","Cassidy",5
"Cassidy","Alexis",15
```

However, the following transaction chain is not valid:

```text
"","Alexis",50
"Alexis","Blake",25
"Cassidy","Alexis",5
```

In this case, Cassidy does not have any money in the system, and so cannot transfer money. The following transaction chain is also invalid.

```text
"","Alexis",50
"Alexis","Blake",25
"Blake","Cassidy",5
"Cassidy","Alexis",10
```

In general, we must traverse the entire blockchain to determine if a new transaction is valid, checking that each transaction legally follows from the previous one.

### Encapsulating bytes with a `Hash` class

While a hash (at least the hash returned by a message digest) is just an array of bytes, it is convenient to write a *wrapper class* that wraps up a byte array along with some operations we would like to perform on it.

Write a class called `Hash` with the following `public` methods:

`Hash(byte[] data)`
  : Construct a new `Hash` object that contains a copy of the given hash (still as an array of bytes). We make a copy of the data so that clients can't later chant any bytes.

`byte[] getBytes()`
  : Return a copy of the bytes in the hash. We make a copy so that the client can't change them.

`int length()`
  : Get the number of bytes in the hash.

`byte get(int i)`
  : Get the ith byte of the hash.

`String toString()`
  : returns the string representation of the hash as a string of uppercase hexadecimal digits, 2 digits per byte. For example, the byte array `{255, 10, 1}` should be `"FF0A01"`.

`boolean equals(Object other)`
  : returns true if this hash is structurally equal to the argument. That is, it ensures that the other object is also a `Hash`.

To implement `toString()`, you will find the following static methods useful:

* [`Byte.toUnsignedInt`]({{ site.java_api }}/java/lang/Byte.html#toUnsignedInt(byte))
* [`String.format`]({{ site.java_api }}/java/lang/String.html#format(java.lang.String,java.lang.Object...))
* [`StringBuilder`]({{ site.java_api }}/java/lang/StringBuilder.html)

The conversion method `Byte.toUnsignedInt` is necessary because all integral values in Java are signed.  We do not want values past 127 to be interpreted as negative numbers, *e.g.*, if we have the bit pattern `11111111`, we want to interpret this as the value `255` not `-128`.  `String.format` works like `sprintf` which acts like `printf` but writes its output to a string.  You should use a format specifier that prints an integer to the screen in hexadecimal using two digits; read the documentation to discover what this format specifier is.

The `equals` method should check to see if:

1. `other` is an instance of `Hash` using the `instanceof` operator.
2. If so, it should *cast* `other` to type `Hash`, *e.g.*, `Hash o = (Hash) other` and then use the [`Arrays.equals` static method]({{ site.java_api }}/java/util/Arrays.html#equals-byte:A-byte:A-) to perform the appropriate equality check on the two `Hash` object's arrays.

### Checking hashes with a `HashValidator` interface

As we noted in our description of the standard approach to block chains, we have a set of criteria that we apply to hashes. Our standard mining technique is to continually guess nonces until we have a hash that meets the criteria.

To make our block chains more general, we'll have a separate `HashValidator` object that tells whether or not a hash is valid. `HashValidator` is a functional interface that provides one method.

`boolean isValid(Hash hash)`
  : Determine whether or not a hash is valid according to some criteria.

For initial development, you might want to use the following validator.

```
HashValidator simpleValidator = 
    (hash) -> (hash.length() >= 1) && (hash.get(0) == 0);
```

Once things seem to be working okay, you should use a validator that will normally require a bit of time to find a nonce.

```
HashValidator standardValidator =
    (hash) -> (hash.length() >= 3) && (hash.get(0) == 0)
        && (hash.get(1) == 0) && (hash.get(2) == 0);
```

### Storing data with a `Transaction` class

This class represents the data in each block. For our purposes, we only need three parts: 

* The source of the transfer.
* The target of the transfer.
* The amount transferred.

The class provides one constructor.

`Transaction(String source, String target, int amount)`
  : Create a new transaction.

The class provides only getters.

`String getSource()`
  : Gets the source.

`String getTarget()`
  : Gets the target.

`int getAmount()`
  : Gets the amount.

It also provides the legendary `toString()` and `equals` methods.

`String toString()`
  : If the source is not the empty string, returns a string
    of the form `[Source: <source>, Target: <target>, Amount: <amount>]`.
    If the source is the empty string, returns a string of the
    form `[Deposit, Target: <target>, Amount: <amount>]`.

`boolean equals(Object other)`
  : Determine if other is a Transaction with the same fields.

### Adding meta-information in a `Block` class

Next, you should create a separate class for the data contained in each node of the blockchain.  Recall that a block contains:

* The number of the block in the blockchain.
* The transaction.
* The hash of the previous block in the chain.
* The nonce.
* The hash of this block.

Note that a block itself does not contain links to other blocks in the chain.  The block will be wrapped in a `Node` class that will contain links to nodes that contain other blocks.

Write a class called `Block` with the following `public` constructors and methods:

`Block(int num, Transaction transaction, Hash prevHash, HashValidator check)`
  : Create a new block from the specified block number, transaction, and
    previous hash, mining to choose a nonce that meets the requirements 
    of the validator.

`Block(int num, Transaction transaction, Hash prevHash, long nonce)`
  : Create a new block from the specified parameters, computing the
    hash for the block.

`int getNum()` 
  : Get the number of this block.

`Transaction getTransaction()`
  : Gets the transaction.

`long getNonce()` 
  : Get the nonce of this block.

`Hash getPrevHash()`
  : Get the hash of the previous block in the blockchain.

`Hash getHash()`
  : Get the hash of this block.

`String toString()`
  : Return a string representation of the block (see below).

The string representation of a `Block` should be formatted as follows (filling in values for the things in angle brackets):

```text
Block <num> (Transaction: [Source: <source>, Target <target>, Amount: <amt>], Nonce: <nonce>, prevHash: <prevHash>, hash: <hash>)
```

However, if the source is the Global Banking Cartel (that is, the empty string), use "Deposit" instead of "Source: <source>".

For example,

```text
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 300], Nonce: 9324351, prevHash: null, hash: 000000201f6c32c24b52b8a5b7d664af23e7db950af8867dbe800eb5c40c30a7)
Block 2 (Transaction: [Source: Alexis, Target: Blake], Amount 50, Nonce, 12312321, prevHash: 000000201f6c32c24b52b8a5b7d664af23e7db950af8867dbe800eb5c40c30a7, hash: 000000201f6c32c24b52b8a5b7d664af23e7db950af8867dbe800eb5c40c30a8)
```

Note that your `Block` class will need to compute a hash for the other data. In computing the hash, you *must* put the data in the message digest in the following order.

1. The block number.
2. The source of the transaction.
3. The target of the transaction.
4. The amount of the transaction.
5. The hash of the previous block.
6. The nonce.

You will likely benefit from a local `computeHash` function within your `Block` class.

#### Mining

To mine for a given block's nonce, you will need to use the `MessageDigest` class as described in the background section of this assignment.  To convert integers and longs into byte arrays, use the [`ByteBuffer` class]({{ site.java_api }}/java/nio/ByteBuffer.html) which allows you to store data types as arrays of bytes.  You will need to use the following methods of the `ByteBuffer` class:

* `ByteBuffer.allocate(int size)`: creates a `ByteBuffer` of the given size in bytes.
* `ByteBuffer putInt(int val)`, `ByteBuffer putLong(long val)`: puts the given value into the `ByteBuffer`.
* `byte[] array()`: extracts the bytes of the given `ByteBuffer` to a byte array.

Note that the `putInt` class returns the `ByteBuffer` that the method was called on.  This is to enable a style of method calls called "method chaining".  For example, here is how you might produce a byte array from an integer `i` or long `l`:

```java
byte[] ibytes = ByteBuffer.allocate(Integer.BYTES).putInt(i).array();
byte[] lbytes = ByteBuffer.allocate(Long.BYTES).putLong(l).array();
```

To mine a block, you should update a `MessageDigest` object with the following properties of the block:

1. The block's number.
2. The data contained in the block. (That is, the source, the target, and the amount).
3. The hash of the previous node's block in the list if it exists.
4. The discovered nonce value.

Note that when you mine the initial block, there will be no previous hash, so you can skip adding such a value to the `MessageDigest` object.

The value of the resulting hash may be different depending on the order in which you hash values.  For consistency's sake with our testing suite, **ensure that you update the `MessageDigest`** object in the order specified above.  For the first block, you should not hash anything for the previous hash value (step 3).  

There are a variety of ways to search for nonces.

* You could search all longs in increasing order starting at zero.
* You could randomly choose longs.
* You could choose some other way to sequence through the values (e.g., first looking at all multiples of 10, then one more than all multiples of 10, then two more than all multiples of 10).

### The BlockChain class

Use `Block` to implement a `BlockChain` class which is a singly-linked structure with a `first` and `last` pointer (*i.e.*, pointers to the first and last elements in the structure, much like in a queue).  You should use nodes as in the standard style of linked structure implementations in Java.  `BlockChain` should contain the following methods:

`BlockChain(HashValidator check)`
  : Create a `BlockChain` that possess a single block with empty source, target, and amount.  Note that to create this block, the `prevHash` field should be set to an empty byte array. You will use the given `HashValidator` when generating a nonce.

`Block mine(Transaction t)`
  : Mine a new candidate block to be added to the end of the chain.  The returned `Block` should be valid to add onto this block chain. (That is, not only should the nonce be correct, but the transfer should be valid.)

`int getSize()`
  : Return the size of the blockchain. Note that number of the blocks provides a convenient method for quickly determining the size of the chain.

`void append(Block blk)`
  : Add a block to the list, throwing an `IllegalArgumentException` if this block cannot be added to the chain (because it has an invalid hash, because its hash is inappropriate for the contents, or because the previous hash is incorrect). Note that `append` does not check whether or not the data in the block are valid.

`boolean removeLast()`
  : Remove the last block from the chain, returning `true`.  If the chain only contains a single block, then `removeLast` does nothing and returns `false`.

`Hash getHash()`
  : Return the hash of the last block in the chain.

`boolean isCorrect()`
  : Walk the blockchain and ensure that its blocks are consistent (the balances at every step are legal) and valid (as described in `append`). If so, return true. If not, return false.

`void check() throws Exception`
  : Walk the blockchain and ensure that its blocks are consistent (the balances at every step are legal) and valid (as described in `append`). If not, throw an exception with a meaningful message at the first bad block. In a more robust system, we might throw different exceptions for the different kinds of errors. In this version, we're just going to rely on the message.

`Iterator<String> users()`
  : Return an iterator of all the people who participated in the system (received money in the system). You can present this list in any order. You should not duplicate any user.

`int balance(String user)`
  : Find one person's balance. Returns 0 if they haven't used the system.

`Iterator<Transaction> iterator()`
  : Return an iterator of the transactions. (Ideally, you'll skip the
    fake transaction at the beginning.)

`Iterator<Block> blocks()`
  : Return an iterator of the blocks. (Intended mostly for debugging.)

While we know that our `Block` class only generates hashes from its arguments and could seemingly believe that a hash of a block is consistent with it's data, we still check each block in case a malicious actor found a way to modify the block. Hence, `isCorrect()` should check the hash in each block.

For the initial block, you should use

```java
  new Block(0, new Transaction("", "", 0), new Hash(new byte[] {}), validator);
```

### A BlockChainUI class

Finally we'll create a program, `BlockChainUI`, which allows us to interact with our `BlockChain`.  `BlockChainUI` should contain the `main` method of your program. Your program should permit the user to interactively manipulate the blockchain and mine for additional blocks through a text-driven interface.  The program repeatedly:

1. Reads in a command from the user.
2. Executes that command, potentially updating the blockchain and reporting back to the user.

The commands your program should support are:

```text
Valid commands:
    mine: discovers the nonce for a given transaction
    append: appends a new block onto the end of the chain
    remove: removes the last block from the end of the chain
    check: checks that the block chain is valid
    users: prints a list of users
    balance: finds a user's balance
    help: prints this list of commands
    quit: quits the program
```

In most cases, commands map directly onto `BlockChain` operations that you already implemented.  Note that `mine` is separate from `append`---you must first mine a candidate block with `mine` to discover an appropriate nonce and then `append` that block along with the discovered nonce.  This mimics more closely how Bitcoin works in real-life: miners race to discover blocks may collectively discover several nonces that work.  However, only one such nonce is eventually appended onto the blockchain.

`mine` and `append` take additional arguments---the transaction amount for `mine` and the transaction amount and nonce for `append`.  Your program should prompt for these values individually.

As in some previous projects, your program should resemble the output of the examples at the end.  In the case of invalid inputs, *e.g.*, invalid commands, your program should report sensible error messages and continue execution.  Note that depending on how you discover your nonce values, the nonce and hash values of your blocks may be different from these examples.

## Preparation

a. Fork the repository.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-blockchains-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-blockchains-maven
git add README.md
git status
git commit -m "Update README."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-blockchains-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-blockchains-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

## Rubric

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Includes the specified `.java` files, correctly named.  (They should
    be in the appropriate package.)
[ ] Each class has an introductory Javadoc comment that indicates
    the author and purpose. 
[ ] Includes a `README.md` file that contains the appropriate information 
    (authors, purpose, acknowledgements if appropriate)
[ ] All files compile correctly.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] The `Hash` class includes all of the required methods (and they work
    correctly).
[ ] The `Block` class includes all of the required methods.
[ ] The `Block(int num, int amount, Hash prevHash)` constructor generates
    an appropriate nonce.
[ ] The `BlockChain` class includes all of the required methods.
[ ] The `BlockChainUI` class behaves as described.
```

### Exceeds expectations

```
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] Avoids recreating structures---such as the `MessageDigest`, the
    various `ByteBuffer` objects, and other individual arrays---that 
    need not be recreated. 
```

## Sample sessions

### A standard sequence

Our normal order of operations will be to repeatedly mine for a nonce for a transaction and then add a block for that transaction. In the sample interaction below, we'll also print out the list of blocks and list of transactions and check the list after every `append` command.

```text
$ mvn clean compile exec:java -q
Valid commands:
  mine: discovers the nonce for a given transaction
  append: appends a new block onto the end of the chain
  remove: removes the last block from the end of the chain
  check: checks that the block chain is valid
  users: prints a list of users
  balance: finds a user's balance
  transactions: prints out the chain of transactions
  blocks: prints out the chain of blocks (for debugging only)
  help: prints this list of commands
  quit: quits the program

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -114191972542163658, prevHash: , hash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA)

Command: mine
Source (return for deposit):
Target: Alexis
Amount: 50

Use nonce: -1849593861095398136

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: -1849593861095398136
Appended: Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -1849593861095398136, prevHash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA, hash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583)

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -114191972542163658, prevHash: , hash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -1849593861095398136, prevHash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA, hash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]

Command: check
The blockchain checks out.

Command: users
Alexis

Command: balance
User: Alexis
Alexis's balance is 50

Command: balance
User: Blake
Blake's balance is 0

Command: mine
Source (return for deposit): Alexis
Target: Blake
Amount: 25

Use nonce: -2442513940491814281

Command: append
Source (return for deposit): Alexis
Target: Blake
Amount: 25
Nonce: -2442513940491814281
Appended: Block 2 (Transaction: [Source: Alexis, Target: Blake, Amount: 25], Nonce: -2442513940491814281, prevHash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583, hash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380)

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -114191972542163658, prevHash: , hash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -1849593861095398136, prevHash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA, hash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583)
Block 2 (Transaction: [Source: Alexis, Target: Blake, Amount: 25], Nonce: -2442513940491814281, prevHash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583, hash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380)

Command: check
The blockchain checks out.

Command: users
Alexis
Blake

Command: balance
User: Alexis
Alexis's balance is 25

Command: balance
User: Blake
Blake's balance is 25

Command: mine
Source (return for deposit): Alexis
Target: Cassidy
Amount: 10

Use nonce: -2236337044668048030

Command: append
Source (return for deposit): Alexis
Target: Cassidy
Amount: 10
Nonce: -2236337044668048030
Appended: Block 3 (Transaction: [Source: Alexis, Target: Cassidy, Amount: 10], Nonce: -2236337044668048030, prevHash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380, hash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716)

Command: users
Alexis
Blake
Cassidy

Command: balance
User: Alexis
Alexis's balance is 15

Command: balance
User: Blake
Blake's balance is 25

Command: balance
User: Cassidy
Cassidy's balance is 10

Command: mine
Source (return for deposit): Blake
Target: Cassidy
Amount: 5

Use nonce: 1316984175485757711

Command: append
Source (return for deposit): Blake
Target: Cassidy
Amount: 5
Nonce: 1316984175485757711
Appended: Block 4 (Transaction: [Source: Blake, Target: Cassidy, Amount: 5], Nonce: 1316984175485757711, prevHash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716, hash: 0000006E6D21841EEFE912E1AD36CE0ED0263AF9C3647F5D605482105FC21C35)

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -114191972542163658, prevHash: , hash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -1849593861095398136, prevHash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA, hash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583)
Block 2 (Transaction: [Source: Alexis, Target: Blake, Amount: 25], Nonce: -2442513940491814281, prevHash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583, hash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380)
Block 3 (Transaction: [Source: Alexis, Target: Cassidy, Amount: 10], Nonce: -2236337044668048030, prevHash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380, hash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716)
Block 4 (Transaction: [Source: Blake, Target: Cassidy, Amount: 5], Nonce: 1316984175485757711, prevHash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716, hash: 0000006E6D21841EEFE912E1AD36CE0ED0263AF9C3647F5D605482105FC21C35)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]
[Source: Alexis, Target: Blake, Amount: 25]
[Source: Alexis, Target: Cassidy, Amount: 10]
[Source: Blake, Target: Cassidy, Amount: 5]

Command: check
The blockchain checks out.

Command: users
Alexis
Blake
Cassidy

Command: balance
User: Alexis
Alexis's balance is 15

Command: balance
User: Blake
Blake's balance is 20

Command: balance
User: Cassidy
Cassidy's balance is 15

Command: mine
Source (return for deposit): Cassidy
Target: Alexis
Amount: 15

Use nonce: -3924680672452049635

Command: append
Source (return for deposit): Cassidy
Target: Alexis
Amount: 15
Nonce: -3924680672452049635
Appended: Block 5 (Transaction: [Source: Cassidy, Target: Alexis, Amount: 15], Nonce: -3924680672452049635, prevHash: 0000006E6D21841EEFE912E1AD36CE0ED0263AF9C3647F5D605482105FC21C35, hash: 0000004FE68CF2160354552EA4FA3CC5917B0AB4EF643C0E2F9CDBB6D675E174)

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -114191972542163658, prevHash: , hash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -1849593861095398136, prevHash: 00000064957D1F92B89301CB26C92162FFE7B2CC0CE99FDB80485ACDC5A45CDA, hash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583)
Block 2 (Transaction: [Source: Alexis, Target: Blake, Amount: 25], Nonce: -2442513940491814281, prevHash: 0000009CBD147007F1130AE2EB539672A42543B054B513F50A969AEBB5C5D583, hash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380)
Block 3 (Transaction: [Source: Alexis, Target: Cassidy, Amount: 10], Nonce: -2236337044668048030, prevHash: 000000F244074FFC73706F707AE52AE94FB6F582F28F81830EE587E3CD283380, hash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716)
Block 4 (Transaction: [Source: Blake, Target: Cassidy, Amount: 5], Nonce: 1316984175485757711, prevHash: 00000075984ADE2F7C043D1B21AA31C25EF313F14C7B081F2CCB61D344812716, hash: 0000006E6D21841EEFE912E1AD36CE0ED0263AF9C3647F5D605482105FC21C35)
Block 5 (Transaction: [Source: Cassidy, Target: Alexis, Amount: 15], Nonce: -3924680672452049635, prevHash: 0000006E6D21841EEFE912E1AD36CE0ED0263AF9C3647F5D605482105FC21C35, hash: 0000004FE68CF2160354552EA4FA3CC5917B0AB4EF643C0E2F9CDBB6D675E174)

Command: check
The blockchain checks out.

Command: balance
User: Cassidy
Cassidy's balance is 0

Command: balance
User: Alexis
Alexis's balance is 30

Command: quit

Goodbye
```

You'll note that all of the hashes start with six 0's. Since there are two characters per byte, that corresponds to our requirement that each hash start with three 0's.

### Failing to mine

If we don't mine before we try to append a block, we'll likely get an error about the hash.

```text
$ mvn clean compile exec:java -q
Valid commands:
  mine: discovers the nonce for a given transaction
  append: appends a new block onto the end of the chain
  remove: removes the last block from the end of the chain
  check: checks that the block chain is valid
  users: prints a list of users
  balance: finds a user's balance
  transactions: prints out the chain of transactions
  blocks: prints out the chain of blocks (for debugging only)
  help: prints this list of commands
  quit: quits the program

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: 123213123213
Could not append: Invalid hash in appended block: 00A0CC44CD23D1994EC050F97D99A4EB103BC6836775212D6C59B8E7213B70D2

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -2232360179571805138, prevHash: , hash: 000000B5EB069F18FC2ED4B22A3D92C5909BB320563D5EBC45F1EBDCE84D4045)

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: -1849593861095398136
Could not append: Invalid hash in appended block: C334578FF1274DB423AFABFF90280F251374A161C2ECB94D0144B4E55485F626

Command: mine
Source (return for deposit):
Target: Alexis
Amount: 50

Use nonce: -2898839831891447515

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: -2898839831891447515
Appended: Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -2898839831891447515, prevHash: 000000B5EB069F18FC2ED4B22A3D92C5909BB320563D5EBC45F1EBDCE84D4045, hash: 000000FC6952A359BCD8834467ECFD262F9D38CC8AFFC214AA356FFF1CCF6035)

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: -2232360179571805138, prevHash: , hash: 000000B5EB069F18FC2ED4B22A3D92C5909BB320563D5EBC45F1EBDCE84D4045)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -2898839831891447515, prevHash: 000000B5EB069F18FC2ED4B22A3D92C5909BB320563D5EBC45F1EBDCE84D4045, hash: 000000FC6952A359BCD8834467ECFD262F9D38CC8AFFC214AA356FFF1CCF6035)

Command: quit
```

### Inconsistent data

If you mine the nonce with one set of data and then use a different set of data with append, you will likely get an error because it will compute an invalid hash.

```text
$ mvn clean compile exec:java -q
Valid commands:
  mine: discovers the nonce for a given transaction
  append: appends a new block onto the end of the chain
  remove: removes the last block from the end of the chain
  check: checks that the block chain is valid
  users: prints a list of users
  balance: finds a user's balance
  transactions: prints out the chain of transactions
  blocks: prints out the chain of blocks (for debugging only)
  help: prints this list of commands
  quit: quits the program

Command: mine
Source (return for deposit):
Target: Alexis
Amount: 50

Use nonce: 1827944575962533535

Command: append
Source (return for deposit):
Target: Alexis
Amount: 500
Nonce: 1827944575962533535
Could not append: Invalid hash in appended block: D2CD9EC5F7B6DA740BA9B7C2575F91BF21F1BCF632ED09D35280A8352592241D

Command: append
Source (return for deposit):
Target: Alex
Amount: 50
Nonce: 1827944575962533535
Could not append: Invalid hash in appended block: 4F36CB278976DA3D0001AC072FBD04D513784D6ADD33A9D6F65814B5F9034A59

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: 1827944575962533535
Appended: Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: 1827944575962533535, prevHash: 0000005BB197679E581F85A00ABB8DFB56B2E69C4109D7D2C67470D11789113D, hash: 0000009470A38FE21793C4B91FF88579F199BB3EBC2AD523AA8B2F0674138589)

Command: check
The blockchain checks out.

Command: quit

Goodbye
```

### Invalid data

We can add invalid data to the chain. However, when we check the chain, we will discover that it's invalid.

```text
mvn clean compile exec:java -q
Valid commands:
  mine: discovers the nonce for a given transaction
  append: appends a new block onto the end of the chain
  remove: removes the last block from the end of the chain
  check: checks that the block chain is valid
  users: prints a list of users
  balance: finds a user's balance
  transactions: prints out the chain of transactions
  blocks: prints out the chain of blocks (for debugging only)
  help: prints this list of commands
  quit: quits the program

Command: mine
Source (return for deposit):
Target: Alexis
Amount: 50

Use nonce: -5660731459897621210

Command: append
Source (return for deposit):
Target: Alexis
Amount: 50
Nonce: -5660731459897621210
Appended: Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -5660731459897621210, prevHash: 00000075D1B392DB9908681950070286ECFC2E1FF5A9031D89CBC407BAC4CFD8, hash: 000000E53D18706EBC9FC8D90D0A48E6D9F9874C25E929754F543889E15840DB)

Command: mine
Source (return for deposit): Blake
Target: Alexis
Amount: 50

Use nonce: 8738763986400660911

Command: append
Source (return for deposit): Blake
Target: Alexis
Amount: 50
Nonce: 8738763986400660911
Appended: Block 2 (Transaction: [Source: Blake, Target: Alexis, Amount: 50], Nonce: 8738763986400660911, prevHash: 000000E53D18706EBC9FC8D90D0A48E6D9F9874C25E929754F543889E15840DB, hash: 000000300D8CF952552F1C1176459F07F58D014594894B3DAD3E244ABF4D0D3E)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]
[Source: Blake, Target: Alexis, Amount: 50]

Command: check
Unknown source in block 2: "Blake"

Command: remove
Removed last element

Command: blocks
Block 0 (Transaction: [Deposit, Target: , Amount: 0], Nonce: 6253245136681024660, prevHash: , hash: 00000075D1B392DB9908681950070286ECFC2E1FF5A9031D89CBC407BAC4CFD8)
Block 1 (Transaction: [Deposit, Target: Alexis, Amount: 50], Nonce: -5660731459897621210, prevHash: 00000075D1B392DB9908681950070286ECFC2E1FF5A9031D89CBC407BAC4CFD8, hash: 000000E53D18706EBC9FC8D90D0A48E6D9F9874C25E929754F543889E15840DB)

Command: mine
Source (return for deposit): Alexis
Target: Blake
Amount: 5

Use nonce: -7110822019453805820

Command: append
Source (return for deposit): Alexis
Target: Blake
Amount: 5
Nonce: -7110822019453805820
Appended: Block 2 (Transaction: [Source: Alexis, Target: Blake, Amount: 5], Nonce: -7110822019453805820, prevHash: 000000E53D18706EBC9FC8D90D0A48E6D9F9874C25E929754F543889E15840DB, hash: 00000023DFD6F052036A6E43E3BB45EAA6346A57C838D602FBBE342912201665)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]
[Source: Alexis, Target: Blake, Amount: 5]

Command: check
The blockchain checks out.

Command: mine
Source (return for deposit): Blake
Target: Alexis
Amount: 50

Use nonce: 1454357127647259755

Command: append
Source (return for deposit): Blake
Target: Alexis
Amount: 50
Nonce: 1454357127647259755
Appended: Block 3 (Transaction: [Source: Blake, Target: Alexis, Amount: 50], Nonce: 1454357127647259755, prevHash: 00000023DFD6F052036A6E43E3BB45EAA6346A57C838D602FBBE342912201665, hash: 0000004B9B3A4F8EA5B645E5917C430018B5AD57E78E1BD6E070DE8A87B1C9CA)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]
[Source: Alexis, Target: Blake, Amount: 5]
[Source: Blake, Target: Alexis, Amount: 50]

Command: check
Insufficient balance for Blake in block 3: Has 5, needs 50

Command: remove
Removed last element

Command: check
The blockchain checks out.

Command: mine
Source (return for deposit): Blake
Target: Alexis
Amount: -10

Use nonce: -5472847960142378404

Command: append
Source (return for deposit): Blake
Target: Alexis
Amount: -10
Nonce: -5472847960142378404
Appended: Block 3 (Transaction: [Source: Blake, Target: Alexis, Amount: -10], Nonce: -5472847960142378404, prevHash: 00000023DFD6F052036A6E43E3BB45EAA6346A57C838D602FBBE342912201665, hash: 000000BCB532461FBAC83FFDFA7ED606DCF61AD96708332D76DE9CFB06475190)

Command: transactions
[Deposit, Target: Alexis, Amount: 50]
[Source: Alexis, Target: Blake, Amount: 5]
[Source: Blake, Target: Alexis, Amount: -10]

Command: check
Negative amount in block 3: -10

Command: remove
Removed last element

Command: check
The blockchain checks out.

Command: quit

Goodbye
```

## Questions and answers

_A place for Sam to log the questions he gets about this assignment and
the answers he develops._

### Big picture

**What should our flow of finishing the assignment be?**

> I'd suggest implementing `Hash` and then `Block`. After that, I might alternate between implementing a new method in `BlockChain` and adding a call to it in the UI so that you can play with it.

**What should the initial block in the blockchain look like?**

> The blockchain should start with a block that has an empty string for the source, an empty string for the target, and 0 for the amount.

**Do I need to do anything with `HashValidator` and `Transaction`?

> I don't think so. They were intended to be complete as is.

### Nonces (or nonce-sense)

**How do I mine for a nonce?**

> Generate a long.

> Compute the hash of the block.

> Check if the hash is valid. If so, you're done. Otherwise, generate a new long and try again.

**Where should I be generating nonces?**

> I wrote a `mine` method in my `Block` class.

> The primary place I see that being used is in the first `Block` constructor.

**How many nonces should I expect to need to generate?**

> In my quick testing, my program had to generate between 1 million 
  and 150 million random nonces before it got a hash with three 
  leading 0's.  80 million nonces took about 30 seconds on my
  laptop.

> If you want to watch what's happening, I'd suggest something like
  the following (in `Block`).

        long count = 0;
        long startTime = System.currentTimeMillis();
        do {
          // The real work
          this.nonce = rand.nextLong();
          this.computeHash();
          // Observations
          ++count;
          if (VERBOSE && (0 == (count % 100000))) {
            System.err.printf("Generated %d nonces in %d milliseconds.\n", 
                              count,
                              System.currentTimeMillis() - startTime);
          } // if
        } while (!check.isValid(hash));

> You will, of course, have to write `computeHash`.

> `VERBOSE` is a field I set to true when I want ugly printing in my program.

**We are also confused about looping through available nonce values. How do we get those values?**

> Option 1: `for (long nonce = 0; nonce < LONG.MAX_VALUE; nonce++)`

> Option 2: `while (true) { long nonce = rand.nextLong(); }`

> Option 3: Some other clever technique.

**Does each nonce value have to be unique for each block?**

> You can repeat nonce values between blocks.

**What strategies can I use to optimize nonce generation and mining time? Are there alternative methods for brute-force searching?**

> Feel free to research those. For now, feel free to use brute-force methods.

**Should I mine for the nonce in `Block` or `BlockChain`?**

> In `Block`, for the first constructor.

### Hashes

**Could you re-explain hashes/their purpose in this assignment?**

> Hashes are generally used to validate a set of data. You compute the hash of the data and save it somewhere. Later, when you want to check if the data are still correct, you compute the hash again and see if it matches the saved hash.

> In this assignment, we're primarily using them to make sure that the information in a block doesn't change.

**How do I generate a hash?**

> Grab an appropriate message digest.

> Add each piece of data in turn. (First the block number, then the source,
  then the target, then the amount, then the previous hash, then the nonce.)

> Ask the message digest to give you the hash with `md.digest()`.

**Where should we use `MessageDigest`?**

> You should only need to use `MessageDigest` in the `Block` class when you create new blocks. You'll use it to compute the hash of the block.

**What should we do if `MessageDigest.getInstance("sha-256")` throws an exception?**

> It won't throw an exception. So put the code in a `try/catch` block and do nothing in the `catch` clause. Alternately, throw a `RuntimeException`, which isn't catchable.

**Do we have to write code to compute the hash?**

> No. The `digest` method of `MessageDigest` is supposed to compute the hash. Your job is to feed the `MessageDigest` object the data that you want hashed and then ask it for the hash.

**How do I add an integer to a digest?**

> I used something like `md.update(ByteBuffer.allocate(Integer.BYTES).putInt(i).array());`

**How do I add a long to a digest?**

> It should be similar.

**How could we go about decrypting a hash? Is there a specific key we need to save, kind of like our encryption mini-project?**

> In general, you shouldn't be able to decrypt a hash. That's part of the point. Ideally, the only way to decrypt a hash is to keep generating data until you find data that hash to the same hash value.

**Are these hashes the same as hash tables?**

> No. In CS, we're great at reusing terms to mean related but different things.

### User interface

**How should errors in user input be handled gracefully in the BlockChainUI class?**

> Print an error message and prompt again.

**I have had my own implementation of "continuously ask for input and whatnot" by using like a boolean like if it's not valid then do what, a switch statement that maps the command, but do you have a suggested template of a way to do it?**

> You'll find suggestions in `BlockChainUI.java` and `IOUtils.java`

### Checking correctness

**Should a blockchain only check if it is valid when the isCorrect method is called?**

> The blockchain should only check overall correctness when `isCorrect` or `check` is called.

**Can a block that makes a blockchain invalid be attached?**

> "Invalid" is a complicated term. You can attach blocks that have incorrect transactions. However, you cannot attach blocks that have an incorrect hash, that have an invalid hash, or that have an incorrect prevHash.

**Every time we add a new transaction, do we have to check the whole chain if it's valid? Or could we just check the previous block?**

> You only check the previous block. When we want to check the whole chain, we call `check` or `isCorrect`.

**How are edge cases for transaction validation best handled?**

> One at a time? In mine, I first check that the amount is non-negative. Then I check that the source is valid. Then I check that the source has sufficient "funds".

### Testing

**Will we get tests for this project?**

> Yes. They should be available by Wednesday night.

**What testing strategies would be most effective for ensuring the correctness of the blockchain implementation?**

> Make a list of possible problems and then either implement those as tests or try them withj the user interface.

### Storing the balances

**Can I use a `HashMap` to store the table of users and deposits?**

> Sure.

**Can I use my `AssociativeArray` class to store the table of users and deposits?**

> Certainly.

**Is the blockchain allowed a memory of the state of the chain outside of the blocks (for example, a dynamically sized array with all actors involved thus far and their balances)?**

> Sure.

### Miscellaneous

**The first `Block` constructor has a `HashValidator` as a parameter. Should that be one of the fields in our `Block` objects?**

> Probably not. You'll just use that `HashValidator` when you mine for a nonce in building a valid block.

**The E rubric says "Avoids recreating structures, such as the `MessageDigest` and some individual arrays, that need not be recreated." However, it looks like your sample code creates a new `MessageDigest` each time we try to hash and creates a new array each time we want to put an `int` or a `long` into the digest.**

> Yup. I was striving for straighforward code in the examples (believe it or not). You should write better code for an E.

**For wrapping "Node" around the Block, can we use what we did from the doubly-linked lists lab, or did you have another way of implementing this in mind?**

> I'd only use a singly-linked list, but I'm lazy.

**The instructions say that objects of the Block class will be wrapped in a Node class that will contain links to other blocks. Is this class something we should write entirely ourselves/that isn't in the repo?**

> You will need to write it yourself.

**What names should the `names` iterator return?**

> All the recipients of transactions (without duplicates).

**Where are we using the iterators for `Block` and `Transaction` objects?**

> Primarily in the UI.

> You could also use them in the `check` method.

### Random

**I remember hearing a few years ago that block chain would change everything. Do you think it was over hyped?**

> Has "everything" changed? I don't know. I don't think so. I see financial systems (including governmental financial entities) adapting to cryptocurrency. For awhile, the technology was doing a great job of using lots of energy, which changes the world for the worse.

## Acknowledgements

This assignment comes from materials developed by Peter-Michael Osera and Anya Vostinar. Samuel A. Rebelsky made a variety of updates, including the new Q&A section, the introduction of a new `HashValidator` class, and the expansion of transactions to include names.


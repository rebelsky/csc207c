---
title: Mini-Project 1
subtitle: Classical encryption
summary: |
  In this assignment, you'll practice your basic programming-in-the-small
  skills to implement a number of *[classical
  encryption](https://en.wikipedia.org/wiki/Classical_cipher)*
  techniques.
submitting: |
  You will submit your code directly to Gradescope.
copyright:  Copyright &copy; Peter-Michael Osera and Samuel A. Rebelsky.
copyright_message: |
  This work is licensed under a Creative Commons Attribution-NonCommercial
  4.0 International License.  To view a copy of this license, visit
  <http://creativecommons.org/licenses/by-nc/4.0/>.
link: true
---
Classical encryption is based on the principle of substituting letters for other letters.  These may be simple schemes like the ones we'll implement in this homework or more complicated schemes such as they employed in the [Enigma Machine](https://en.wikipedia.org/wiki/Enigma_machine).  The Enigma machine was used by Nazi Germany during World War II and was subsequently broken by the allies, in particular the researchers at the British [Government Code and Cypher School](https://en.wikipedia.org/wiki/Government_Communications_Headquarters#Government_Code_and_Cypher_School_.28GC.26CS.29), notably [Alan Turing](https://en.wikipedia.org/wiki/Alan_Turing) who led development of the [Bombe](https://en.wikipedia.org/wiki/Bombe) machines that were used to break the Enigma machines.

## README.md

Each of your online submissions should include a `README.md` file with the following contents:

1. Your name

2. A one sentence description of the content of this submission

3. A list of the resources you used---organic or inorganic---to complete this assignment and how they helped you complete the assignment, one sentence per such resource.
   Examples of resources include tutors, fellow students (within the bounds of the course's policy on collaboration), or online resources such as StackOverflow.

4. A link to the GitHub repository you set up for this project.

## Encryption preliminaries

The theory of encryption is a cornerstone of *[cryptography](http://en.wikipedia.org/wiki/Cryptography)* and *[computer security](http://en.wikipedia.org/wiki/Computer_security)* where we make our communication and/or data secure from adversaries.

Before the advent of computers, *classical cryptography* used various *transposition* and *substitution ciphers* to encrypt data.
Here are some basic definitions you should know before proceeding.

* A **cipher** is a pair of algorithms for encrypting and decrypting data.
* **Plaintext** is un-encrypted data.
* **Ciphertext** is encrypted data.
* A **transposition** cipher creates ciphertext from plaintext by re-arranging the letters in the text in some pre-determined fashion.
* A **substitution** cipher creates ciphertext from plaintext by substituting one letter for another letter.

Ciphers in classical cryptography were designed to be executed by hand with analog tools.  For example, the [Solitaire Cipher](http://en.wikipedia.org/wiki/Solitaire_(cipher)) was designed to be hand-executed by secret agents in the field with nothing more than a deck of cards.  More elaborate encryption schemes required the use of mechanical computing devices that became the forefathers of the modern-day digital computers, the Enigma machine described in the introduction being the quintessential example.  If you are curious, here is a [fun simulation](http://www.enigmaco.de/enigma/enigma.html) of an Enigma machine.  However, in the age of digital computers, classical cryptography methods are no longer useful for most practical purposes because a computer can either brute-force through these encryption schemes, or otherwise greatly assist an educated individual in breaking the code.

To implement these classical cryptographic schemes, we need to understand how to map the mathematical models that underlie them into Java.  Luckily this is relatively straightforward.  For sake of simplicity, let's assume that we're only working with lowercase English letters and that each letter is assigned a number---`'a'` starting at `0` and `'z'` ending with 25---called the *character code* of that letter.  Given a single letter `ch` and a single letter `key` to encrypt the letter with:

* To encrypt the character `ch` with the character `key`, "add" `key` to `ch`.
That is, add their corresponding numbers, and the result is the number of the corresponding encrypted letter.  If you go over 25, wrap around.  

For example, If we encrypt `c` with `j`, then we get `l` because the code for `c` is 2 and the code for `j` is 9.  2 + 9 = 11 which is the code for `l`.  

If we encrypt `x` with `e`, then we get `b` because the code for `x` is 23 and the code for `e` is 4.  23 + 4 = 27 but since 27 isn't a valid code, we wrap around and get 1 which is the code for `b`.

* To decrypt the character `ch` with the character `key`, "subtract" `key` from `ch`.  In the case when the difference is negative, we wrap around like with addition.

By thinking of characters as numbers, we can formalize this style of encryption as well as directly implement it in Java.  With character values, encryption can be thought of the formula:

```
E = (ch + key) mod 26.
```

Decryption is described by the formula:

```
D = (ch - key) mod 26.
```

Mod here is *almost* the `%` operator, but not quite.  The problem is that negative integers do not "wrap around" like you expect, *e.g.*, `-2 % 26` is `-2` rather than `24`.  You will need to do a little bit of extra work to obtain the desired behavior in this case.

To get the character value of a single character, we can convert it to an integer by *casting* to the appropriate type:

```
java> (int) 'e'
java.lang.Integer res1 = 101
```

However, we said that the character code for `e` is `4`.  What is going on here?  It turns out that Java assigns character codes to not just lowercase letters but to *all possible letters*.  Imagine putting all the possible letters on a line.  The lowercase letters occupy indices 97 through 122 on that line:

```
java> (int) 'a'
java.lang.Integer res0 = 97
java> (int) 'z'
java.lang.Integer res1 = 122
```

To "re-base" these numbers at index zero, we simply need to subtract the character value of `a`.

```
java> int base = (int) 'a'
int base = 97
java> (int) 'a' - base
java.lang.Integer res3 = 0
java> (int) 'z' - base
java.lang.Integer res4 = 25
```

When we want to get a letter back given a computed character value in the range 0-25, we simply reverse the process by adding back in `(int) 'a'` and then casting back to `char`.

```
java> int result = 22
int result = 22
java> (char) (result + base)
java.lang.Character res6 = w
```

## The Caesar cipher

With the fundamentals of manipulating characters-as-numbers out of the way, we will now implement a number of classic ciphers based off these cryptographic principles.  First, we will implement the [Caesar Cipher](http://en.wikipedia.org/wiki/Caesar_cipher), so named after Julius Caesar who used this encryption for his own private correspondence.

In terms of the formulae described above, the `key` we use to add and subtract to each character is constant.  That is, for any message, we pick a particular value `n` and encrypt a message with:

```
E = (ch + n) mod 26.
```

And we decrypt a message with

```
D = (ch - n) mod 26.
```

For example, say we want to encrypt the message `hello`, we would pick a key `n`, say `n = 11`. Then, to encode the message, we calculate:

```
'h' + 11 = 7 + 11 = 18 = 's'
'e' + 11 = 4 + 11 = 15 = 'p'
'l' + 11 = 11 + 11 = 22 = 'w'
'l' + 11 = 11 + 11 = 22 = 'w'
'o' + 11 = 14 + 11 = 25 = 'z'
```

To decrypt the message, we subtract the key rather than add it:

```
's' - 11 = 18 - 11 = 7
'p' - 11 = 15 - 11 = 4
'w' - 11 = 22 - 11 = 11
'w' - 11 = 22 - 11 = 11
'z' - 11 = 25 - 11 = 14
```

## The Vigenère cipher

The Vigenère Cipher is a substitution cipher like the Caesar Cipher. However, unlike the Caesar Cipher that has a fixed key, the Vigenère Cipher uses a *keyword* to shift the text.

As a concrete example, let's consider the plaintext `helloworld` along with the keyword `cap`.  First, we replicate the keyword to match the length of the plaintext.  Then we use the character value of the first letter of the keyword as the shift value of the first letter of the plaintext, the second keyword letter with the second plaintext letter, and so forth.  In other words, we calculate the resulting ciphertext as follows:

```
  h e l l o w o r l d
+ c a p c a p c a p c
---------------------
  j e a n o l q r a f
```

So the final ciphertext is `jeanolqraf`.
To decrypt this ciphertext, we simply reverse the process with subtraction:

```
  j e a n o l q r a f
- c a p c a p c a p c
---------------------
  h e l l o w o r l d
```

## The assignment

For this assignment, you will create three (3) classes, 

* `edu.grinnell.csc207.util.CipherUtils`
* `edu.grinnell.csc207.main.AllCaesar`
* `edu.grinnell.csc207.main.Cipher`

Details about each of these classes follows after a few more instructions.

You should put all your work in a Maven project that you upload to GitHub. Make sure to make the repo public and to include the location of the GitHub repo in your `README.md` file.

You should use the file [**cipher.zip**](../code/cipher.zip) as your starting point. Download and unzip this file. Open it in VSCode to see what files are there. You should also try some basic Maven commands in the terminal. (You might even peruse the `pom.xml`.)

### `edu.grinnell.csc207.util.CipherUtils`

This utility class should provide the following static methods.

* `private static int letter2int(char letter)`, which converts a lowercase letter to the corresponding integer.  For example, `letter2int('c')` should return `2`.
* `private static char int2letter(int i)`, which does the reverse. That is, it should convert `0` to `'a'`, `1` to 'b', and so on and so forth.
* `public String caesarEncrypt(String str, char letter)`, which uses the Caeser Cipher to encrypt a string consisting of only lowercase letters, using the given letter as the "key".
* `public static String caesarDecrypt(String str, char letter)`, which uses the Caeser Cipher to encrypt a string consisting of only lowercase letters, using the given letter as the "key".
* `public static String vigenereEncrypt(String str, String key)`, which uses the Vigenère Cipher to encrypt a string consisting of only lowercase letters, using the given key (which also consists of only lowercase letters).
* `public static String vigenereDecrypt(String str, String key)`, which uses the Vigenère Cipher to decrypt a string consisting of only lowercase letters, using the given key (which also consists of only lowercase letters).

You may also choose to add other methods as appropriate.

## `edu.grinnell.csc207.main.AllCaesar`

This main class should take two command-line arguments: (a) either 'encode' or 'decode', and (b) a string consisting of only lowercase letters. You will then print out all 26 encoded or decoded versions of the string, along with.

Here are some example executions of the program you should create.

```
$ java edu.grinnell.csc207.main.AllCaesar encode "helloworld"
n = a: helloworld
n = b: ifmmpxpsme
n = c: jgnnqyqtnf
n = d: khoorzruog
n = e: lippsasvph
n = f: mjqqtbtwqi
n = g: nkrrucuxrj
n = h: olssvdvysk
n = i: pmttwewztl
n = j: qnuuxfxaum
n = k: rovvygybvn
n = l: spwwzhzcwo
n = m: tqxxaiadxp
n = n: uryybjbeyq
n = o: vszzckcfzr
n = p: wtaadldgas
n = q: xubbemehbt
n = r: yvccfnficu
n = s: zwddgogjdv
n = t: axeehphkew
n = u: byffiqilfx
n = v: czggjrjmgy
n = w: dahhksknhz
n = x: ebiiltloia
n = y: fcjjmumpjb
n = z: gdkknvnqkc

$ java edu.grinnell.csc207.main.AllCaeser decode dahhksknhz
n = a: dahhksknhz
n = b: czggjrjmgy
n = c: byffiqilfx
n = d: axeehphkew
n = e: zwddgogjdv
n = f: yvccfnficu
n = g: xubbemehbt
n = h: wtaadldgas
n = i: vszzckcfzr
n = j: uryybjbeyq
n = k: tqxxaiadxp
n = l: spwwzhzcwo
n = m: rovvygybvn
n = n: qnuuxfxaum
n = o: pmttwewztl
n = p: olssvdvysk
n = q: nkrrucuxrj
n = r: mjqqtbtwqi
n = s: lippsasvph
n = t: khoorzruog
n = u: jgnnqyqtnf
n = v: ifmmpxpsme
n = w: helloworld
n = x: gdkknvnqkc
n = y: fcjjmumpjb
n = z: ebiiltloia

$ java edu.grinnell.csc207.main.AllCaesar booboo helloworld
Error: Invalid option: "booboo". Valid options are "encode" or "decode".

$ java edu.grinnell.csc207.main.AllCaesar encode
Error: Incorrect number of parameters.

$ java edu.grinnell.csc207.main.AllCaesar booboo
Error: Incorrect number of parameters.

$ java edu.grinnell.csc207.main.CaesarCipher
Error: Incorrect number of parameters.

$ java edu.grinnell.csc207.main.CaesarCipher encode a b
Error: Incorrect number of parameters.

$ java edu.grinnell.csc207.main.CaesarCipher encode "Hello World"
Error: String contains characters other than lowercase letters.
```

Note how the program operates:

1. The `CaeserCipher` program typically takes two parameters on the command line.  An instruction, contained in `args[0]`, should be either `encode` or `decode`.  The parameter, contained in `args[1]`, should be the string to encode or decode.

2. If the user provides an invalid instruction, the program states that the input was invalid (using `System.err`).

3. If the user provides an incorrect number of parameters, the program states that the input was invalid (using `System.err`).

4. If the user provides an invalid string (one that contains letters other than lowercase letters), the program states that the input was invalid (using `System.err`).

5. Otherwise, the program displays all 26 possible ways of encoding or decoding that string.

Although you may have learned to use `exit` to signal errors in your C programs, _do not_ use `System.exit` to report errors. Simply print using `System.err` and let the program exit normally.

Here are some assumptions you can make about the user input to simplify the problem:

* The user must enter *exactly* `encode` or `decode` as the first parameter.
  Any other strings can be considered invalid input.
* The string the user provides to be encoded or decoded must consist only of lowercase characters.  In particular, the string should not contain any whitespace.

For this program, you will need to use a handful of [String methods and constructors](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)

* `s.charAt(n)` retrieves the character at the `n`th index of string `s`.
* `s.toCharArray()` creates a character array (*i.e.,* a value of type `char[]`) containing the characters of string `s`.
* `s.length()` returns the length of the string `s`.
* `new String(arr)` creates a new string from the given character array `arr`.

## `edu.grinnell.csc207.main.Cipher`

The `Cipher` program, which will also be the default program in your `.jar` file, should take four command-line arguments in almost any order.

* The action `-encode` or `-decode` (starts with a dash)
* The cipher `-vigenere` or `-caesar` (starts with a dash)
* The string to encode
* The key (which must be a single letter for the Caesar cipher)

For example,

* `java -jar target/cipher-1.0.jar -encode -caesar hello x` 
  should encode the string `hello` using a Caesar cipher and the letter `x`.
* `java -jar target/cipher-1.0.jar -caesar -encode hello x` 
  should also encode the string `hello` using a Caesar cipher and the letter `x`.
* `java -jar target/cipher-1.0.jar hello -caesar -encode x` 
  should also encode the string `hello` using a Caesar cipher and the letter `x`.
* `java -jar target/cipher-1.0.jar hello -caesar x -encode` 
  should also encode the string `hello` using a Caesar cipher and the letter `x`.
* `java -jar target/cipher-1.0.jar x hello -caesar -encode` 
  should issue an error because it appears we're using a Caesar cipher with a multi-character key.
* `java -jar target/cipher-1.0.jar x hello -vigenere -encode` 
  should encode the string `x` using a Vigenère cipher and the keyword `hello`.
* `java -jar target/cipher-1.0.jar caesar vigenere -encode -vigenere`
  Should encode the string `caesar` using a Vigenère cipher and the key `vigenere`.

As in the prior main class, you should print all errors using `System.err.println` (or something similar) and make sure that each starts with the string `Error:`.

## Program design and decomposition

In this homework (and all work that you do), you should keep an eye out for appropriate *decomposition* of the program into smaller pieces. You should also strive for DRY (don't repeat yourself) code. If you find yourself writing nearly the same code twice, write a general method and call it from both places.

## Testing

We will provide you with unit tests at least two days before the project is due.

## Grading

When grading homework, we will grade based off of two criteria:

* Internal correctness: does your program function correctly?
* External correctness: does your program follow good design practices?

The external correctness portion depends on the following criteria:

1. Whether you followed the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) and the class extensions. You can check this with `mvn checkstyle:check` or `mvn checkstyle:check -q`.

2. Your actual program design: Do you have a monolithic functions (bad), or did you appropriately use helper functions to decompose the problem (good)?

3. General program style: Does your program have appropriate variable names, indentation, and spacing?

We will generally check internal correctness using unit tests (to be provided), although we will likely use.

## Grading rubric

### Redo or above

Submissions that lack any of these characteristics will get an I.

```
[ ] Includes the three specified `.java` files, correctly named.
[ ] Includes a `README.md` file.
[ ] Each file has an appropriate header that includes the course, author, etc.
[ ] All files compile correctly.
[ ] All main files produce some output when run with valid inputs.
[ ] Passes all "R" level tests.
```

### Meets expectations or above

Submissions that lack any of these characteristics will get an R or below.

```
[ ] Fewer than ten stylistic errors (as given by `mvn checkstyle:check -q`).
[ ] Passes all "M" level tests.
```

### Exemplary / Exceeds expectations

Submissions that lack any of these characteristics will get an M or below.

```
[ ] All (or most) repeated code has been factored out into individual
    methods.  
[ ] All or most variable names are appropriate.
[ ] No stylistic errors (as given by `mvn checkstyle:check -q`).
[ ] Passes all "E" level tests.
```

## Questions and answers

_Forthcoming_.

## Credit

This assignment is based on an assignment by Peter-Michael Osera. It is used with his permission. It has been significantly restructured since the original.

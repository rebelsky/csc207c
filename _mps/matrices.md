---
title: Mini-Project 6
subtitle: Matrices (two-dimensional arrays)
repo: <https://github.com/Grinnell-CSC207/mp-matrices-maven>
summary: |
  We build a more complex ADT. Along the way, we continue
  to explore multiple ways to implement such data structures.
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses.
link: true
---
## Introduction

We've explored Java's one-dimensional arrays and even used them to implement our own data structures, including _dynamic arrays_ and _associative arrays_. But what if we want two-dimensional arrays (sometimes referred to as "matrices")?

As you may recall, when writing array-like methods in standard Java syntax, we focus on two basic operations.

`public T get(int i)`
  : Get the `i`th element in the array.

`public void set(int i, T val)`
  : Set the `i`th element in the array to `val`.

Both of these methods throw an `ArrayIndexOutOfBoundsException` if given an invalid index. (`ArrayIndexOutOfBoundsException` is a `RuntimeException`, so we need not put our calls in a try/catch block (although it would not hurt us to do so).

For a matrix, we'll need to generalize these a bit.

`public T get(int row, int col)`
  : Get the element at the given row and column.

`public void set(int row, int col, T val)`
  : Set the element at the given row and column.

Like `get` and `set` above, these can also throw an `ArrayIndexOutOfBoundsException` (or just an `IndexOutOfBoundsException`, if you'd prefer).

What other methods will we need?

Ideally, we'll have a constructor. Or maybe two constructors. One will take three parameters: a width, a height, and a default value to return when there's a call to `get` not preceded by a corresponding call to `set`. The other will behave similarly, but always return `null` when a call to `get` asks for an "empty" cell. (That's what arrays do.)

Since we want to be careful not to call `get` or `set` with an invalid row or column, we should provide `width()` and `height()` methods.

That seems straightfoward, doesn't it? But let's make our ADT a bit more complex. Suppose, in our discussions of applications, we've found that the applications require that we be able to change the size of the array. We'll need to add some methods for those purposes.

`void insertRow(int row)`
  : Insert a row filled with the default value.

`void insertRow(int row, T[] vals)`
  : Insert a row filled with the specified values.

`void insertCol(int col)`
  : Insert a column filled with the default value.

`void insertCol(int col, T[] vals)`
  : Insert a column filled with the specified values.

`void deleteRow(int row)`
  : Delete the specified row.

`void deleteCol(int col)`
  : Delete the specified column.

An extended example that demonstrates the effects of these methods can be found toward the end of the mini-project.

We might also want to fill portions of the matrix.

`void fillRegion(int startRow, int startCol, int endRow, int endCol, T val)`
  : Fill the region with top boundary `startRow` (inclusive), left
    boundary `startCol` (inclusive), bottom boundary `endRow` (exclusive),
    and right boundary `endCol` (exclusive).

`void fillLine(int startRow, int startCol, int deltaRow, int deltaCol, int endRow, int endCol, T val)`
  : Fill the elements at `(startRow, startCol)`, `(startRow + deltaRow, startCol + deltaCol)`, `(startRow + 2 * deltaRow, startCol + 2 * deltaCol)`, ... with `val`. Stop when the current row or column equals or exceeds `endRow` or `endCol`, repectively.

These methods also appear in the extended example.

We should also include a few more standard methods.

`Matrix clone()`
  : Make a clone of the object. (May share references to the
    underlying values.)

`equals(Object other)`
  : Determine if another object is the same as this matrix.

That seems like enough for now.

## Implementing matrices

How would we implement such structures? As you might expect, there are a variety of ways we can implement two-dimensional arrays.

### Implementing matrices as arrays of arrays

The most straightforward is to have an array of arrays. Here's what such an implementation might look like for a 3-wide by four-high two-dimensional array (with the indices in the individual cells).

```text
rows: *
      |
      v
    +---+     +---+---+---+
    | *-----> |0,0|0,1|0,2|
    +---+     +---+---+---+  +---+---+---+
    | *--------------------> |1,0|1,1|1,2|
    +---+     +---+---+---+  +---+---+---+
    | *-----> |2,0|2,1|2,2|
    +---+     +---+---+---+  +---+---+---+
    | *--------------------> |3,0|3,1|3,2|
    +---+                    +---+---+---+
```

Although this approach is straightforward, two-dimensional arrays are a pain to manage, particularly two-dimensional arrays of values with generic types.

### Implementing matrices with single arrays

We could also use a single array in which we put all the elements of row 0, then all the elements of row 1, then the elements of row 2, and so on and so forth. Here's what the indices look like for a 3 wide by 4 high two-dimensional array stored in this way.

```text
vals: *
      |
      v
    +---+---+---+---+---+---+---+---+---+---+---+---+
    |0,0|0,1|0,2|1,0|1,1|1,2|2,0|2,1|2,2|3,0|3,1|3,2|
    +---+---+---+---+---+---+---+---+---+---+---+---+
```

Indexing into this array is relatively straightforward. The value at position `row,col` is at `row * width + col`.

As you may have noted, this implementation requires a bit less memory.

### Implementing matrices with associative arrays

Can we use even less memory? Yes! If we know that the two-dimensional array is "sparse", we can store the structure as an Associative Array that maps row/col pairs to values. Suppose the default value in our 3 wide by 4 high is `"X"` and that we have a "two" at position (1,1) and a "five" at position (3,2).

```
default: *---> "X"
pairs: *
       |
       v
     +---+                        +---+---+
     | *------------------------- | * | * |
     +---+      +---+---+         +-|-+-|-+
     | *------> | * | * |           v   v
     +---+      +-|-+-|-+         (1,1) "two"
                  v   v
                (3,2) "five"
```

Our implementation of `get` is relatively straightforward, something like the following. (We still need error checking.)

```java
public T get(int row, int col) {
  try {
    return pairs.get(new Index(row, col));
  } catch (KeyNotFoundException e) {
    return default;
  } // try/catch
} // get(int, int)
```

Which of these three implementations should we use? Or should we look for another? We'll find that different situations call for different implementations. For this assignment, you can choose which approach to employ.

## Getting ready

We will be sharing test cases in this project, which means that we will have two GitHub repositories: One for your `AssociativeArray` code and one for the shared tests. Using the strategy means that we'll have to do a slightly more complex setup. _Cross your fingers that it works correctly._

a. Fork the repository at {{ page.repo }}.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-matrices-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-matrices-maven
git add README.md
git status
git commit -m "Update README to include myself."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-matrices-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-matrices-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

g. Make sure that you can run the experiment in VSCode.

h. You should see two sets of testing files. Make sure that you can run the current tests in VSCode.

i. Make sure that you can run the experiment in Maven.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-matrices-maven
mvn exec:java -q
```

j. Make sure that you can run the tests in Maven.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-matrices-maven
mvn tests
```

## The assignment

### Part one: Write tests

As you know, good practice suggests that you should write tests before writing code. So start by writing tests. Write a set of tests in the file `TestsByStudent.java`. You should have at least one test for each of the methods in `Matrix`. 

Note that you may want to browse the tests in `TestsBySam.java`

Note that your concrete class is `MatrixV0<T>` rather than `Matrix<T>`.

### Part two: Implement Matrices

In the repository, you will find a `Matrix<T>` interface and a `MatrixV0<T>` class that is intended to implements that interface.

## Submitting your work

Please submit all of your work on the project to Gradescope by using the GitHub submission mechanism. 

## Approximate rubric

_I am likely to revisit this rubric._

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```text
[ ] Passes all the R tests.
[ ] Each class has an introductory Javadoc comment that indicates the author and purpose.
[ ] Includes a `README.md` file that contains the appropriate information
    (authors, purpose, link to GitHub repo, acknowledgements if appropriate).
[ ] All files compile correctly.
```

### Meets expectations or above

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an R.

```text
[ ] Passes all the M tests.
[ ] No more than fifteen errors from `mvn checkstyle:check`.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```text
[ ] Passes all of the E tests.
    [ ] Correctly handles `null` keys in `set`, `get`, and `hasKey`.
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No more than five errors from `mvn checkstyle:check`.
```

## Extended example

For example, suppose our matrix looks like this (conceptually) and our default value is `"O"`.

```text  
      0   1   2   3   4
    +---+---+---+---+---+
 0  | X | X | X | X | X |
    +---+---+---+---+---+
 1  | X | X | X | X | X |
    +---+---+---+---+---+
 2  | X | X | X | X | X |
    +---+---+---+---+---+
 3  | X | X | X | X | X |
    +---+---+---+---+---+
 4  | X | X | X | X | X |
    +---+---+---+---+---+
 5  | X | X | X | X | X |
    +---+---+---+---+---+
```

A call to `insertCol(2)` should update the matrix to this form.  (Remember that `O` is our default value.)

```text  
      0   1   2   3   4   5
    +---+---+---+---+---+---+
 0  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
 1  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
 2  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
 3  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
 4  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
 5  | X | X | O | X | X | X |
    +---+---+---+---+---+---+
```

A call to `insertCol(6, new String[] {"A", "B", "C", "D", "E", "F"})` should update the array to this form. Note that althought there was no column 6, since column 6 comes immediately after the last column, inserting at that location is permitted.

```text
      0   1   2   3   4   5   6
    +---+---+---+---+---+---+---+
 0  | X | X | O | X | X | X | A |
    +---+---+---+---+---+---+---+
 1  | X | X | O | X | X | X | B |
    +---+---+---+---+---+---+---+
 2  | X | X | O | X | X | X | C |
    +---+---+---+---+---+---+---+
 3  | X | X | O | X | X | X | D |
    +---+---+---+---+---+---+---+
 4  | X | X | O | X | X | X | E |
    +---+---+---+---+---+---+---+
 5  | X | X | O | X | X | X | F |
    +---+---+---+---+---+---+---+
```

A call to `insertCol(8, new String[] {"A", "B", "C", "D", "E", "F"})` should fail, since we are inserting beyond the bounds of the array. (Immediately after the last column or row is a special case.)

A call to `insertCol(0, new String[] {"A", "B"})` should fail because we are not providing  the appropriate number of values.

A call to `insertRow(0, new String[] {"P", "Q", "R", "S", T", "U", "V"})` should update the array as follows.

```text
      0   1   2   3   4   5   6
    +---+---+---+---+---+---+---+
 0  | P | Q | R | S | T | U | V |
    +---+---+---+---+---+---+---+
 1  | X | X | O | X | X | X | A |
    +---+---+---+---+---+---+---+
 2  | X | X | O | X | X | X | B |
    +---+---+---+---+---+---+---+
 3  | X | X | O | X | X | X | C |
    +---+---+---+---+---+---+---+
 4  | X | X | O | X | X | X | D |
    +---+---+---+---+---+---+---+
 5  | X | X | O | X | X | X | E |
    +---+---+---+---+---+---+---+
 6  | X | X | O | X | X | X | F |
    +---+---+---+---+---+---+---+
```

A call to `deleteCol(1)` should update the array as follows.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | P | R | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | O | X | X | X | A |
    +---+---+---+---+---+---+
 2  | X | O | X | X | X | B |
    +---+---+---+---+---+---+
 3  | X | O | X | X | X | C |
    +---+---+---+---+---+---+
 4  | X | O | X | X | X | D |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | E |
    +---+---+---+---+---+---+
 6  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `deleteRow(2)` should result in the following.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | P | R | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | O | X | X | X | A |
    +---+---+---+---+---+---+
 2  | X | O | X | X | X | C |
    +---+---+---+---+---+---+
 3  | X | O | X | X | X | D |
    +---+---+---+---+---+---+
 4  | X | O | X | X | X | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `fillLine(0, 0, 1, 1, 4, 4, "Z")` should fill the cells at (0,0), (1,1), and (2,2) with `"Z".


```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z | R | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | Z | X | X | X | A |
    +---+---+---+---+---+---+
 2  | X | O | Z | X | X | C |
    +---+---+---+---+---+---+
 3  | X | O | X | Z | X | D |
    +---+---+---+---+---+---+
 4  | X | O | X | X | X | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `fillLine(0, 1, 2, 1, 6, 6, " ")` should fill the cells at (0,1), (2, 2), and (4,3) with a space.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z |   | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | Z | X | X | X | A |
    +---+---+---+---+---+---+
 2  | X | O |   | X | X | C |
    +---+---+---+---+---+---+
 3  | X | O | X | Z | X | D |
    +---+---+---+---+---+---+
 4  | X | O | X |   | X | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `fillLine(3, 0, 0, 1, 6, 6, "-")` should fill the cells at (3,0), (3,1), (3,2), (3,3), (3,4), and (3,5) with a dash.


```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z |   | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | Z | X | X | X | A |
    +---+---+---+---+---+---+
 2  | X | O |   | X | X | C |
    +---+---+---+---+---+---+
 3  | - | - | - | - | - | - |
    +---+---+---+---+---+---+
 4  | X | O | X |   | X | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```


A call to `fillLine(1, 4, 1, 0, 5, 6, "?")` should fill the cells at (1,4), (2,4), (3,4), and (4,4) with a question mark.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z |   | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | Z | X | X | ? | A |
    +---+---+---+---+---+---+
 2  | X | O |   | X | ? | C |
    +---+---+---+---+---+---+
 3  | - | - | - | - | ? | - |
    +---+---+---+---+---+---+
 4  | X | O | X |   | ? | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `fillRegion(1, 1, 5, 4, "@")` should fill the specified region with at signs.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z |   | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | @ | @ | @ | ? | A |
    +---+---+---+---+---+---+
 2  | X | @ | @ | @ | ? | C |
    +---+---+---+---+---+---+
 3  | - | @ | @ | @ | ? | - |
    +---+---+---+---+---+---+
 4  | X | @ | @ | @ | ? | E |
    +---+---+---+---+---+---+
 5  | X | O | X | X | X | F |
    +---+---+---+---+---+---+
```

A call to `fillRegion(4, 2, 6, 6, ".")` should fill the last four cells on each of the last two rows.

```text
      0   1   2   3   4   5   
    +---+---+---+---+---+---+
 0  | Z |   | S | T | U | V |
    +---+---+---+---+---+---+
 1  | X | @ | @ | @ | ? | A |
    +---+---+---+---+---+---+
 2  | X | @ | @ | @ | ? | C |
    +---+---+---+---+---+---+
 3  | - | @ | @ | @ | ? | - |
    +---+---+---+---+---+---+
 4  | X | @ | . | . | . | . |
    +---+---+---+---+---+---+
 5  | X | O | . | . | . | . |
    +---+---+---+---+---+---+
```

Wasn't that exciting? Once your class works, you should be able to replicate these figures by using `MatrixExperiments`. (However, I created them by hand.)

Questions and Answers
---------------------

### Big picture

**Do we need to edit the `Matrix<T>` interface at all, or is that something we should leave alone?**

> You should leave it alone.

**Which implementation would you recommend to improve our coding ability?**

> I'd suggest trying all three. But if you could only do one, I'd suggest doing the 2D array version to get used to multi-dimenisional arrays. It may also be the most straightforward.

**Which implementation would you choose if you were implementing it yourself?**

> I'd implement all three and then see which one best fitted my situation. (Of course, I'd use a hash table or something similar, rather than an associative array for the sparse matrix.)

> Given a short time, I did the two-dimensional array version.

**Are we expected to use a specific implementation of matrices for this mini project (1D array, 2D array, associativeArray, some other dynamically sized array)?**

> You should use one of those three implementations.

**Out of the three approaches, which do you recommend us do?**

> I'm not sure that I have a single recommendation. It depends on your skills and your goals for the assignment.

> I'd encourage you to sketch out each and then decide which is easiest for you to implement.

**Will time/space complexity matter for our code now?**

> I will not grade this assignment based on time or space complexity.

** Are there specific performance considerations I should keep in mind when implementing the matrix?**

> There are no performance constraints you must consider (other than you should try to avoid code that is observably slow).

**How should I structure my tests to cover all edge cases effectively?**

> I'd suggest that you strive for no more than a few assertions per test case.

### Conceptual

**How are interfaces used by other files and what is the reason behind creating an interface separately from them?**

> We use interfaces to specify *what* we want something to do without specifying how. By using interfaces, we make it easier to swap out implementations (e.g., we might start by using matrices implemented by 2D arrays, but then realize that our code will run better if we use a different implementation).

**How different would our code be if we had to generalize the structure for an array of `n` dimensions? Is it even possible?**

> I suppose it's possible. We'd have to think about how to generalize many of the methods. We might also need to reconsider the design of some methods. For example, should `get` take a single parameter and return an `n`-1 dimensional matrix, or should it take an array of indices?

**In this mini-project we specify that `get()` receives two parameters row and col. What strategy could we use so that `get()` can handle more parameters?**

> I'd suggest passing in an array of indices (one per dimension). Java also has a "varargs" approach which, behind the scenes, is just an array.

**Should I prioritize memory efficiency (associative arrays) or ease of access (array of arrays)?**

> I'd prioritize ease of implementation.

**Besides reassigning the indexes for every elements if we want to remove the whole row or column, what is a more efficient way for deleting so many elements?**

> Unfortunately, there aren't many straightforward mechanisms for efficiently deleting large numbers of elements.

### Two-dimensional arrays.

**How would I declare a two-dimensional array?**

> I've used `T[][] contents`.

**How would I initialize that array?**

> The strategy I prefer is to build the outer array of rows and then fill
  it in with the rows.

> First, `contents = T[][] = (T[][]) new Object[height][];`

> Next, a for loop fills in the individual values. Here's a typical line
  from the body. `contents[i] = (T[]) new Object[width];`

> You can also write `contents = new Object[height][width];`, which
  achieves the same goal.

**Are there already 2D arrays in Java? Can you initialize `String[][] = new String[10][10]`, for instance? If so, are we allowed to do that?**

> That is something you could determine experimentally. But yes, you can create arrays that way.

> And yes, you are allowed to do so.

### Associative Arrays

**How would you change existing coordinates in an Associative Array when adding a row or column? I imagine a loop inside of set() that checks if the address is already assigned, and if so calls set again with an updated address for that existing pair value, again checking if that new address exists and resetting that one, and so on, which doesn't feel like the best way to do that.**

> Unfortunately, that's probably the best way to do so if we're using an associative array.

### Miscellaneous

**Can I assume that `deltaRow` and `deltaCol` in `fillLine` are non-negative?**

> Yes.

**How should we handle returning null? Will it be a problem if we are expected to return a string (or something similar)?**

> `null` can serve as any type of object: a string, a `BigInteger`, even a `Matrix`, I suppose. So just return `null` as you would return any other value.

**Do we need to shift all the values whenever we insert or delete columns and rows or do we have a better solution in 2D array?**

> If you are using a 2D array, you'll need to shift the array. If you are using the 1D array, you'll also need to shift the array. If you're using the associative array, you'll need to update all of the keys.

**What will happen when `insertRow(int row, T[] vals)` and the `vals` are more than the available column number? Do we throw error, exception, or ignore?**

> As the `Matrix.java` file suggests, you will throw an `ArraySizeException` exception.

**Does `fillLine` just let you make a line where you tell it where to start and how much to skip by in the x and y directions?**

> Yes.

**The only question I would have is whether we want this array to be dynamic (since it doesn't mention it in the instructions, I'm assuming the answer is no). If not, do we want to shift all the elements in the matrix when we remove and element?**

> I'm not sure that I completely understand the question. Matrices are not dynamic in the same way that, say, Dynamic Arrays are; we don't automatically expand or contract them. However, matrices do change their size when we delete or add rows or columns. So they are dynamic in that sense.

> Yes, you will have to shift elements.

**When deleting rows/columns, would we just have to null the values?**

You probably can't just "null" the values because you won't be able to tell the difference between nulls stored in the array and nulls used to represent "deleted". You'll need to build new arrays and shift values.

**Any tips on how to efficiently handle wrap-around indexing when the matrix grows or shrinks, especially when rows and columns are deleted or inserted?**

> I would not attempt wrap-around indexing!

**What should happen if I try to use an index that has not been defined in the matrix?**

> In general, you should throw an `IndexOutOfBoundsException`, which is a runtime exception.

**How should we determine if two matrices are equal?**

> They should be equal if they have the same width, height, and elements.

**Could you explain more about why we may want two different constructors?**

> We may not want to specify the default value (or, in other words, to have a "default" default value).

**Which approach for matrix implementations would YOU choose?**

> I started with 2D arrays because they seemed the most straighforward.

**Are there any specific edge cases I should keep in mind for sparse matrices?**

> None that come to mind.

Citations
---------

This assignment is loosely based on [an assignment from CSC-152 1998Sp](https://rebelsky.cs.grinnell.edu/Courses/CS152/98S/Assignments/assignment.03.html).

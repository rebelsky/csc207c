---
title: Mini-Project 8
subtitle: Sorting out sorting
summary: |
  In this assignment, you will further explore the implementation 
  of sorting algorithms.
repo: https://github.com/Grinnell-CSC207/mp-sorting-maven
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses. 
link: true
---
_This assignment has been significantly updated for Fall 2024. It likely contains imperfections. If you notice any, please let SamR know._

Summary: {{ page.summary }}

Repository: <{{ page.repo }}>

## Background: A generic sorting interface

As you might expect, we want to be able to switch sorting algorithms depending on a variety of circumstances, particularly characteristics we know about the data (e.g., that they are mostly in order or perhaps mostly reverse sorted).  Hence, rather than writing static `sort` methods, it may be more useful to define a generic `Sorter` interface and use that.  Here's one such interface.

```java
/**
 * Things that know how to sort arrays of values.
 *
 * @author Samuel A. Rebelsky
 *
 * @param <T>
 *   The type of value in the array.
 */
public interface Sorter<T> {
  /**
   * Sort an array in place.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 < i < vals.length,
   *     order.compare(vals[i-1], vals[i]) <= 0
   */
  public void sort(T[] values);
} // interface Sorter<T>
```

## Preparation

a. Fork the repository at <{{ page.repo }}>.

b. Clone that repository.

```text
cd ~/CSC207/MPs                 # Or the directory of your choice
git clone git@github.com:USERNAME/mp-sorting-maven.git
```

c. Open the project in VSCode.

d. Update the `README.md` appropriately.

e. Push the updated `README` to GitHub.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-sorting-maven
git add README.md
git status
git commit -m "Update README."
git pull
git push
```

f. Add an upstream repository just in case I make changes.

```text
cd ~/CSC207/MPs/                # Or the directory of your choice
cd mp-sorting-maven
git remote add upstream https://github.com/Grinnell-CSC207/mp-sorting-maven
```

In the future, you can grab changes using the following.

```text
git fetch upstream
git merge upstream/main
```

You can also just click the **Sync Fork** button on your GitHub page for the fork.

## Part one: Testing

As I hope you know by now, when writing a small or medium-sized function or class, we should begin by writing test cases for the function or class.

In the file `TestSorter.java`, add at least five test cases for `Sorter<T>` objects. (The system is designed so that every test you put in `TestSorter` is now available to test all four sorting algorithms.)

## Part two: Implement common sorts

### Insertion sort

Create a new class, `InsertionSort`, that implements insertion sort.  The repo should include a framework for the class.

### Selection sort

Create a new class, `SelectionSort`, that implements insertion sort.  The repo should include a framework for the class.

### Merge sort

Create a new class, `MergeSort`, that implements merge sort.  The repo should include a framework for the class.

### Quicksort

Create a new class, `QuickSort`, that implements Quicksort.  The repo should include a framework for the class.

Once you've identified a pivot, I would recommend that you use the Dutch National Flag algorithm to partition the subarray into (a) things less than the pivot, (b) things equal to the pivot, and (c) things greater than the pivot.

## Part three: Your own sort

In practice, the best sorting algorithms do something a bit more clever. For example, it may be good to switch from merge sort to insertion sort once you reach a small enough subarray, or one that is mostly ordered.

Write your own sorting algorithm that attempts to do better than all of the prior $$O(nlogn)$$ sorting algorithms. You might pre-scan the input to look for patterns that suggest a particular algorithm, you might switch algorithms for small enough arrays, you might find something else clever to do.

Please name your class `LastFirstSort`.  For example, mine would be `RebelskySamuelSort`. Please do not reference methods in your other classes.

Include a description of your approach in your README file.

You should also add a tester for your sort to make sure that it works correctly. (The pattern of the other testers should make that straightforward.)

I will hold a competition to see whose sorting algorithm wins on different kinds of inputs. Winners will receive acclaim as well as an extra token or two.

On this part of the mini-project, _and **only** on this part of the mini-project_, you may use Copilot or other LLM as a programming assistant.  If you do so, make sure to provide appropriate citations.  I'd also appreciate it if you'd also add a short note about the experience of using CoPilot.

Note that your sorting mechanism is expected to be efficient in most cases. You should strive for no worse than $$O(n^2)$$.

## Rubric

### Redo or above

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
[ ] Added new tests to `TestSorter.java`.
[ ] No more than fifteen errors from `mvn checkstyle:check`.
[ ] Appears to follow Google Java style guidelines for indentation and such.
[ ] All sorting routines pass Sam's tests (conveniently available in
    `SortTools.java`.
    [ ] Insertion sort
    [ ] Selection sort
    [ ] Merge sort
    [ ] Quicksort
    [ ] Your own sort
[ ] `README.md` includes a description of the new sorting algorithm.
```

### Exceeds expectations

```
[ ] All (or most) repeated code has been factored out into individual methods.
[ ] All or most variable names are appropriate.
[ ] No more than five errors from `mvn checkstyle:check`.
[ ] One or more of the new tests in `TestSorter.java` algorithmically 
    generates multiple tests.
[ ] Appropriately decomposes each sorting algorithm.
    [ ] Insertion sort has a separate `insert` method.
    [ ] Selection sort has a separate `select` method.
    [ ] Merge sort has a separate `merge` method.
    [ ] Quicksort has a separate `partition` method.
[ ] All sorts work with the empty array.
[ ] Only makes one helper array in `MergeSort`.
```

## Questions and answers

**Is this an individual or group project?**

> I'd like each of you to have the experimence of writing the four key sorting algorithms, so it is an individual project.

**There are lots of different Quicksorts out there. Do you care which we implement?**

> You can implement whichever you want, provide it has the key aspects of Quicksort. (UM): Divide and conquer algorithm, divide by a pivot (hopefully close to median), and rely on randomness to hope that get a good pivot.

**Can I use ChatGPT, Copilot, or similar AI tool on this assignment?**

> As per class policies, you may NOT use ChatGPT on parts one and two. I have, however, made an exemption to class policies for Part three.  You may use ChatGPT on Part three provided you cite it and provide a short narrative about your experience doing so.

**Can I talk to my peers about the assignment?**

> Of course.

**I've found that one of my sorting algorithms crashes on some inputs. What now?**

> You should debug. I'd suggest creating an experiment class in which you call the sorting routine on a known failing input, and step through your algorithm.

> You can use `QuicksortExperiments.java` for a sample experiment.

> Since we're often doing a lot of recursion in Quicksort and merge sort, you might also find it useful to insert some print statements. Make sure to print to `System.err` (as is good practice).

> You could ask someone else for help looking through your code.

> You can also ask Sam for help. Make sure to push your current version to GitHub and to provide the GitHub link.

**What does "repo should include a framework for the class" mean?**

> For example, you'll find a class called `Quicksorter.java` that is ready for you to fill in the Quicksort algorithm.

**Can I assume that if `obj1` "is less than" `obj2`, then `order.compare(obj1, obj2)` is `-1`?**

> **No!** If `obj1` "is less than" `obj2`, all you know is that `order.compare(obj1, obj2) < 0`. It could be `-1`. However, it could also be `-5` or `-32351` or any negative integer.

### Your own sort

**I don't have any good ideas on how to get started.*

> "Hey ChatGPT, how can I write a fast sorting algorithm?"

**Does my sort have to be stable?**

> Nope.

**May we take advantage of parallel processing in our sorting algorithm?**

> No.

**If I use randomness, isn't there a chance that my algorithm will be inconsistent; sometimes fast and sometimes slow?**

> Certainly. The competition has multiple rounds to help alleviate such issues.

**Do we get to know what's different rounds of testing your competition will have?**

> I'm likely to do something like the `compete` aspect in `SortTools`.

### Sam's implementations

**Have you implemented all of these algorithms?**

> I've implemented each of them many times in my career. Just to be carefuol, I implemented all of them (including two versions of Quicksort) for this assignment in Fall 2024.

**How long did it take you to implement them?**

> I implemented insertion sort in about five minutes, including documentation and running tests. I implemented selection sort in about five minutes, including documentation (there's more of it) and running tests.

> Remember that (a) I first implemented each of these algorithms before any of you were born (and before many of my colleagues in the department were born) and (b) I've been teaching these algorithms since any of you were born.

> In writing Quicksort, I decided to try our new DNF algorithm before proving it correct. That was a bad idea, since the algorithm doesn't work correctly if one of the sections is empty. (We'll talk about that in class on Tuesday.) It took me about an hour and twenty minutes to track down the bug.

> When I switched to the standard DNF algorithm (the one with at most one swap per round), Quicksort took me twelve minutes.

> I suppose that's a reminder that it takes much less time when you get things right the first time.

> It's also a reminder that it may be better to check your algorithm by hand.

> Merge sort also took about twelve minutes. That included tracking down one stupid bug.

> As I said, I've been implementing these algorithms for longer than you've been alive.

## Additional notes

The project also includes an (still under development) `SortTools` class. That class can be used to find arrays large enough that sorting is worth timing. It can also be used to run simple competitions between different sorters.

Here's a typical test session (to be updated once Sam implements some sorting algorithms). You'll note that we see output for the empty array and then a SUCCESSS for everything else.

```text
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.main.SortTools test edu.grinnell.csc207.sorting.InsertionSorter
Testing of edu.grinnell.csc207.sorting.InsertionSorter
  Successfully sorted empty array.
  SUCCESS!
```

The only test whose result is printed is the empty array. That's because you don't need to successfully sort the empty array for an M, but you do need to sort it for an R.

Here's how we might use `SortTools` for timing. You'll note that it also tests after timing.

```text
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.main.SortTools time edu.grinnell.csc207.sorting.InsertionSorter
Timing of edu.grinnell.csc207.sorting.InsertionSorter
	Size	Time (in milliseconds)
	1000	3
	2006	6
	4019	7
	8041	31
	16087	117
	32179	471
Testing of edu.grinnell.csc207.sorting.InsertionSorter
  Successfully sorted empty array.
  SUCCESS!
```

Here's an example of it testing a non-working sort routine. Note that we only see one failure.

```text
$ mvn compile -q
$ java -cp target/classes edu.grinnell.csc207.main.SortTools test edu.grinnell.csc207.sorting.FakeSorter
Testing of edu.grinnell.csc207.sorting.FakeSorter
  Successfully sorted empty array.
  Failed on reverse-sorted array.
  source: [64, 62, 62, 60, 60, 60, 60, 60, 60, 59, 57, 57, 57, 57, 57, 55, 55, 54, 52, 52, 52, 52, 52, 51, 51, 50, 50, 48, 48, 47, 47, 46, 44, 44, 44, 42, 40, 38, 38, 37, 36, 36, 36, 34, 32, 32, 32, 30, 29, 28, 26, 25, 25, 25, 24, 22, 21, 19, 18, 17, 16, 16, 14, 13, 12, 11, 9, 9, 7, 5, 5, 4, 4, 3, 2, 2, 2, 1, 0]
  result: [64, 62, 62, 60, 60, 60, 60, 60, 60, 59, 57, 57, 57, 57, 57, 55, 55, 54, 52, 52, 52, 52, 52, 51, 51, 50, 50, 48, 48, 47, 47, 46, 44, 44, 44, 42, 40, 38, 38, 37, 36, 36, 36, 34, 32, 32, 32, 30, 29, 28, 26, 25, 25, 25, 24, 22, 21, 19, 18, 17, 16, 16, 14, 13, 12, 11, 9, 9, 7, 5, 5, 4, 4, 3, 2, 2, 2, 1, 0]
  sorted: [0, 1, 2, 2, 2, 3, 4, 4, 5, 5, 7, 9, 9, 11, 12, 13, 14, 16, 16, 17, 18, 19, 21, 22, 24, 25, 25, 25, 26, 28, 29, 30, 32, 32, 32, 34, 36, 36, 36, 37, 38, 38, 40, 42, 44, 44, 44, 46, 47, 47, 48, 48, 50, 50, 51, 51, 52, 52, 52, 52, 52, 54, 55, 55, 57, 57, 57, 57, 57, 59, 60, 60, 60, 60, 60, 60, 62, 62, 64]
edu.grinnell.csc207.sorting.FakeSorter FAILED
```

You can also run it with just the name of the sorter class, provided it's in package `edu.grinnell.csc207.sorting`.

```
$ java -cp target/classes edu.grinnell.csc207.main.SortTools test MergeSorter
Testing of edu.grinnell.csc207.sorting.MergeSorter
  Successfully sorted empty array.
  SUCCESS!

Here's how we can run a competition between two sorting routines.

```text
Testing sorters
Computing useful array sizes

Round 1 (randomized, size 79402)
  edu.grinnell.csc207.sorting.InsertionSorter: 3738
  edu.grinnell.csc207.sorting.SelectionSorter: 4888

Round 2 (slightly randomized, size 78203)
  edu.grinnell.csc207.sorting.InsertionSorter: 1022
  edu.grinnell.csc207.sorting.SelectionSorter: 4317

Round 3 (randomized, size 60886)
  edu.grinnell.csc207.sorting.InsertionSorter: 2250
  edu.grinnell.csc207.sorting.SelectionSorter: 3029

Round 4 (slightly randomized, size 56614)
  edu.grinnell.csc207.sorting.InsertionSorter: 479
  edu.grinnell.csc207.sorting.SelectionSorter: 2292

Round 5 (slightly randomized reverse sorted, size 60964)
  edu.grinnell.csc207.sorting.InsertionSorter: 4115
  edu.grinnell.csc207.sorting.SelectionSorter: 2666

Round 6 (slightly randomized reverse sorted, size 67648)
  edu.grinnell.csc207.sorting.InsertionSorter: 5023
  edu.grinnell.csc207.sorting.SelectionSorter: 3076

Round 7 (slightly randomized, size 78649)
  edu.grinnell.csc207.sorting.InsertionSorter: 960
  edu.grinnell.csc207.sorting.SelectionSorter: 4060

Round 8 (slightly randomized reverse sorted, size 50745)
  edu.grinnell.csc207.sorting.InsertionSorter: 2831
  edu.grinnell.csc207.sorting.SelectionSorter: 1733

Round 9 (sorted, size 53293)
  edu.grinnell.csc207.sorting.InsertionSorter: 1
  edu.grinnell.csc207.sorting.SelectionSorter: 1794

Round 10 (randomized, size 57225)
  edu.grinnell.csc207.sorting.InsertionSorter: 1957
  edu.grinnell.csc207.sorting.SelectionSorter: 2454

Final results
edu.grinnell.csc207.sorting.InsertionSorter: 22376
edu.grinnell.csc207.sorting.SelectionSorter: 30309

The winner is edu.grinnell.csc207.sorting.InsertionSorter
```

As you can see, it's chosen a size in which both sorting routines take a few seconds on most inputs. It then chooses a variety of types of arrays and asks each to sort the same array, reporting on the time. In this particular case, you can also see that `InsertionSorter` does particularly poorly on reverse sorted arrays and slightly randomized reverse sorted arrays, but incredibly well on already sorted or only slightly randomized arrays.

Here's a competition between all of the sorting routines I've written in my solutions for this assignment. (I still have to design a faster one.)

```text
$ java -cp target/classes edu.grinnell.csc207.main.SortTools compete InsertionSorter SelectionSorter Quicksorter Quicksorter2 MergeSorter
Testing sorters
Computing useful array sizes

Round 1 (sorted, size 73068)
  edu.grinnell.csc207.sorting.InsertionSorter: 1
  edu.grinnell.csc207.sorting.SelectionSorter: 3311
  edu.grinnell.csc207.sorting.Quicksorter: 22
  edu.grinnell.csc207.sorting.Quicksorter2: 4
  edu.grinnell.csc207.sorting.MergeSorter: 5

Round 2 (randomized, size 74513)
  edu.grinnell.csc207.sorting.InsertionSorter: 3212
  edu.grinnell.csc207.sorting.SelectionSorter: 4389
  edu.grinnell.csc207.sorting.Quicksorter: 8
  edu.grinnell.csc207.sorting.Quicksorter2: 7
  edu.grinnell.csc207.sorting.MergeSorter: 10

Round 3 (randomized, size 73558)
  edu.grinnell.csc207.sorting.InsertionSorter: 3314
  edu.grinnell.csc207.sorting.SelectionSorter: 4205
  edu.grinnell.csc207.sorting.Quicksorter: 8
  edu.grinnell.csc207.sorting.Quicksorter2: 9
  edu.grinnell.csc207.sorting.MergeSorter: 10

Round 4 (slightly randomized reverse sorted, size 76333)
  edu.grinnell.csc207.sorting.InsertionSorter: 6118
  edu.grinnell.csc207.sorting.SelectionSorter: 4068
  edu.grinnell.csc207.sorting.Quicksorter: 7
  edu.grinnell.csc207.sorting.Quicksorter2: 7
  edu.grinnell.csc207.sorting.MergeSorter: 7

Round 5 (randomized, size 51110)
  edu.grinnell.csc207.sorting.InsertionSorter: 1489
  edu.grinnell.csc207.sorting.SelectionSorter: 2008
  edu.grinnell.csc207.sorting.Quicksorter: 5
  edu.grinnell.csc207.sorting.Quicksorter2: 4
  edu.grinnell.csc207.sorting.MergeSorter: 6

Round 6 (randomized, size 54665)
  edu.grinnell.csc207.sorting.InsertionSorter: 1700
  edu.grinnell.csc207.sorting.SelectionSorter: 2312
  edu.grinnell.csc207.sorting.Quicksorter: 5
  edu.grinnell.csc207.sorting.Quicksorter2: 6
  edu.grinnell.csc207.sorting.MergeSorter: 7

Round 7 (randomized, size 55521)
  edu.grinnell.csc207.sorting.InsertionSorter: 1802
  edu.grinnell.csc207.sorting.SelectionSorter: 2391
  edu.grinnell.csc207.sorting.Quicksorter: 6
  edu.grinnell.csc207.sorting.Quicksorter2: 5
  edu.grinnell.csc207.sorting.MergeSorter: 8

Round 8 (slightly randomized, size 68808)
  edu.grinnell.csc207.sorting.InsertionSorter: 686
  edu.grinnell.csc207.sorting.SelectionSorter: 3176
  edu.grinnell.csc207.sorting.Quicksorter: 25
  edu.grinnell.csc207.sorting.Quicksorter2: 5
  edu.grinnell.csc207.sorting.MergeSorter: 6

Round 9 (slightly randomized reverse sorted, size 79731)
  edu.grinnell.csc207.sorting.InsertionSorter: 6725
  edu.grinnell.csc207.sorting.SelectionSorter: 4286
  edu.grinnell.csc207.sorting.Quicksorter: 7
  edu.grinnell.csc207.sorting.Quicksorter2: 6
  edu.grinnell.csc207.sorting.MergeSorter: 6

Round 10 (randomized, size 72730)
  edu.grinnell.csc207.sorting.InsertionSorter: 3403
  edu.grinnell.csc207.sorting.SelectionSorter: 4040
  edu.grinnell.csc207.sorting.Quicksorter: 8
  edu.grinnell.csc207.sorting.Quicksorter2: 8
  edu.grinnell.csc207.sorting.MergeSorter: 9

Final results
edu.grinnell.csc207.sorting.InsertionSorter: 28450
edu.grinnell.csc207.sorting.SelectionSorter: 34186
edu.grinnell.csc207.sorting.Quicksorter: 101
edu.grinnell.csc207.sorting.Quicksorter2: 61
edu.grinnell.csc207.sorting.MergeSorter: 74

The winner is edu.grinnell.csc207.sorting.Quicksorter2
```

Unsurprisingly, the $$O(nlogn)$$ algorithms are much faster.

We'll get much bigger arrays if we only compare those three.

```text
$ java -cp target/classes edu.grinnell.csc207.main.SortTools compete Quicksorter Quicksorter2 MergeSorter
Testing sorters
Computing useful array sizes

Round 1 (slightly randomized, size 4877090)
  edu.grinnell.csc207.sorting.Quicksorter: 694
  edu.grinnell.csc207.sorting.Quicksorter2: 655
  edu.grinnell.csc207.sorting.MergeSorter: 1794

Round 2 (reverse sorted, size 4414278)
  edu.grinnell.csc207.sorting.Quicksorter: 445
  edu.grinnell.csc207.sorting.Quicksorter2: 443
  edu.grinnell.csc207.sorting.MergeSorter: 1913

Round 3 (slightly randomized reverse sorted, size 4855630)
  edu.grinnell.csc207.sorting.Quicksorter: 736
  edu.grinnell.csc207.sorting.Quicksorter2: 732
  edu.grinnell.csc207.sorting.MergeSorter: 1823

Round 4 (reverse sorted, size 4390436)
  edu.grinnell.csc207.sorting.Quicksorter: 428
  edu.grinnell.csc207.sorting.Quicksorter2: 420
  edu.grinnell.csc207.sorting.MergeSorter: 2174

Round 5 (randomized, size 4158872)
  edu.grinnell.csc207.sorting.Quicksorter: 953
  edu.grinnell.csc207.sorting.Quicksorter2: 923
  edu.grinnell.csc207.sorting.MergeSorter: 1735

Round 6 (randomized, size 4129192)
  edu.grinnell.csc207.sorting.Quicksorter: 868
  edu.grinnell.csc207.sorting.Quicksorter2: 935
  edu.grinnell.csc207.sorting.MergeSorter: 1958

Round 7 (slightly randomized, size 3906487)
  edu.grinnell.csc207.sorting.Quicksorter: 519
  edu.grinnell.csc207.sorting.Quicksorter2: 505
  edu.grinnell.csc207.sorting.MergeSorter: 1450

Round 8 (randomized, size 3143312)
  edu.grinnell.csc207.sorting.Quicksorter: 641
  edu.grinnell.csc207.sorting.Quicksorter2: 654
  edu.grinnell.csc207.sorting.MergeSorter: 1469

Round 9 (randomized, size 4597214)
  edu.grinnell.csc207.sorting.Quicksorter: 1067
  edu.grinnell.csc207.sorting.Quicksorter2: 1087
  edu.grinnell.csc207.sorting.MergeSorter: 2246

Round 10 (slightly randomized reverse sorted, size 4707121)
  edu.grinnell.csc207.sorting.Quicksorter: 809
  edu.grinnell.csc207.sorting.Quicksorter2: 841
  edu.grinnell.csc207.sorting.MergeSorter: 2126

Final results
edu.grinnell.csc207.sorting.Quicksorter: 7160
edu.grinnell.csc207.sorting.Quicksorter2: 7195
edu.grinnell.csc207.sorting.MergeSorter: 18688

The winner is edu.grinnell.csc207.sorting.Quicksorter
```

Wasn't that thrilling?

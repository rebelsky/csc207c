---
title: Heaps and heapsort
repo: <https://github.com/Grinnell-CSC207/lab-heaps>
summary: |
  We build heaps and use heap sort.
---
Preparation
-----------

Fork and clone the repository at {{ page.repo }}.  Import it into VSCode.

Exercises
---------

### Exercise 0: Code Reading

Scan through `Heaps.java` so that you understand what methods are available and what approaches are used.  Make notes on areas that are likely to be problematic or that have to be implemented.

What methods are not yet implemented?

### Exercise 1: Dumping hash tables

Review the various `dump` methods in `Heaps.java`. Review the `HeapExperiment.java` class.

a. When we dump a heap, is the left subtree below the line for the root or above?

b. Given that we haven't implemented `heapUp` or `heapDown`, what should our heap look like after each step as we add the strings `"d"`, `"e"` `"b"` `"f"` `"a"` `"h"`, `"i"`, `"c"`, and `"g"`, in that order?

c. Run the following command to see if you get the same results.

```
java HeapExperiment d e b f a h i c g
```

### Exercise 2: Swapping up

As you may recall, we add an element to the heap by adding at the end of the last row of the heap and then "swapping up", repeatedly swapping a value and its parent if they are out of order. In our code, we call this operation `heapUp`.

a. Implement `heapUp`.

b. Now that we've implemented `heapUp`, what should our heap look like after each step as we add the strings `"d"`, `"e"` `"b"` `"f"` `"a"` `"h"`, `"i"`, `"c"`, and `"g"`, in that order?

c. Run the following command to see if you get the same results.

```
java HeapExperiment d e b f a h i c g
```

### Exercise 3: Swapping down

As you may recall, we remove the highest-priority element in the heap by grabbing the root, swapping the last element on the last level to the top of the heap, and then "swapping down", repeatedly swapping a value and its larger cuild as long as they are out of order. In our code, we call this operation `heapDown`.

a. Implement `heapDown`.

b. Now that we've implemented `heapDown`, what should our heap from the previous exercise look like as we remove each element in the heap?

c. Run the following command to see if you get the same results.

```
java HeapExperiment d e b f a h i c g
```

### Exercise 4: Re-organizing WCAG accessibility guidelines

The [Web Content Accessibility Guidelines](https://www.w3.org/TR/WCAG21/) are a collection of recommendations from the World Wide Web Consortium (W3C) on how to make Web content more accessible to people with disabilities, including blindness or low vision, deafness or difficulty hearing, limited movement, speech disabilities, photosensitivity, and learning disabilities. For each guideline, such as,

> _Guideline 2.4 Navigable_: Provide ways to help users navigate, find content, and determine where they are

there are a variety of success criteria, such as

> _Success Criterion 2.4.2 Page Titled_: Web pages have titles that describe topic or purpose.

Each sucess criterion also has an associated [level of conformance](https://www.w3.org/WAI/WCAG21/Understanding/conformance#levels): A (lowest), AA, or AAA (highest). If I'm not mistaken, Grinnell strives for AA conformance on all of its Web pages.

Our friends in the A11y in CS project have created a text file with the accessibility criteria. You can find a modified version of the file in `accessibility-criteria.txt` in the lab repo. You can also find a class called `AccessibilityCriterion.java` that lets us represent each criterion. That class also provides a static method called `AccessibilityCriterion.standardCriteria()` that lets you iterate the standard criteria. You can see the `main` method for how you might use that method.

a. Instead of printing out the criteria by number, we might want to print them by name. An easy approach is to add them all to the heap with a comparator that will order them by name and then read them out. Implement that approach in `ACByName.java`.

b. We might also want to order them by level (printing the A's, then the AA's, then the AAA's). Implement that approach in `ACByLevel.java`.

### Exercise 5: Heap sort

As you've just seen, we can use a heap for sorting. Rather than printing in sorted order, we might put values back into the array in sorted order. (CLRS tell us how to do that

Finish the implementation of `HeapSorter.java`.

### Exercise 6: Heapifying

In order for `HeapSorter` to work, the `Heap(ArrayList, Comparator)` method must convert an arbitrary ArrayList into a heap, a process we refer to as "heapifying" the ArrayList. If you look at `Heap.java`, you will see that there are two implementations of `heapify`.

a. Make sure that you can explain how each version works.

b. Most people find `heapifySamR` easier to understand than `heapifyCLRS`. Why would we prefer `heapifyCLRS`?

For those with extra time
-------------------------

If you have extra time, see if you can find a way to sort an ArrayList "in place", swapping the largest value to the appropriate place in the ArrayList.

Acknowledgements
----------------

The idea of using WCAGs as a data source for heaps, as well as some of the text describing WCAGs and the data file, come from the _A11y in CS_ project.

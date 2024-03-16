---
title: "Eboard 24: Sorting"
number: 24
section: eboards
held: 2024-03-15
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Check in on Wednesday's class 
* Some notes on sorting 
* Testing sorting algorithms 
* Loop invariants 

Preliminaries
-------------

* Registration preview

### Upcoming work

* Friday, 2024-03-15, 11pm, Third set of LAs.
    * Mostly posted. 
    * Let me know if any look wrong.
    * Let me know if you'd like to see any others posted.
    * Grading is still on my priority queue, near the front.

### Tokens

Academic/Scholarly

Cultural

* Friday at 4pm in the Global Living Room.
  _Middle of Everywhere_.
    * I don't know whether or not that's happening.

Peer

Wellness

Misc

### Other good things to do (no tokens)

### Spring Break PSA

* You are awesome. Please take care of yourselves.
* And don't get me fired for sharing information with you.

Check in on Wednesday
---------------------

What did you learn?

* Merge sort.
* Merge algorithm: Merge two sorted lists (or subarrays)
* Merge sort - If the list has more than one element, divide the unsorted 
  list in half, sort the two halves, merge them together.
* Can I merge in place (e.g., [1 ,4, 6, 9, 2, 3, 5, 8])?
    * Nope. I need to make a helper array to copy things into.
    * This is a disadvantage of merge sort: It requires O(n) extra space.
* Do I have to use merge sort when I sort each subarray?
    * Nope.
* How do you prove it correct?
    * Experimentally, we run tests
    * We could do a proof. With invariants.
* Is merge sort stable? 
    * Stable: If there are two "equal" elements, they maintain their order.
      (That may have been in the reading.)
    * No: It depends a bit on how you merge.
    * Can we decide on an approach that maintains stability? Yes!
      When we merge, always take the element from the left array first.

Some notes on sorting
---------------------

* Stability
* We all sort all the time.
    * MSort: Divide the cards into two piles: Sorted and Unprocessed.
      For each card in unprocessed, put it into the right place in sorted.
    * ASort: Similar, with a probabilistic (ML-based) approach for finding
      the right location.
    * Insertion sort
* Analysis of insertion sort (incorrect)
    * We have to insert `n` cards from unprocessed list into the sorted
      list.
    * Finding the right location takes O(logn) time because we can use
      binary search.
    * Inserting it into that position is constant time.
    * This algorithm is O(nlogn).
* Why is this incorrect? (Hint: It may be O(nlogn) in the physical world,
  but not in the computer world.)
    * If the data are stored in an array, it will take O(n) to insert,
      not O(1) because you have to shift stuff over to make room.
    * If the data are stored in a link list, it only takes O(1) to insert
      once you've found the spot, but be can't use binary search on lists,
      since binary search requires quick access based on index.
* Analysis: O(n^2) for arrays because O(n) to insert.
* Analysis: O(n^2) for lists because O(n) to find.
* Reminder: Once you've correctly analyzed an algorithm, you have two questions
  to ask:
    * Can I do better?
    * If not: Can I prove that I can't do better?
* Detour: For the "can I prove", Travelling Salescritter Problem
    * Given a set of `n` cities, find the shortest path connecting them all.
    * Easy solution: Make a list of all the paths, take the shortest.
    * Unfortunately, there are O(n!) paths, which grows way too quickly.
* In 301, you'll get to consider whether a sorting algorithm can be faster
  than O(nlogn). (Preview: Not for a compare/swap algorithm.)
* In 341, you'll get to explore questions like TSP.
* For insertion sort's "can I do better"
    * Design a different algorithm
    * Design a new data structure, one that has both quick insertion and
      quick searching.
* A better data structure: The binary search tree
    * A binary tree is a structure in which you have a node (with a value), 
      left subtree, and right subtree.
    * Usually the left subtree has values less than the node and the
      right subtree has values greater than the node.
    * Both left and right subtrees have the same property.
* If the tree is mostly balanced (that is, we have left and right subchildren
  at most levels; the two subtrees are about the same size ), the number 
  of levels is O(logn).
* Search is O(logn)
* Insert is O(logn)
* Maintaining the property is hard.
* We will return to this issue in a few weeks.

Testing sorting algorithms
--------------------------

You've written a sorting algorithm. Proofs are hard. You want tests.
What kind of "write lots of tests" algorithm would you write?

* Systematically
* Random

Systematically

* Use for loops to build arrays of different sizes
* For each size array

Random

* Use a for loop to build arrays of different sizes
* Sort each
* And make sure it's in order AND a permutation of the original

Sam's Sorting algorithm (which gives you an array in order)

```
public static <T> T samSort(T[] values, Comparator<T> order) {
  for (int i = 1; i < values.length; i++) {
    values[i] = values[0];
  }
} // samSort
``

More ideas

* Start with a sorted array.
* Permute it (or permute a copy) [shuffle; rearrange]
* Sort the permutation
* Compare the two arrays.

Even more

* Start with a sorted array.
* Sort it.
* See if it's the same. (Some non-stable sorting algorithms will rearrange
  equal elements, so for this, we want to ensure that equal elements are
  treated as equal.)

Whoops!

Loop invariants
---------------

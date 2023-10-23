---
title: "EBoard 23: Sorting out sorting"
number: 23
section: eboards
held: 2023-10-23
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.
It's probably also being transcribed.

_Approximate overview_

* Administrivia
* Questions
* The problem of sorting
* Testing sorting algorithms
* Insertion sort
* Selection sort

Administrivia
-------------

* Welcome back!  I hope you had wonderful breaks and that you are not broken.
* Yay!  Class 23 is on the 23rd.  I'm not sure what that signifies, but I'm
  somehow pleased.
* Registration starts somewhat soon.  Consider going on to CSC-161.
    * Check the priority registration page at <https://grinco.sharepoint.com/sites/Registrars_Office/SitePages/PriorityRegistration.aspx> for our latest registration processes.

### Upcoming Token activities

Academic

* CS Table, Tuesday, The Open Web, Noon, Day PDR
    * Tim Berners-Lee. Information Management: A Proposal. CERN. March 1989, updated May 1990. <https://www.w3.org/History/1989/proposal.html>
    * Hossein Derakhshan. The Web We Have to Save. Matter. July 14, 2015. <https://medium.com/matter/the-web-we-have-to-save-2eb1fe15a426> (login required)
    * Copies available outside 3827 and 3809.
* CS Extras, Thursday, ???

Cultural

* Latin Cocktail, Tomorrow, 7pm, Herrick
* Film tonight (Želimir Žilnik presentation)

Peer

* Men's soccer vs. Monmouth, Wednesday, 4pm
* Men's soccer vs. Lawrence, Saturday, 1:30pm
* Cross Country MWC Championships, Saturday, 10am

Wellness

* Therapy dogs, today 4pm.

Misc

### Other good things (no tokens)

* Women's soccer, Tuesday, 4pm
* Women's soccer, Saturday, 11am

### Upcoming work

* Readings for Wednesday on sorting.
* MP6 to be assigned on Wednesday.  "Implement the best damn sorting
  algorithm that you can.  Read TimSort for details."  It will be due
  a week from Thursday.

Questions
---------

_Sam did not record the questions about registration._ 

The problem of sorting
----------------------

### Basics

_What does it mean to sort?_

Many things:

* To put a list of things into an order.
* Human beings also use "sort" to mean "categorize" (put into groups).

In CS, we usually mean "put things in order".

What kinds of things do we sort?

* Collections
* That can be iterated
* Of things that we can compare.
* Usually these are "arrays".

### Java, form

_What should a sorting method signature look like in Java?_

```
public ___ ___ ... sort(T[] values, Comparator<? super T>, ...)
```

What in heck does `<? super T>` mean?

* The angle brackets are used for generics and mean ...
    * `AssociativeArray<String,Person> classlist;`
    * The angle brackets specify the particular type to use instead
      of a generic type.
    * Sam calls these "type parameters"
* If we had written `Comparator<T>`, we'd know that it means "things
  that compare T values".
* Ah, the wonders of Java.
    * Suppose we write a `Fraction` class.  We might write a comparator
      for Fractions

```
public class FractionComparator implements Comparator<Fraction> {
  public int compare(Fraction f1, Fraction f2) {
    BigInteger tmp1 = f1.numerator().multiply(f2.denominator());
    BigInteger tmp2 = f2.numerator().multiply(f1.denominator());
    return tmp1.compareTo(tmp2);
  } // compare
} // FractionComparator
```

Now, suppose we've decided to extend our `Fraction` class.

```
public class BetterFraction extends Fraction {
  // ...
} // BetterFraction
```

Can I apply `FractionComparator` objects to two `BetterFraction` values?

```
BetterFraction f1 = ...;
BetterFraction f2 = ...;
FractionComparator fc = new FractionComparator();
if (fc.compare(f1,f2) == 0) {
  System.err.println("f1 and f2 are the same");
}
```

Yes!  Subtype polymorphism says that if a procedure can accecpt type
X as input, it can also accept any subclass of X (or subclass or subclass
of X or ...).

Back to

```
public ___ ___ ... sort(T[] values, Comparator<? super T>, ...)
```

We can sort an array of `BetterFraction` values using `FractionComparator`.
However, `FractionComparator` is *not* a `Comparator<BetterFraction>`,
it's a `Comparator<Fraction>`.

`<? super T>` is Java's way of handling that situation.  It says that we
can use a `Compator<T>` or a comparator of a superclass of T, or a comparator
of a superclass of a superclass of T, or ...

It will also work for any interfaces T implements.

Comparators are functional interface ...

* We often build comparators with lambdas.

Here's what we have so far.

```
public ___ ___ ... sort(T[] values, Comparator<? super T>, ...)
```

* We don't seem have any other necessary parameters.
* Design decision: We're going to sort in place, so we return void.

```
public ___ ___ void sort(T[] values, Comparator<? super T>)
```

If we put `sort` in a class (e.g., `Sortable`, we probably don't need
any other modifiers.

```
public interface Sorter<T> {
  public void sort(T[] values, Comparator<? super T>);
} // interface Sorter<T>
```

However, if we make `sort` a static method, ...

```
public static ___ void sort(T[] values, Comparator<? super T>)
```

we do need something between `static` and `void`.

```
public static <T> void sort(T[] values, Comparator<? super T>)
```

We will focus on using the interface (or a variant thereof).

### Validation, conceptual

_How do you now that a particular sort has succeeded? (in English)_

(Not the algorithm, but the results of having sorted.)

What do you know about the result?

"It's a sorted version of the original array."

That is, the values appear in the order given by the comparator.

Do we need to ensure anything else (other than that the values appear in
the order given by the compareator)?

Hypothesis S: If we sort again, nothing should change.

Question regarding hypothesis S: If I sort strings by length, and only
by length and I do not require that the sort is stable.  What should 
I get for the array `{ "hello", "alpha", "gamma" }`?

Answer: Any order.

Critique of Hypothesis S: A valid sorting algorithm may still rearrange
equal elements.

Do we need to ensure anything else (other than that the values appear in
the order given by the comparator)?

We shouldn't make a new array (may be implied by the signature) .

```
public static <T> void badSort(T[] values, Comparator<? super T> compare) {
  for (int i = 1; i < values.length; i++) {
    values[i] = values[0];
  } // for
} badSort
```

We normally require that we neither add new elements nor remove existing
elements.  That is, the resulting array is a permutation of the original
array.

### Validation, programatic

_How do you now that a particular sort has succeeded? (in Java)_

```
Fraction[] stuff = { ... };
FractionCompator fc = new FractionComparator()
sort(stuff, fc);
```

We can validate the "in-order" property by going through the whole array,
using the comparator to check neighboring values.

```
for (int i = 0; i < stuff.length-1; i++) {
  if (fc.compare(stuff[i], stuff[i+1]) > 0) {
    System.err.println("The sort failed");
    break; // Make Prof. Johnson cry along with those whose classes got changed.
  }
} 
```

We can validate the "is a permutation" property with ...

### Design

_What approaches do we have to design sorting algorithms?_

* Do it by hand, and then try to generalize what you did.
* Think about similar problems you've solved before, and adapt those
  solutions.

Warning!  At the start of the next class, I'll ask you about other
approaches you use when you have to design an algorithm.

* Not acceptable: "Use ChatGPT".  "Google" (or "Bing" or "DuckDuckGo" or "Altavista" or "StackOverflow" or "Ask Pom" or ...)

### Issues

_What restrictions might we put on a sorting algorithm?_

* We might make it `stable`, requiring that equal values maintain their
  order.

Testing sorting algorithms
--------------------------

_What kinds of tests can you run to ensure that your sorting algorithm works correctly?_

Insertion sort
--------------

Selection sort
--------------

Detour: The Dutch National Flag problem
---------------------------------------

You have an array with three values, which we’ll call red, white,
and blue. They are in no particular order. Your goal is to rearrange
it so that all of the red are at the left, all the blue are at the
right, and all the white are in between.  

_You may not simply count the values; different reds represent different
objects (similarly for blues and whites)._

Sample input:

```
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
| Ba | Rb | Wc | Wd | Re | Bf | Wg | Rh | Wi | Wj | Wk | Rl | Wm | Bn | Bo | Wp | Rq |
+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+----+
```

### Design

How do you approach the problem?

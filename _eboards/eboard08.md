---
title: "EBoard 08: Subtype polymorphism"
number: 8
section: eboards
held: 2023-09-11
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Approximate overview_

* Expandable arrays, continued
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* I've added a link to the example code I'm writing as we go.  I'll 
  leave it up to you to figure out what is what.

### Upcoming Token activities

Academic

* CS Table, Tuesday, Noon, Day PDR.  ???
* CS Extras, Thursday, 4:15 pm, Science 3821.  ???
* Sunday, 4-5pm, CS (Un)Commons

Cultural

Peer

Wellness

### Upcoming work

* Tonight: MP2 pre-assessment
* Wednesday (befeore class): Readings
* Thursday: MP2

Back to expandable arrays
-------------------------

### PUM

**Philosophy**: Like an array, but automatically "expands" if we set something
beyond the assumed "size" of the array.

**Use Cases**: Similar to those for which we use arrays.  

* Students indexed by id number.
* Cities indexed by zip code.
* Any collection of values that we may want to add to and rearrange (e.g., 
  to sort)

**Methods** (minimalist): An expandable array might provide three primary 
methods.

* `String ExpandableArray(String default)` - Create a new expandable array
  of the specified size.
* `void set(int index, String val)` - Set the value at the given index to
  `val`.
* `String get(int index)` - If we've set something at the given index using
  `set`, return that value.  Otherwise, return `default`.

We might also provide a few other basic methods

* `void addToEnd(String val)` - add to the end of the "useful" values
* `int size()` - 1 + index of largest value stored

_Reminder_: At first, only add the methods that (a) make sense within the
context of the purpose and (b) cannot be implemented by the other methods
you've written.

One could argue that once you have `size()`, you no longer need `addToEnd()`.

* `arr.addToEnd(val) = arr.set(arr.size(), val);`

### LIA

**Layout**: We're storing the array as a normal array.  We'll have to 
  allocate a bigger underlying array when it expands.

What fields do you want in the class?

```java
public class ExpandableStringArray {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The "size"; the largest index used so far.
   */
  int size;

  /**
   * The underlying array.
   */
  String[] values;

  /**
   * The default value (used for cells that haven't been set).
   */
  String default;

} // class ExpandableStringArray
```

**Implementation**

* How will you implement `get`?
* How will you implement `set`?
* How will you implement your constructor?

**`get`**

```
  public String get(int i) {
    return "":  // STUB
  } // get(int)
```

**`set`**

```
  public void set(int i, String val) {
    // Stub
  } // set(int, String)
```

**Constructor**

**Assessment**

Lab
---

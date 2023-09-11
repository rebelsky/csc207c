---
title: "EBoard 08: Example: Expandable Arrays"
number: 8
section: eboards
held: 2023-09-11
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Approximate overview_

* Administrivia
* Expandable arrays, continued

Administrivia
-------------

### Introductory notes

* I've added a link to the example code I'm writing as we go.  I'll 
  leave it up to you to figure out what is what.  (If you really need
  a guide, let me know.)
* I may have screwed up the code on today's lab.  Let me know.

### Upcoming Token activities

Academic

* CS Table, Tuesday, Noon, Day PDR.  ??? (something about ChatGPT?)
* CS Extras, Thursday, 4:15 pm, Science 3821.  ???
* Thursday 14 Sept 2023, 6pm, "Microsoft Campus Visit" (HSSC Kernel/A1231)
* Sunday, 4-5pm, CS (Un)Commons, Mentor Session

Cultural

* Thursday 14 Sept 2023, 8pm, Writers @ Grinnell w/Claire Forrest '13

Peer

Wellness

Misc

* Friday 15 Sept 2023, Noon, Whale Room, Lunch with Young Alums in Tech

### Upcoming work

* Tonight: MP2 pre-assessment
* Thursday: MP2

Questions
---------

Back to expandable arrays
-------------------------

Expandable array code: [ExpandableStringArray.java](../examples/expandable-arrays//grinnell/csc207/fa2023/ExpandableStringArray.java)

Our experiments: [ESAexpt.java](../examples/expandable-arrays/ESAexpt.java)

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
* `int size()` : 1 + largest index used

_Reminder_: At first, only add the methods that (a) make sense within the
context of the purpose and (b) cannot be implemented by the other methods
you've written.

One could argue that once you have `size()`, you no longer need `addToEnd()`.

* `arr.addToEnd(val) = arr.set(arr.size(), val);`

### LIA

**Layout**: We're storing the array as a normal array.  We'll have to 
  allocate a bigger underlying array (and copy things over) when it 
  needs to expand.

Good alternate idea: A linked list of arrays.

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
* How will you implement `size()`?
* How will you implement `addToEnd()`? (Done)

**`get`**

* Idea: If i < this.size(), just get values[i].
* Idea: If i >= this.size(), allocate a larger array and copy things
  over.  (Seems like overkill.)
* Idea: If i >= this.size() (or i >= this.values.length), return
  a special value ... null? (default)
* Question: What should we do for negative indices?  We don't normally
  allow those to be set, but for get, we can either crash and burn 
  (throw an Exception) or return the default.

```
  public String get(int i) {
    if ((i < 0) || (i > this.values.length)) {
      return this.default;
    } else {
      return this.values[i]; 
    } // if ... else
  } // get(int)
```

**`set`**

* Note: If i is greater than this.values.length, we need to expand
  the array.
* Since we're expanding the array and we rely on `default`
  being in all the unset locations, we need to put it ther.
* We also need to update this size.

```
  public void set(int i, String val) {
    // If the index is too large
    if (i > this.values.length) {
      // Build a new array and copy it over
      String[] newvalues = new String[i+1];
      for (int j = 0; j < this.values.length; j++) {
        newvalues[j] = this.values[j];
      } // for
      for (int j = this.values.length; j < i; j++) {
        newvalues[j] = this.default;
      } // for 
      this.values = newvalues;
    } // if
    this.values[i] = val;
    this.size = max(this.size, i+1);
  } // set(int, String)
```

**Constructor**

```
  private static final int INITIAL_ARRAY_SIZE = 16;

  public ExpandableStringArray(String default) {
    this.values = new String[INITIAL_ARRAY_SIZE];
    this.default = default;
    this.size = 0;
    for (int i = 0; i < this.values.length; i++) {
      this.values[i] = default;
    } // for
  } // ExpandableStringArray
```

**`size`**

```
/**
 * Get the size (1 + the largest index used for set).
 */
public int size() {
  return this.size;
}
```

Note: The code above is not correct.  We made some changes in the example.
Look [there](../examples/expandable-arrays/grinnell/csc207/fa2023/ExpandableStringArray.java).

**Analysis**

* About how many steps do we do in each of the methods (as a function
  of the parameters).
    * Constant: It doesn't depend on the parameters
    * Linear: One step for each parameter (or for a numeric parameter).
* Constructor: constant.  Always the same time.
* Get: constant.
* Size: constant.
* Set: Sometimes constant (if i < this.values.length), sometimes
  linear in i.

We skipped over an important design decision.  When expanding the array,
how much should we expand it?

* Option 1: new size is `i + 1`
* Option 2: new size is `this.values.length * 2`

Hint: There are flaws in both options.

* In option 1, you might expand a lot, particularly if you're doing
  something like 
    `for (int i = 0; i < 1000; this.addToEnd("" + i);`
* In option 2, you may be expanding much more than you need, which
  means a lot of effort setting them to default.
* In option 2, i might be greater than `this.values.length * 2`.

Our best option is either

* Option 3: `max(i+1, this.values.length*2)`
* Option 4: the smallest k that ensures that this.values.length*2^k > i

Important moral: Double array sizes if you need to expand them.  There's
a little extra expense now, but amortized over all the expansions, it's
much better than a constant size expansion.

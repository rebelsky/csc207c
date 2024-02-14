---
title: "Eboard 10: Generics"
number: 10
section: eboards
held: 2024-02-12
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Approximate overview_

* Administrivia
* Questions
* Lab

Preliminaries
-------------

* Sam broke his hearing aids and hears even less well than normal.
* If you see a repo with a `-2019` suffix, it's probably the wrong version
  of the lab and the wrong version of the repo.  Try reloading. 
* If you don't see self checks, I've probably forgotten to push the 
  latest version of a page. Let me know.

### Upcoming work

* 11pm Wednesday, 2024-02-14: [Mini Project 3](../mps/mp03)
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080604/)
* 11pm Thursday, 2024-02-15: Reading on Exceptions
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4090750)
* 1pm Friday, 2024-02-16: Wednesdays's lab writeup.
    * [_Submit on Gradescope_](https://www.gradescope.com/courses/690101/assignments/4080411/)

### Token

Academic/Scholarly

* Tuesday, 2024-02-13, noon--1:00pm, Some PDR.
  _CS Table: Functional programming_.
* Tuesday, 2024-02-13, 8:00--9:00pm, Science 3821.
  _CSC-207 Mentor Session_.
* Thursday, 2024-02-15, 11:00--noon, JRC 101.
  _Scholars' Convocation: Gaile Pohlhaus on "An Epistemology of 
   the Oppressed: Resisting and Flourishing under Epistemic Oppression"._
     * You can also talk to the speaker.
* Thursday, 2024-02-15, 4:00pm, Science 3821.
  _CS Extras: PM Osera_.

Cultural

* Thursday, 2024-02-15, 7:00--9:00pm, Sebring-Lewis.
  _Jazz Concert w/Carol Welsman_.
* Friday, 2024-02-16, 4:00--5:00pm, HSSC N1170 (Global Living Room).
  _Middle of Everywhere._
* Sunday, 2024-02-18, 7:00--9:00pm, Harris Cinema.
  _The Moth Storytelling Slam_.

Peer

* Friday through Sunday, 2024-02-16 through 2024-02-18. Osgood Pool.
  _Midwest Swimming and Diving Conference Championships_.
    * 30 minutes counts.
    * Up to two separate sessions.
* Saturday, 2024-02-17, 2:00--5:00pm, Field House.
  _Women's Tennis vs. Ottwawa_.

Wellness

* Monday, 2024-02-12, 4:00--5:00pm, HSSC Atrium.
  _Therapy dogs._
* Tuesday, 2024-02-13, noon-1pm, BRAC P103.
  _HIIT and Strength Fitness Class._
* Tuesday, 2024-02-13, 12:15--12:50, Bucksbaum 131.
  _Yoga in the Museum._
* Tuesday, 2024-02-13, 4pm, BRAC P103 (Multipurpose Dance Studio):
  _Yoga_.

Misc

* Monday, 2024-02-12, 4:30-5:30pm, JRC 101.
  _Talking about disability policy with Daniel Van Sant, Director
   of disability policy at the Harkin Institute._

### Good things to do (no tokens)

* Saturday, 2024-02-17, 1:00--3:00pm, Darby.
  _Men's Basketball vs. Monmouth_.
* Saturday, 2024-02-17, 3:00--5:00pm, Darby.
  _Women's Basketball vs. Monmouth_.

Questions
---------

### Administrative

### MP3

For #4, if the appearance is the same, but the process to build them
was different, are they `equal`, `eqv`, or `eq`?

For example, 

```
  TextBlock tb1 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));
  TextBlock tb2 = new HFlip(new HFlip(new TextLine("a")))));
  TextBlock tb3 = new TextLine("a");
```

> These three things are `equal` in that they appear the same.

> No two of these things are `eqv`; they were all built differently.

> No two of these things are `eq`; they all occupy different areas of
  memory.

Suppose we have `BlockInBox` that does exactly the same as `BoxedBlock`.
Tell me about the following.

```
  TextBlock box1 = new BoxedBlock(new TextLine("eh"));
  TextBlock box2 = new BlockInBox(new TextLine("eh"));
```

> The two things appear the same, so they are `equal`.

> The two things were built using different classes, so they are not `eqv`.

> And they probably occupy different things in memory.

Can we use the `getClass` method to determine the class of an object?

> Yes, something like that.

Can we compare classes with `==`?

> Yes.

If we horizontally compose X with the empty string, is it `eqv` to
horizontally composing the empty string with X?

> No.

What does it mean to give 'too much space' in truncated?

> Um ... I'd say > txt.width().

The Q&A is inconsistent with the text when dealing with `Trunacted` and
company`
.

> **You can do whatever you'd like for truncated, centered, and right
  justified blocks that have an inauspicious numeric parameter.**

How do you compare memory locations in Java.

> `==`

So `eq` is relatively trivial?

> Yes.

How are we testing things like `Truncated` and centered?

```
   @Test
   void testTruncated1() {
     assertEqual("+--", (new Truncated(3, new BoxedBlock(new TextLine("hello")))).row(0));
     assertEqual("|he", (new Truncated(3, new BoxedBlock(new TextLine("hello")))).row(1));
   } // testTruncated1()
```

Do we have to do testing for the math stuff from the lab?

> No.

How do we figure out how something has been created?

```
TextBlock tb = ...;

if (tb instanceof BoxedBlock) {
  ...
}
```

Could you explain the "require an `eqv` method in each class"?

> For example,

```
public interface TextBlock {
  ...
  /**
   * Determine if `other` is structurally equivalent
   * to this block.
   */
  public boolean eqv(TextBlock other);
} // interface TextBlock

public class BoxedBlock implements TextBlock {
  TextBlock block;
  ...
  public boolean eqv(TextBlock other) {
    return ((other instanceof BoxedBlock) &&
            this.block.eqv(((BoxedBlock) other).block));
  } // eqv(TextBlock other)
} // BoxedBlock

public class HFlip implements TextBlock {
  TextBlock flipme;
  ...
  public boolean eqv(TextBlock other) {
    return ((other instanceof HFlip) &&
            this.flipme.eqv(((HFlip) other).flipme));
  } // eqv(TextBlock)
```

```
  TextBlock tb1 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));
  TextBlock tb2 = new HFlip(new HFlip(new TextLine("a")))));
  TextBlock tb3 = new TextLine("a");
  TextBlock tb4 = new HFlip(new HFlip(new HFlip(new HFlip(new TextLine("a")))));
```

```
    tb1.eqv(tb3)
--> FALSE (because tb3 is not an hflip)

    tb1.eqv(tb2)
; We ask whether this.flipMe.eqv(other.flipMe)
;   this.flipMe = new HFlip(new HFlip(new HFlip(new TextLine("a"))));
;   other.flipMe = new HFlip(new TextLine("a")));
; Now we have to compare this.flipMe.flipMe.eqv(other.flipMe.flipMe)
```

> Sam shouldn't write code on the fly. He makes too many mistakes.
  He used to be better at it.

Do we need an `eqv` method in `TextLine`?

> Yup. You have to write it. 

Why did you cast `other` in the following?

```
            this.flipme.eqv(((HFlip) other).flipme));
```

> Java is dumb. Even though we've just established that `other` is an
  `HFlip`, it won't remember that. All it knows is that `other` is a
  `TextBlock`.  Since not all `TextBlock` objects have a `flipme`
  field, it won't allow you to grab that field.

> Note: If `other` is not an `HFlip` and you try to cast it as one, you'll
  get a runtime exception. (`ClassCastException`).

Why do we write

```
  public boolean eqv(TextBlock other) {
```

rather than

```
  public boolean eqv(HFlip other) {
```

> Because we want to compare to any textblock as part of our goal
  of implementing the static method `eqv(TextBlock foo, TextBlock bar)`.

Wouldn't it just return false by default?

> No. It would say "There's no method applicable to this parameter and
  refuse to compile.

### Interfaces and Subtype polymorphism

Are interfaces like header files in C?

> Sort of. Like header files they tell the client what capabilities
  (methods/procedures/functions) are there without explaining how they
  are implemented.

> Unlike header files, we often make more than one class that implements
  an interface.

> E.g., we might implement a `List` interface with a linked list and
  an array-based list, and a balanced-tree-based list, and ....  At
  different points in our program, we may choose to use different
  implementatoins.

### Generics

What is the difference between `ExpandableArray<String>` and `Predicate<T>`? 
Why is it `Predicate<T>` and not `Predicate<*type*>`?

> It all depends on context. When we're declaring objects, we need to include
  a type. When we're defining new generic classes or methods, we use the
  type variable.

How can we concretize the way the the `Function` interface is used in Java?

> There are three mechanisms, only one of which fits within your current
  knowledge: (a) We can build a new class that implements the `Function`
  interface; (b) We can build an _anonymous class_ that implements
  the `Function` interface, (c) we can build a _lambda expression_
  that implements the `Function` interface.

> We'll consider the situation in which we want a function to
  parenthesize a string and store it in a variable, `parenthesize`..

```
public class Parenthesize implements Function<String,String> {
  public String apply(String str) {
    return "(" + str + ")";
  } // apply(String)
} // class Parenthesize

...

  Function<String,String> parenthesize = new Parenthesize();
```

> Since all the `Parenthesize` objects will be the same, we might
  want to use a pattern called _Singleton_ in which we ensure that
  only one copy is ever created.

```
public class Parenthesize implements Function<String,String> {

  /**
   * The constructor is private to prevent others from using it.
   */
  private Parenthesize() {
  }

  /**
   * A function that parenthesizes strings.
   */
  public static final FUN = new Parenthesize();

  public String apply(String str) {
    return "(" + str + ")";
  } // apply(String)

} // class Parenthesize

...

  Function<String,String> parenthesize = Parenthesize.FUN;
```

> Of course, creating a class that we might only use once is overkill.
  Hence, Java provides _anonymous inner classes_. We'll look at these
  in more detail in a few weeks. For now, here's an example.

```
  Function<String,String> parenthesize = new Function<String,String>() {
    public String apply(String str) {
      return "(" + str + ")";
    } // apply(String)
  };
```

> At some point, the designers of Java added some syntactic sugar
  to make it easier to build objects for interfaces that have only
  one method. Such interfaces are called "functional interfaces"
  and the syntactic sugar is called a _lambda_. We'll also look at
  these in a few weeks.

```
  Function<String,String> parenthesize = (str) -> "(" + str + ")";
```

> Isn't that pretty?

What is the difference between `<T>` and `T` (like when do you use each)?

> We generally use `<T>` in the signature for a generic class or a generic
  method. We use `T` when we're declaring a variable (or a function, 
  within a generic class).

Why did we declare a variable like this:
`ExpandableArray<String> strings = new SimpleExpandableArray<String>();
Instead of:
`SimpleExpandableArray<String> strings = new SimpleExpandableArray<String>();

> It makes it easier to change our mind about the implementation (only
  one thing to change, rather than two or more).

What does it mean for a cast to be unsafe?

> It means that Java can't guarantee that you won't break something by 
  making the cast (e.g., if you accidentally cast a string to an integer).

```
  Object o = "Hello";
  ...
  Integer i = (Integer) o;
```

Why do we have `<T> T` instead of `<T> in the following?

```
public static <T> T search(T[] vals, Predicate<T> pred) {
```

> The `<T>` says "this is parameterized by the type variable `T`. The `T` says "this returns a `T`.  This permits us to write something like

```
public static <T> int indexOf(T[] vals, T val) {
```

> or

```
/**
 * Make a list of num copies of val.
 */
public static <T> List<T> makeList(int num, T val)
```

How do I call all of those?

```
  String[] strs = ...
  String shortString = search(str, new ShortString());
```

Lab
---

Reminders

* Not everyone likes to work at separate computers. Make sure your
  partner is okay with it.

Notes 

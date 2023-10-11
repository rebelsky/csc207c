---
title: "EBoard 21: Searching"
number: 21
section: eboards
held: 2023-10-11
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.  At least I think it is.

_Approximate overview_

* Administrivia
* Questions
* Lab

Administrivia
-------------

* Happy halfway mark!

### Upcoming Token activities

Academic

* CS Extras Thursday.  Thinking ahead to summer plans.
* Friday: Talk and movie on security

Cultural

Peer

* Football, 1pm Saturday, 21 October 2023.

Wellness

Misc

### Other good things (no tokens)

### Upcoming work

* Thursday: MP5
* Friday: Reading on loop invariants
* Friday night: MP5 post-assessment

### Learning assessments

We're using the portfolio approach for learning assessments.

In the next day or two, you'll see all of the learning assessments
appear on Gradescope.  In each case, your goal is to enter some code
and some explanatory text that shows that you've mastered the
associated concept.

Testing
-------

I spent a bit of time cleaning up the `AssociativeArrayTests.java` file.
You might consider downloading the new file and seeing if I added notes
to your section.  

Some general comments:

* DO NOT PUSH NON-WORKING CODE!  To get it working, I had to add semicolons 
  and more.
* DO NOT RELY ON ACCESS TO PRIVATE/PACKAGE FIELDS!  Given the "approved"
  position of the tests, it shouldn't be possible to access `pairs` or
  `size` or such.
* IF YOU CAN'T RUN YOUR TESTS, BE VERY CAREFUL THAT THEY ARE CORRECT.
  We all make mistakes.  But your mistakes shouldn't cause others stress.
* DO NOT RELY ON PARTICULAR IMPLEMENTATIONS!  Many of you wrote tests
  that made assumptions about how people expanded arrays, what order
  elements showed up in the underlying array, and such.
* IF YOU CAN'T FIGURE OUT HOW TO PUSH TO THE COMMON REPO, ASK A QUESTION.

But Sam, how do I test `toString`?

> Consider the case in which we've added A:1, B:2, and C:3 to our
  dictionary.

> We should write a test that checks whether the dictionary is one
  of "{ A: 1, B: 2, C: 3 }", "{ A: 1, C: 2, B: 3 }", "{ B: 2, A: 1, C: 3 }",
  "{ B: 2, C: 3, A: 1 }", "{ C: 3, A: 2, B: 2 }", or "{ C: 3, B: 2, A: 1 }".

        @Test
        public void testToString() {
          AssociativeArray<String,Integer> si = 
            new AssociativeArray<String,Integer.();
          si.set("A",1);
          si.set("B",2);
          si.set("C",3);
          String result = si.toString();
          assertTrue(result.equals("{ A: 1, B: 2, C: 3 }") ||
              result.equals("{ A: 1, C: 3, B: 2 }") ||
              result.equals("{ B: 2, A: 1, C: 3 }") ||
              result.equals("{ B: 2, C: 3, A: 1 }") ||
              result.equals("{ C: 3, A: 1, B: 2 }") ||
              result.equals("{ C: 3, B: 2, A: 1 }"));
        } // testToString()

Questions
---------

### Administrative

### Java

Why do we use iterators?

>

What's an `enum`?

> 

### MP5

_There are some questions and answers at the end of the miniproject.

AACCategory seems a whole lot like our AssociativeArray.  What's different?

> In many ways, `AACCategory` is just an adapter for our `AssociativeArray`
  class.  We can often write our methods as calls to underlying methods
  in `AssociativeArray`.

> But we will probably have to write a `K[] keys` method in `AssociativeArray`.


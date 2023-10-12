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
* I've added a rubric to MP5.
* Unfortunately, I have not found time to get tokens in order.
* If you are struggling because of the conflict (or the world's varied 
  reactions to the conflict), let me know how I can help.  I'm certainly
  willing to push deadlines.
* It appears that my office hours today and tomorrow are nearly completely
  booked (completely booked today, just a little time tomorrow).  If you'd
  like to meet with me, drop me a note and we'll see what we can work out.
  (Preferred times: noon-1pm and 3:00-3:30pm today; 10:00am-noon tomorrow.
* The Beginner's Creed:
  <http://denninginstitute.com/pjd/PUBS/CACMcols/cacmJul17.pdf>

### Upcoming Token activities

Academic

* CS Extras Thursday.  Thinking ahead to summer plans.
* Friday: Talk and movie on security (1pm, Strand 3).
  <https://forms.office.com/r/u34bDgj8w2>

Cultural

Peer

* Football, 1pm Saturday, 21 October 2023.

Wellness

* Be well during fall break.

Misc

### Other good things (no tokens)

### Upcoming work

* Friday: Reading on loop invariants
* Saturday: MP5
* Sunday night: MP5 post-assessment

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

What should we do if we want to use lab code (e.g., as evidence on
the LAs) and we forgot to the github repo from our partner.

> I don't think anyone has dropped the class, so you can probably
  still ask your partner for the repo.

We forgot to push it.

> `git commit FILE.java -m "Post lab."`

> `git push`.

Can we write (and write about) new code to demonstrate things on LAs?

> Sure.

Can we use code we've written on MPs and labs?

> Sure.  Provided you write about it to explain what it demonstrates.

Do LA redos cost tokens?

> No.

Even if I decide to try ten times?

> I hope that doesn't happen.  If you aren't making serious attempts,
  I may rethink this policy.

### Git and GitHub

How do I push to our common repo.

Presumably, you've created your copy with

`git clone REPOSITORY`.

```
$ git add AssociativeArrayTests.java
$ git commit AssociativeArrayTests.java -m "Add the Sam Rebelsky tests."
$ git pull
        cross your fingers that we have no conflicts
        if so, resolve conflicts
$ git push
```

If that didn't work, let's talk.

### Java

Why is it bad practice to reference the fields of a class in another
package?

> We use classes for information hiding; in general, you should rely
  only on public methods.

> If you rely on fields and they change, your code will probably break.

> Maybe the implementer decides `pears` makes more sense than `pairs`.

Why do we use iterators?

> It makes our code more general; if we can iterate all sorts of collections,
  we can use the same code to work with "any" collection.

> It's a common pattern in writing code ("do something for each element
  in this collection") so we should have a way to do it.

> It's much nicer than having to write a custom piece of code for each
  structure you want to iterate (e.g., we are treating linked lists, and
  array lists and trees as all the same).

What's an `enum`?

> It's an idea stolen from C.  It's a way to create a new type that
  contains only basic values.

### Searching

Is there a reason to have `randomSearch`?

> Um ... statistical distribution?

> Um ... it's fun to analyze random functions?

> But no, not really.  It's there to remind you that there are sometimes
  times it's good to think outside the box.

### MP5

_There are some new questions and answers at the end of the miniproject.

AACCategory seems a whole lot like our AssociativeArray.  What's different?

> In many ways, `AACCategory` is just an adapter for our `AssociativeArray`
  class.  We can often write our methods as calls to underlying methods
  in `AssociativeArray`.

> But we will probably have to write a `K[] keys` method in `AssociativeArray`.

How would we write `add` in `AACCategory` and `AACMappings`?

> In `AACCategory`, I'll assume that we have a field called `aa` which
  holds an associative array that maps strings (representing locations)
  to strings (representing the text to be spoken).

        public void addItem(String imageLoc, String text){
          this.aa.set(imageLoc, text);
        } // addItem(String, String)

> Note: The specs on `getText(String imageLoc)` do not specify what happens
  if it's an invalid image location (one not used with `addItem`).  You
  can do what you wish.  I returned "Error: Could not find text".

> In `AACMappings`, I assume that you have a field `currentCategory` that
  holds the AACCategory for the current screen.

        public void add(String imageLoc, String text) {
          this.currentCategory.addItem(imageLoc, text);
        } // add(String, String)

> Isn't delegation wonderful?

Do we have to support categories within categories?

> No; you'll find it nearly impossible to do so without modifying the
  AAC.java file.

How would you write the `writeToFile` method?

> The file has the form

        imageCategoryLoc categoryName
        >imageLoc text
        >imageLoc text
        >imageLoc text
        imageCategoryLoc categoryName
        >imageLoc text
        >imageLoc text
        imageCategoryLoc categoryName
        >imageLoc text
        >imageLoc text
        >imageLoc text
        >imageLoc text
        >imageLoc text

> We need to write to a file, so we need to figure out file I/O.

        // While testing
        PrintWriter pen = new PrinterWriter(System.out, true); // On screen

        // While running
        try {
          PrintWriter pen = new PrintWriter(new File(filename));
          ...
          pen.close();
        } catch (Exception e) {
          ...
        }

> We need to iterate through all of our categories.  How?

> > We could write an iterator for our associative array.

> > If we've implemented `K[] keys()`, we can iterate through the
    keys of our top-level AACCategory

> > Of course, `topLevelCategory.getImages()` gives us all the keys.

> > `for String category : topLevelCategory.getImages() { ... }`

> We need to iterate through all the location/text pairs in each category.
  How?

> > `for String loc : category.getImages() { ... }`

> What should we do for each category?

> > Print the category/text pair

> > Iterate through the location text pairs, printing each.

Where am I storing the mapping of image names to category names?

> We have `AssociativeArray<String,AACCategory> categories` that
  maps category names to categories.

> We have `AACCategory topLevelCategory` that maps image paths to
  category names.

> I would also have `AACCategory currentCategory` that references the
  current category (either `topLevelCategory` or one of the subcategories).

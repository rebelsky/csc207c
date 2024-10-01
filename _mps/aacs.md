---
title: Mini-Project 5
subtitle: Augmentive and Alternative Communication Devices
summary: |
  In this mini-project, you will use an extended version of the
  AssociativeArray class from the last mini-project to build a
  simple AAC.
collaboration: |
  Each student should submit their own responses to this project. You may
  consult other students in the class as you develop your solution.  If you
  receive help from anyone, make sure to cite them in your responses. 
link: false
---

In this mini-project, you will explore (a) the use of associative arrays and other kinds of maps, (b) programming to specifications in support of a larger project, (c) dealing with conflicting approaches to Java programming (and homework assignments in CS), and (d) considering some of the issues at play in designing software for people with disabilities (as well as using software as a disabled person).

This project will *not* use Maven.

## The assignment

Do the assignment at <https://accessibilityeducation.github.io/assignments/AAC/AAC.html>, using your `AssociativeArray` class instead of `HashMaps`.  Please leave your `AssociativeArray`, `KVPair`, and exception classes in the `edu.grinnell.csc207.util` package, but copy that package into this project..

## Recommended stages

To do this assignment, you should follow these steps, modifying them as you consider appropriate.

* Read the instructions and background.
* Fork and clone the repository at <https://github.com/catiembaker/AACNestedHW>.
* Remove the `.project` folder from the repository.
* Add your AssociativeArray code to the repository (presumably in `src/edu/grinnell/csc207/util`).
* Review the `AACCategory` specifications given at <https://accessibilityeducation.github.io/assignments/AAC/AACCategory.html> and start planning your design.
   * Add slightly more sophisiticated stub methods to the implementation. (See below for some suggestions.)
   * Note that your `AACCategory` class will likely contain an `AssociativeArray<String,String>` that maps image locations (strings) to words (also strings).
* Review the `AACMappings` specifications given at <https://accessibilityeducation.github.io/assignments/AAC/AACMappings.html> and start planning your design.
   * Add slightly more sophisiticated stub methods to the implementation. (See below for some suggestions.)
   * Note that your `AACMappings` class will likely contain an `AACCategory` object that maps filenames to their corresponding words.  You may also want an `AssociativeArray<String,AACCategory>` that maps either filenames or names to categories.
   * Sample stub versions of `getImageLocs()`, `getText(String)`, and `getCurrentCategory()` follow.
* Run the application to get a basic sense of how it works (or should work).
   * _Warning!_ At least on my computer, it takes a while to load.
* Start implementing methods.

Note that you will likely need to update `AssociativeArray` to support methods like `getImageLocs()`.

## Sample stub methods

```
  public String[] getImageLocs() {
    return new String[] { "img/food/icons8-french-fries-96.png", "img/food/icons8-watermelon-96.png" }; // STUB
  } // getImageLocs()

  public String getText(String imageLoc) {
    return "television";  // STUB
  }

  public String getCurrentCategory() {
    return "food";  // STUB
  }
```

## Submitting

Upload your code to Gradescope using the GitHub approach. (Note that doing so takes the *current* version of your GitHub repo. If you make further changes to your repo, you will need to upload more.)

## Rubric

### Redo or above

Submissions that fail to meet any of these requirements will get an I.

```
[ ] Passes all **R** tests.
[ ] Passes all **R** scripts.
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
[ ] Passes all **M** tests.
[ ] Passes all **M** scripts.
    [ ] Appears to correctly load a file.
    [ ] Appears to correctly add an image to the top-level category.
    [ ] Appears to correctly switch to subcategories.
    [ ] Successfully grabs words from subcategories.
    [ ] Correctly switches to the default screen.
```

### Exemplary / Exceeds expectations

Submissions that fail to meet any of these requirements but meet all
previous requirements will receive an M.

```
[ ] Passes all **E** tests.
[ ] Passes all **E** scripts.
[ ] All (or most) repeated code has been factored out into individual 
    methods.  
[ ] All or most variable names are appropriate.
[ ] `AACCategory` and `AACMappings` do not access any fields in
    `AssociationList` or `KVPair`.
```

## Grading scripts

### Script for **R**

### Script for **M**

### Script for **E**

## Q&A

### Adding data

**How do we add new categories?**

> It seemed from the specs that categories are only created when
  you load the file upon creating a new `AACMapppings`.  However,
  upon looking at the underlying code, I determined that any images
  on the default screen are considered categories.

### Sam's implementation

**I hear you also did this MP.  What part did you find hardest?**

> Yes, I did this MP.  I try to do most of them.  I found writing a
  `keys` method for `AssociationList` the hardest part because 
  creating arrays using generics is painful.  I assume there's a good
  way to do it, but I always find myself struggling.

**How did you address the problem?**

> Since we only need an array of strings I was tempted to write at
  `String[] keyNames` method.  However, that seemed like an easy
  out.  If I were re-designing the assignment, I'd probably require
  that we provide an iterator for keys rather than an array of keys.

> In the end, I used something similar to the mechanism I used in
  the constructor.  That is, I used `Arrays.newInstance` using the
  first key in the pairs array to specify the type.  

> Of course, I couldn't do that if I had no key/value pairs, so I
  returned `null` in that case, which complicated the implementation
  of `getImages`.

**What else was difficult?

> I didn't see a natural way to write `isCategory`; it seemed much more
  natural to check if a word is a cateogry than if an image location
  is a category.  I later discovered that they didn't use `isCategory`
  and they assume any image on the home screen is a category.

### Miscellaneous

**Can I provide full path names to the images?**

> No.  That's not portable.  You should write portable code.

**Can I change the names of the images?**

> I'd prefer that you don't change the names of the images.  It may
  interfere with our testing.

**The interface for adding image/text pairs seems fairly cumbersome,
particularly for users with limited mobility.**

> I'd agree.  Let's assume that a friend or assistant would add them.

**Why do you think our `AACMappings` class would benefit from a field
of type `AssociativeArray<String, AACCategory>`?**

> You'll need to keep track of the AACCategory for each image on the
  top-level page.

**Why do you think our `AACMappings` class would benefit from a field
of type `AACCategory`?**

> You'll need to keep track of the location-to-name mappings somewhere.
  I think it's easier if you use an `AACCategory` for uniformity.

**In the `AACCategory` class methods do we have to use `getCategory` to check if the image is in the category in the `getImages`, `getText`, and `hasImage` function or are we making an assumption that everything that we call in this class is part of the same category?**

> You do not need to use it to check if an image is in a particular category.
  Rather, we use it primarily in case the client code needs to identify
  the category (e.g., to speak it aloud).

> We wil use it primarily to support the `getCurrentCategory` method in
  `AACMappings`.

> In a hidden design issue, the UI looks for a category of `""` to decide
  whether it's working with the top level.

**What might it entail to update `AssociativeArray` to support `getImageLocs()`? (That is, what might I want to keep in mind when I think about these changes?)**

> You'll need to figure out how to return an array of keys. It can be hard 
  to build a generic array, so you may want to build an array of the keys
  represented as strings.

**Should `AACCategory` and `AACMappings` share an interface?**

> No. They have different responsibilities. (They also have some
  similar responsibilities, which complicates matters a bit.)

**How do I relate category, text, and image together?**

> In `AACMappings`, you provide facilities for converting the path to an image to the corresponding category.

> In `AACCategory`, you provide facilities for converting the path to an image to the corresponding word.

> The UI knows how to convert the path to an image to the image itself.

**What do I do with the PNG files?**

> You're only responsible for keeping track of the path to those files (and some corresponding information). The provided front end deals with displaying them.

**If we're mapping images to words with our arrays, how are we to associate those words with sounds? Or should our implementation not worry about playing sounds when we click on the pictures, just print the words.**

> You will return words. The provided code speaks them.

**Should we use inheritance to implement the AACMapping class?**

> I would not use inheritance. Rather, I would suggest using "wrapping" with a field of type `AssociativeArray`.

**How should error handling be implemented for methods like `getImageLocs()` and `getText()` to handle cases where the requested image location or text is not found?**

> Welcome to one of the conflicts between how Dr. Baker designs things and how I do. You'll need to figure out some other way to signal an error. (Ideally, there won't be any.) For example, `getText()` might return `"Not found"` and `getImageLocs()` might return an empty array.


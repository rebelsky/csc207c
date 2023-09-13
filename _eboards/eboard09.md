---
title: "EBoard 09: Subtype polymorphism"
number: 9
section: eboards
held: 2023-09-13
link: true
---
# {{ page.title }}

**Warning** This class is being recorded.

_Approximate overview_

* Administrivia
* A few notes on MP1
* Questions
* Lab

Administrivia
-------------

### Introductory notes

* I lost my fight with VSCode yesterday.  Lab may be "interesting".
  (Hey, it's a chance to experience: "The code was written to work
  with a different IDE."  Let's see how many things go wrong.)
* Beware!  Friday the thirteenth falls on Wednesday this month.

### Upcoming Token activities

Academic

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

* Thursday: MP2
* Friday: More readings

About MP1
---------

* Rubric added (I think).
* Graders are in progress.
* I thought I'd go over a few things that tripped people up (or that
  will trip people up).

1. File names must match.  If I tell you to create a class named
`CaesarCipher.java`, it should be named `CaesarCipher.java` and
not `CeasarCipher.java` or `WickedNeatCipher.java`.

2. Output should match.  If I tell you that the output should just
be the encrypted word, you should not have extra output.

3. I care about style.  You should match Google Java Style, including
two-space indents and appropriate capitalization.

4. I care about style.  You should choose good names for variables
and procedures.

5. If the instructions say to put particular text in a file, you must
put that text in the file.  (Some of you didn't include your name or
the one-sentence description in the README file.)

6. To reach M, you need not do extra error checking and such (unless
I tell you to).  To reach E, you should.  E code is robust code.

```
$ java CaesarCipher encode
Please include the string you wish to encode.
$ java VigenereCipher
You incompetent user!  Do you not know that this program requires
(a) the word encode or decode
(b) a string to encode
(c) a key
You have failed to protect the security of your nation.  You will
now be executed.
```

7. Please include a comment on your classes.

```
/**
 * Encrypt/Decrypt text from the command line using the legendary
 * Caesar Cipher mechanism.
 *
 * @author S Tudent
 */
public class CaesarCipher {
  ...
} // class CaesarCipher
```

Questions
---------

### MP2

When is the rubric being released?

> Tonight.  Sorry for the delay.

Will I have to be as careful on output for MP2 as I was supposed to be
for MP1?

> Nope.  We didn't specify output this time.

Do I have to make sure that the input is in the correct form?

> No for an M, yes for an E.

Lab
---

VSCode may currently be broken in MathLAN.  You may have to use the
terminal instead, at least for compilation.  I HATE COMPUTERS!

### Exercise 1

Try `Float.valueOf(f)` to convert a `float` value (primitive type) to
a `Float` value (object).

### Exercise 3

For exercise 3a, I want something like

    TextBlock block3 = new BoxedBlock(new TextLine("Testing"));
    TBUtils.print(pen, block3);

3b: Box a Box

3c: Box something empty.  (Do we have something empty?)

It's 11:15.  I have a "Sam said you can stop here" policy.

* Fill out the lab writeup together.
* Do the rest on your own (nothing to turn in).

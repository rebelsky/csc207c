---
title: "Eboard 03: A bit of Java"
number: 3
section: eboards
held: 2024-01-26
link: true
---
# {{ page.title }}

**You are probably being recorded, perhaps even transcribed.**

_Getting started_ (this will be our normal start-of-class sequence)

* Grab a card.  The card will have a computer name and a location.
* Remember the name and location.
* Drop the card back in the jar.  <-------
* Navigate to the computer.
* Whoever arrives first, log in.
* When both partners arrive, introduce yourselves.

For the future: I'm happy to reserve a (somewhat random) seat at
the front of the classroom for those who need a front seat as an
adjustment or accommodation.  Just let me know.

_Approximate overview_

* Administrivia
* Lab

Preliminaries
-------------

* In case it wasn't clear from my comments, I see great value in 
  process-oriented pseudo-recitation sessions.
    * You should be learning to design ADTs and data structures
    * You should be learning to implement data structures
    * I expect you to remember and apply "PUM" and "LIA"
        * I'm happy to hear suggestions for alternative TLAs.
        * And don't forget to ask when you don't understand a TLA.
* Any thoughts about the 12x difference in reading speeds?
    * Those taking less time might want to take notes.
    * Those taking more time may want to discuss ways to be more
      efficient.

### Upcoming work

* Sunday at 11pm: Readings
    * [Git and GitHub](../readings/git)
    * [VSCode](../readings/vscode)
        * Not yet complete.
    * Nothing to submit.
* Tonight at 11pm: [Pre-reflection for MP1](https://www.gradescope.com/courses/690101/assignments/3974719/)
    * Demo!
* Monday at 1pm: [Today's lab](../labs/getting-started) on [Gradescope](https://www.gradescope.com/courses/690101/assignments/3995041/).
* Tuesday at 11pm: [Mini-Project 1](../mps/mp01) 

### Tokens

_Not yet available to submit._

Academic/Scholarly

* Friday, 2024-01-26, 6:00--7:30 p.m., JRC 101. 
  _Celebration of MLK day with Alan Page_.

Cultural

* Saturday, 2024-01-27, 11:55 a.m.--3:55 p.m., Harris Cinema.
  _Met Opera presents Carmen_.

Peer

* Saturday, 2024-01-27, 10:00 a.m.--1:00 p.m., Field House.
  _Grinnell Track and Field Invitational_.

Wellness

* Monday, Therapy dogs (we think). Details forthcoming.

Misc

### Friday PSA

* You are awesome.
* You have peole who care about.
* Please take care of yourself as you relax over the weekend.
* If you choose to consume substances that affect your brain,
  please do so in moderation.
* Know what's right for you. Don't make your choices based on those
  around you.
* Consent is essential.

Questions
---------

### Administrative

What's the best way to tell what work is due?

> The daily eboards are most likely to have links to everything.

> Gradescope will have the things you need to turn in, but Gradescope
  is sometimes overwhelming.

> The schedule lists most things, but won't always have links.

When should I fill out the pre-reflection?

> Soon after you first read the assignment.

Will we have a pre-reflection for each mini-project?

> Probably. I'd like to encourage you to (a) think about the purpose
  of each assignment, (b) do the brain dump thing, and (c) ask
  questions.

Will we have a post-reflection for each mini-project?

> I'm happy to revisit post-reflections after we've done five or so.

### MP1

What does it mean for an empty string to be correctly encoded? (from the rubric)

> The empty string should be encoded as the empty string, rather than 
  crashing and burning.

Do helper methods reside in the same class as the main method?
(i.e., in (3) helper methods would be inside of MyClass and before
the main method...)

> Helper methods can either be in the same class or a different
  class. In many cases (e.g., you only need them in that class), 
  it makes sense to put them in the same class. In others (e.g.,
  you will use them in different classes), you put them in a
  separate class.

> You can put them before or after the main method.

```
/**
 * A sample class.
 */
public class Sample {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+
  
  /**
   * Do all the work.
   */
  public static void main(String[] args) {
    // PrintWriter pen = new PrintWriter(System.out, true);
    PrintWriter pen = new PrintWriter(new FileWriter("foo.txt"));

    pen.println(greeting());

    pen.close();
  } // main(String[])

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Generate a greeting.
   */
  public static String greeting() {
    return "Hello";
  } // greeting()
} // class Sample

If one wanted CeasarCipher and VigenereCipher to share code, would
this require packages? (i.e., putting shared methods in a package
imported to both CeasarCipher and VigenereCipher...)

> Nope. Just put the shared code in static methods in another class.

What helper methods should Caesar Cipher and Vigneneré Cipher have
and should they be the same helper methods?

> Part of the assignment goal is for you to think about how best to decompose
  the problems.

> Yes, it would be nice if some of the helper methods were shared
  between classes.

How do I share helper methods between classes?

    /**
     * A variety of procedures that help with encryption and
     * decryption.
     */
    public class EncryptionHelpers {
      /**
       * Convert a letter (in the range a-z) to the corresponding
       * number (in the range 0-25).
       */
      public static int letterToNumber(char letter) {
        return 0;       // STUB
      } // letterToNumber
    } // class EncryptionHelpers

    /**
     * Caesar Ciphers.
     */
    public class CaesarCipher {
      public static void main(String[] args) {
        int result = EncryptionHelpers.letterToNumber('q');
      } // main(String[])
    } // class CaesarCipher

    /**
     * Vigeneré Ciphers.
     */
    public class VigenereCipher {
      public static void main(String[] args) {
        int result = EncryptionHelpers.letterToNumber('q');
      } // main(String[])
    } // class ViginereCipher

Should each class be in its own file.

> Yes. (It's not always necessary, but I ask that you do so for this
  assignment.)

Where should we write the Java code?

> Using the editor of your choice. `vim`, emacs, VSCode.

Do we really have to do meaningful commits on GitHub?

> Nah. I'll move that to another assignment.

Why are we creating `PrintWriter` objects that we seem to call `pen`?

> It makes our code a bit more general/modifiable. If we change
  where we want output to go, we need only change one line in
  our code.

Is it okay to use `System.out`?

> Maybe for the first assignment. I'd prefer that you use PrintWriters.

In class, we said that it was bad practice to print error messages,
but I am not sure if how to tell the user their input was invalid
without printing a message.

> It's bad for utility methods to print error messages. UI programs
  can print error messages, and you're writing UI programs for this
  assignment.

Why are we printing an error message to stderr rather than throwing
an Exception as suggested in previous readings?

> We haven't covered exceptions yet.

> You're creating something that interacts directly with the user,
  so it's appropriate to print error messages.

How do I get started coding in Java?

> I think you'll be fine after today's class.

How do I best follow the Google Java style guidelines?

> Read them.

> Look at the code I write.

> See if you can identify some basic principles.

> Ask in class on Monday and we'll see what we can come up with as a class.

This may be a stupid question, or something I forgot but what is a
`README.md` file? And how do we code it?

> A `README.md` file provides information about the project. If you
  use GitHub, it can create the basic template automatically.

> It's written in Markdown, but you can mostly treat it as a plin
  text file.

> Use whatever editor you like to create it.

Do we have to use GitHub for the first assignment?

> Nope. But you will need to use it for future assignments.

Lab
---

Do we have to write up the answers to the questions?

> No. You'll only be turning in the code for part 2.

Surprise! Even though the lab says to turn in the array problems, you
need only turn in `FizzBuzz.java`

> If you've finished it already, turn it in now.

> If not, finish it on your own.

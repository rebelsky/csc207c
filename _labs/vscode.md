---
title: Getting started with VSCode in MathLAN
summary: |
  In this laboratory, you will configure VSCode for use in MathLAN and build a program or two. 
---

_**Disclaimer**: MathLAN and VSCode do not always interoperate well.  Sam is also relatively new to VSCode.  You may have to play a bit to get all of this working._

_**Note**: Most of these commands should work similarly on your own computer, whether you are running macOS, MS Windows, on Linux.  At least that's the theory.  You may have to download your own Java Development Kit (JDK).  Microsoft even provides version of VSCode preconfigured for Java which you can download from <https://code.visualstudio.com/docs/java/java-tutorial>._

_**Note**: Exercises 1 and 2 help configure your VSCode environment.  Whichever partner is not using their account should plan to do similar configuration later (or at the end of class, if you finish early)._

Preparation
-----------

a. Log in to MathLAN.

b. Create a directory to use for this lab.  I'd suggest something like
`~/CSC207/VSCode` (aka `/home/USERNAME/CSC207/VSCode`).

c. Open VSCode by typing `code` in a terminal window.

Exercises
---------

### Exercise 1: Configure VSCode to use the appropriate JDK

VSCode needs to know where to find the core Java tools (compiler, virtual machine, etc.).  You can help it by telling it where things are.

a. Type Shift-Ctrl-P to open the Command Palette.  (You'll do that a lot in VSCode.)

b. Type "Preferences: Open User Settings" (but without the quotation marks).

c. At the top of the settings screen, you should see a place to search settings.  Search for "java.configuration.runtimes".  It will then give you the opportunity to change it in the file `settings.json`.  Like many modern applications, VSCode uses JSON (the Javascript Object Notation) to store settings data.  You'll get used to JSON fairly quickly.

d. If you're lucky, you alraedy have this configuration.  But most people don't.  So you'll get to edit it yourself.  Use the following for MathLAN.

```
"java.configuration.runtimes": [
   {
    "name": "JavaSE-17",
    "path": "/usr/lib/jvm/java-17-openjdk-amd64",
    "default": true
   }
]
```

e. Quit and restart VSCode.  (For major settings, this seems safer.)

### Exercise 2: Set the correct indentation and style

For some reason, the designers of VSCode seem to think that four spaces of indentation for nested code is the way to go.  However, most programmers prefer two spaces so as to avoid overly indented code.  The Google specifications for Java formatting also specify two spaces.  So our next task will be to set the indentation and the formatter.

a. Type Shift-Ctrl-P to open the Command Palette.

b. Type "Preferencees: Open User Settings (JSON)" (without the quotation marks).  You'll note that this command is slightly different than the one we used before.  This time, we're going directly to the JSON.

c. Add the following before the specification.

```
    "java.format.settings.url": "https://rebelsky.cs.grinnell.edu/csc207-style.xml",
    "editor.indentSize": 2,
    "[java]": {
        "editor.tabSize": 2
    },
```

d. Quit and restart VSCode.  (I promise; you won't have to do that many more times.)

### Exercise 3: Your first VSCode Java Program

We should now be ready to write your first program in VSCode.

a. Open the Explorer (click on the overlapping "sheet of paper" icons in the top left or type Ctrl-Shift-E).

b. Click on "Open Folder ...".  (Do you know what the ellipses represent?)

c. Select the folder you created for this lab (e.g., `/home/USERNAME/CSC207/vscode`) and click "Open".

d. If VSCode asks whether you trust the authors of the folder, indicate that you trust those authors.

e. You should now see your folder in the menu to the left.

f. Expand your folder by clicking on the greater-than sign next to the folder.

g. Click on the "New File" icon (a file icon with a plus on it).

h. Type "Sample.java" in the text area that appears and then hit return.  An editing pane should open up.

i. Enter our sample program.  You can copy and paste, if you'd like, but there are some advantages to typing it yourself, at least the first few times.

```
import java.io.PrintWriter;

public class Sample {
  /**
   * Print a silly message.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.print("I am the 133+ h4x0r. Phear me!");
    pen.flush();
  } // main(String[])
} // class Sample
```

j. Click the Run button (above your main method) or the Run arrow (in the upper-right-hand-corner).  If you don't see either, ask one of the class staff for help.

k. If all has gone well, you'll see some terminal output in the terminal pane of the window.  VSCode will issue a somewhat complex command and then you should see the output of your program.  Here's what it looks like for me.

```
cd /home/rebelsky/CSC207/vscode2 ; /usr/bin/env /usr/lib/jvm/java-17-openjdk-amd64/bin/java -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:39183 -XX:+ShowCodeDetailsInExceptionMessages -cp /home/rebelsky/.config/Code/User/workspaceStorage/80d49571e03d5c2bb60fb0c4a11b1457/redhat.java/jdt_ws/vscode2_2204ae62/bin Sample 
I am the 133+ h4x0r. Phear me! [rebelsky@atanasoff 502] ~/CSC207/vscode $
```

Isn't that beautiful?  Perhaps not.  But it does show that our program ran.  

### Exercise 4: Observing output

As you likely noted, the Unix prompt appears on the same line as the output.  That's because we used `print` instead of `println`.  We did so to help you explore output a bit more.

a. What do you expect to happen if you comment out the call to `pen.flush()`?

b. Check your answer experimentally.

c. As you likely discovered, no output appears.  Why?  Perhaps you learned the answer when you study output in C.  If not, here's the story: Rather than sending each character to the recipient as they are output, most language implementations put the characters into a _buffer_ and then send the buffer when it fills or when they are instructed to do so (when you _flush_ the buffer).  The designers of the Java `PrintWriter` class decided not to print what is left in the buffer at the end of the program.

We warn you of this primarily because you'll encounter the issue when prompting the user for input.  That is, if you use `print` (which you should)`, you'll also need to call `flush`.

d. Determine what happens if you use `println` rather than `print`.

e. Reinstate the call to `pen.flush()`.

f. Add calls to `println` to print an integer or real number.  (Put these before the call to `pen.flush()`.)

g. What do you expect to happen if you use `print` rather than `println`?

h. Check your answer experimentally.

i. What do you expect to happen if you try to print `System.out` and `pen`.  That is, what do you expect to happen when you call

```java
    pen.println(System.out);
    pen.println(pen);
```

j. Check your answer experimentally.

### Exercise 5: Playing with packages

Java encourages you to group related classes into _packages_.  For example, the `PrintWriter` class is in the `java.io` package.  At the filesystem level, packages are represented by folders.  For example, the code for `csc151.rebelsky.Sample` should be found in `csc151/rebelsky/Sample.java` (or `csc151/rebelsky/Sample.class`).

Let's do a quick check on how VSCode helps us handle packages.

a. If you have any Java extensions installed, disable them and restart VSCode.  If you don't know how to disable extensions,

i. Click on the extensions tool (a grid of four boxes with the upper-right box offset somewhat).

ii. Click on the gear tool for the installed extension.

iii. Click on "Disable".

b. Create a new folder in your lab directory called `sample`.

c. In VSCode, move the `Sample.java` file into the `sample` directory.  

Wasn't that fun?  As you likely observed, VSCode let you move it, but it didn't do anything else.  So ...

d. Drag `Sample.java` back to the top level.

e. Install the Extension Pack for Java.  You might have a prompt that recommends you do so.  If not, try the following.

i. Click on the extensions tool (a grid of four boxes with the upper-right box offset somewhat).

ii. At the top of the "Recommended" section, you should see "Extension Pack for Java".  If not, search for it.

iii. Click on the "Install" button for the extension 

iv. Wait.

Now we're ready to try moving files again.

f. In VSCode, move the `Sample.java` file into the `sample` directory.  This time, you should get a prompt indicating that RedHat wants to refactor your code.  Allow it to do so.

If all has gone well, you'll see that the VSCode extension has appropriately added the package information.

g. Drag `Sample.java` back to the top level.  You should get another prompt (unless you've turned those off).

If all has gone well, you'll see that the VSCode extension has appropriately removed the package information.

Wasn't that exciting?  But it's a preview of what an IDE can do for you.  When you have classes that reference each other and move them around the hierarchy, VSCode + the RedHat Java extension should make the "obvious" changes.

### Exercise 6: Your second program

a. Make another class and call it `SimpleMath`.

b. Using the skeleton from above write a program that computes and prints out a simple sum.  For example, your output might be

```text
Adding 3 and 4 gives us 7.
```

Here's a sketch.

```java
    int x = 3;
    int y = 4;
    pen.print("Adding ");
    pen.print(x);
    ...
    pen.print(x+y);
    pen.println();
```

Presumably, you wrote this program using a sequence of calls to `pen.print` and `pen.println`.  Can we pack it into a single instruction?

c. Java "overloads" the `+` operation.  If you combine two strings with `+`, you will get a string.  For example, determine the result of the following instruction.

```
    pen.println("Hello" + "World");
```

d. We saw earlier that `pen.println` accepts things other than strings, such as integers and reals (and even `System.out`).  Can `+` also take different types of arguments?  Determine what happens if you combine a string and an integer with `+`.  What about combining an integer and a string?

e. Rewrite your instructions to print a sum using just one call to `pen.println`.

f. Of course, we're better off using `printf` than `println`.  Comment out the prior call to `pen.println` and then rewrite your instructions once more to print the sum information using `pen.printf(...)`.

### Exercise 7: Processing the command line

As you've likely noted, the Java `main` method takes an array of strings as a argument.  That array is similar to the `argv` and `argc` arguments that you see in C programs.  It differs primarily in that in Java, the first argument is _not_ the name of the program.

a. Create a new class, `CommandLineArguments` as follows.

```
import java.io.PrintWriter;

/**
 * Print out the actual arguments from the command line.
 */
public class CommandLineArguments {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    pen.println("There are " + args.length + " command-line arguments.");
    for (int i = 0; i < args.length; i++) {
      pen.printf("%2d: %s\n", i, args[i]);
    } // for
  } // main
} // class CommandLineArguments
```

b. Compile and run `CommandLineArguments` from the command line.  For example,

```
$ javac CommandLineArguments.java 
$ java CommandLineArguments a b c
There are 3 command-line arguments.
 0: a
 1: b
 2: c
$ java CommandLineArguments
There are 0 command-line arguments.
```
c. Run `CommandLineArguments` from within VSCode.

d. As you likely observed, `CommandLineArguments` doesn't give you a chance to provide the arguments.  Think for a moment about how you might provide those (or how you might figure out how to provide those).

Are you done?

Did you come up with an idea?

e. One option is to use the up-arrow in the terminal.  You can then type the arguments at the end of the line.  Try that to see if it works.

f. When can also configure VSCode to prompt us for those arguments.  

i. Click on the "Run and Debug" icon at the left (a triangle/play button with a bug on it).

ii. Click on "create a launch.json file".

iii. Click on "Add Configuration ...".

iv. Select the one that reads "Java: Launch Program with Arguments Prompt".  You should see the following text added.  If not, add it yourself.

```
        {
            "type": "java",
            "name": "Launch with Arguments Prompt",
            "request": "launch",
            "mainClass": "",
            "args": "${command:SpecifyProgramArgs}"
        },
```

v. Copy the `"args"` line to the entry for `CommandLineArguments`.  Make sure to add the comma to the previous line of that entry.

vi. Save the `launch.json` file.

g. Determine whether the changes worked.

## Submitting your work

You will submit your work as part of the next lab.

## Up next ...

Proceed to [the Git/GitHub lab](../labs/git).

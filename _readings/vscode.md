---
title: The VSCode IDE
summary: |
  We consider a bit about integrated development environments (IDEs) and then
  delve into some details of the VSCodeIDE.
---
A brief introduction to integrated development dnvironments
-----------------------------------------------------------

At this point in your programming career, you've probably learned that there are a variety of tasks that programmer need to consider.  Among other things, programmers must manage a variety of files, provide build instructions that combine the files, correct syntax errors in program code that the compiler identifies, find logic errors in their programs (sometimes by manual analysis, sometimes with a debugger), and remember a host of libraries.

Many programmers are quite happy doing all of these things with a variety of programs and with an editor like vi or emacs.

However, as the power of computers expands, programmers increasingly want to harness that power to make their tasks easier, and perhaps to integrate them into a single application.  For example, why not have the editor tell you when you make a syntax error (and perhaps even suggest a solution) when you make the error, rather than much later, when you try to compile it?  Why not have the editor suggest what procedure you want, rather than forcing you to scan through lots of documentation?  And why not have the editor keep your files organized so that it can automatically figure out what and how to compile?  Environments that combine these various development tasks are called "Integrated Development Environments" or more frequently "IDEs".

What features can you expect an IDE to provide?

* Most IDEs provide a *source code organization module*.  Mostly, this modules allows you view of the various files in your project (and, when necessary, to rearrange them).  It may sound like a file browser, but a good source code organization module does more than a file browser - for example, if aspects of your program depend on its location, when you move it in the code hierarchy, the IDE will rewrite the portions that depend upon its location.
* Every IDE provides a *smart source code editor*.  How is it "smart"?  Usually in a variety of ways.  First, it is likely to know the syntax of the language and can not only highlight your code clarity, but also automatically indent (and unindent) your code.  * Most IDEs have editors that do *live source code checking*.  
  That is, in many cases, the IDE editor is likely to notice when you have an obvious error (usually syntactic, occasionally something deeper) and to flag that error quickly.  Some will even suggest corrections, although you should probably take those suggests with a grain of salt.  
* Most IDEs have editors that do *advanced autocomplete*.  That is, if you type the start of a procedure or value name (and, often, hit a special key), the editor will provide you with possible completions.  And, if you're working with a library, the editor will give you quick access to a list of members of that library (values, variables, functions, etc.).
* Most IDEs have *integrated compilers*.  Rather than leaving your editor to compile and run your code, you just hit a few keystrokes.
* Most IDEs have *integrated debuggers*.  Rather than leaving your editor to debug your code, you can do so directly within the debugger.
* Many IDEs integrate with *source code management systems* like git or Subversion.  Such integration makes it easier to grab code from the repository and to upload revised code to the repository.  (We've had mixed success with such integrated SCMs.)
* Some IDEs provide *features for source code reorganization*.  For example, some make it easy to refactor repetitious code or to rename a variable throughout a section of code.
* These days, most IDEs have *integrated AI assistants*, although many also charge for those assistants. I would prefer that you avoid AI assistants in this course.

To some of you, all of these features may sound like the return of Clippy<superscript>&reg;</superscript>.  To some long-time programmers, these features lead to novice programmers to who don't know the syntax of their language and easily forget to things they should memorize,  However, to many, these features combine to provide a much better way to program.  You should explore various alternatives: command line, IDE, hybrid, other.  Over the long term, you may have the opportunity to choose what environment works best for your or you may have one imposed upon you by your work environment.

There are enough IDEs for Java that it's hard to keep track of them all. When I taught this courwse a few yeas ago, Eclipse and NetBeans were the popular IDEs for Java. These days, I'm told that VSCode is one of the more popular Java IDEs. However, some alums at Microsoft have suggested that VSCode doesn't work well with Java because Microsoft wants you to use C sharp. IntelliJ is also popular.

We'll be using VSCode for our class. It gets the job done well enough and it's almost open-source software.

Some VSCode basics 
-------------------

We're going to let the folks at Microsoft tell you about VSCode in two videos.

* [Getting started with Visual Studio Code](https://code.visualstudio.com/docs/introvideos/basics)
* [Code editing in Visual Studio Code](https://code.visualstudio.com/docs/introvideos/codeediting)

Wrapping up
-----------

### Important Terms

* IDE
* Project

### Review Questions

* What are some features you can expect fo find in an IDE?
* Why might someone choose not to use an IDE?
* Why are we using VSCode for this course?

### Exploratory Questions

* How do you get VSCode to follow the Google Java coding conventions?

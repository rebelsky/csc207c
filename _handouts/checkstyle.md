---
title: Messages from checkstyle
section: handouts
author: Samuel A. Rebelsky
---
# {{ page.title }}

As part of your normal practice, you should be running checkstyle on your Java code with the [`csc207-checks.xml`](../files/csc207-checks.xml) set of checks. The most common way to do so is to execute the command `mvn checkstyle:check` at the top level of your Maven project (assuming the Maven project is configured correctly).

Here are some of the more common messages you may receive and how you should handle them. If you encounter other error messages that you'd like explained, please let me know.

## design

## indentation

`(indentation) Indentation: 'method def modifier' has incorrect indentation level 4, expected level should be 2.`

`(indentation) Indentation: 'method def' child has incorrect indentation level 8, expected level should be 4.`

> We use a two-space indent. You may inadvertently create a four-space indent. In VSCode, at the lower right-hand-corner, you should see something like "Spaces: 4". Click on that. A menu should appear at the top of the window. Click on "Indent Using Spaces". Another menu should appear. Click on 2. Then open the command palette (Ctrl-Shift-P) and type "Format Document".


## javadoc

`(javadoc) MissingJavadocMethod: Missing a Javadoc comment.`

> Fields, constructors, and methods all need Javadoc-style comments.
  Such comments begin with `/**` and end with `*/`.

  
## misc

`(misc) NewlineAtEndOfFile: File does not end with a newline.`

> As suggested, the last line of your file does not have a newline (return). You should add one.

`(misc) TodoComment: Comment matches to-do format 'TODO:'.`

> The phrase "TODO" in a comment generally suggests that there is something left to do in your code. Finish the task and remove the comment.

## regexp

`(regexp) Regexp: Line matches the illegal pattern 'STUB still in code'.`

> I tend to use the comment `STUB` for methods that are not yet implemented. See [Wikipedia on method stubs](https://en.wikipedia.org/wiki/Method_stub) for more info. You should finish implementing the method and then remove the comment.

`(regexp) Regexp: Line matches the illegal pattern 'System.out.println'.`

> Please do not use `System.out.println` for output. You should either create a `PrintWriter` (for normal interaction with the user) or use `System.err.println` (for error messages).

`(regexp) Regexp: Line matches the illegal pattern 'end brace without comment'.`

> I ask that you comment your end braces. When the code is indented correctly, that permits you to check whether braces match in the way you expect.

`(regexp) RegexpSingleline: Line has trailing spaces.`

> How's that for annoying? Nonetheless, Java style guides suggest that you remove trailing spaces. You are not required to do so for this class.

---

## Disabled messages (I hope)

_These are messages that I hope I've disabled._

`(design) HideUtilityClassConstructor: Utility classes should not have a public or default constructor.`

> All classes have a constructor used to build more objects in the class. If you don't specify a constructor, Java creates one. Classes that only provide static methods and fields should not have public constructors. Add something like the following.

> ```
/**
 * Utility classes should not have public consturctors.
 */
MyClass() {
} // MyClass()
  ```

> You need not fix this style error. 

`(misc) FinalParameters: Parameter args should be final.`

> You should not see this message. If you do, feel free to ignore it.


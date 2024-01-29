---
title: A drop of Java style
section: handouts
---
# {{ page.title }}

Although the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) provides comprehensive style guidelines, some students benefit from shorter guidelines. Here are some of the key guidelines we look for.

**Indentation**

* Use a _two space_ indent. Not tabs. Not four spaces. Two spaces!

**Capitalization**

* Class names are CamelCase and start with uppercase letters.
* Field, variable, and methods names are camelCase and start with lowercase
  letters.
* Constants are all caps, perhaps with underscores to separate words.

**Braces**

* In general, the open brace goes on the same line as a command (e.g.,
  the `if` or `while` and the close brace goes on a line by itself,
  at the same indent as the command.
* Use braces with most commands, even if you have only one statement
  in the body.
* Things within the braces should be indented by two spaces.
* Sam suggests that you comment your end-braces. That is not part of
  the Google standard.
* Please put a space before the open brace.

**Spaces**

* Make sure to have a space after each keyword.  For example,
  `if (TEST) { ... }` and `while (TEST) { ... }`.
* Don't put a space immediately after an open paren or before a close paren.

**Other**

* In general, you should declare your loop variables within the loop.
* Don't use a `for` loop as a substitute for a `while` loop.
* Use Javadoc comments for the class, fields, methods, and constructors.
    * Javadoc comments start with `/**` and end with `*/`.

---
title: Mini-Project 10
xsubtitle: Parsing and producing JSON
summary: |
  In this project, you will develop a JSON library for Java. JSON
  is "JavaScript Object Notation" and serves as a common format for
  passing information between programs.
collaboration: |
  Students should work in assigned pairs or triplets. Students may
  consult other students in the class (or anyone) as they develop
  your solutions.  If you receive help from anyone, make sure to
  cite them in your responses.
link: true
---
Often, we find that we need to transfer information from one program to another. For example, when designing Web applications, we may find that we want to query another Web application. For example, someone building a meal-planning app for students might want to be able to find out what food is available each day from the dining services app. To ease transfer, developers have considered a variety of standard notations for representing data. XML is one of the most general notations. However, XML is somewhat verbose, and most programmers tend to prioritize simpler approaches.

These days, JSON, the JavaScript Object Notation, is one of the most common mechanisms for sharing information between programs. Among other things, JSON permits you to build deeply nested structures of objects containing objects containing objects. As the [ECMA JSON standard](https://ecma-international.org/publications-and-standards/standards/ecma-404/) suggests,

> JSON is a lightweight, text-based, language-independent syntax for defining data interchange formats. It was derived from the ECMAScript programming language, but is programming language independent. JSON defines a small set of structuring rules for the portable representation of structured data.

In this assignment, you will build a simple parser for JSON.

## Background

You can find information about JSON at <https://www.json.org/json-en.html>.  You may also find it instructive to read the [ECMA JSON standard](https://ecma-international.org/publications-and-standards/standards/ecma-404/), which is one of the shortest standards I've seen.

In short, JSON is a recursively defined, C-like syntax for representing data.  JSON permits you to represent the following types of data:

* **Strings**, which are surrounded by quotation marks.  As in C, you may need to put a backslash before certain characters to represent special characters.  E.g., `"\n"` is a string containing just a newline and `"\\"` is a string containing a backslash.
* **Integers**, which are represented with an optional negative sign and then a series of decimal digits.  Leading zeros are not permited for negative numbers.  Hence, the value `-0` is permitted but `-01` and `-000321` are not.
* **Real numbers**, which are represented with an optional negative sign, a sequence of decimal digits, an optional decimal point plus more digits, and an optional `e` or `E` (for "exponent") that is followed by an optional sign (positive or negative) and more digits.  We distinguish real numbers from integers because real numbers have either a fractional portion or an exponent.  (Note that the official JSON standard does not distinguish between integers and real numbers; we're going to do so.)
* **Arrays**, which start with an open bracket, have zero or more JSON values separated by commas, and a close bracket.
* **Objects**, which are really just hash tables.  Hashes start with an open brace, and have zero or more key/value pairs separated by commas.  Keys are always JSON strings.  Values can be any kind of JSON value.
* **Constants**, of which there are three: `true`, `false`, and `null`.

## Representing JSON

Ideally, we would convert each JSON object into a Java object of the appropriate class.  But determining "the appropriate class" can be difficult.  And the Java mechanisms for building a new object given only a string for the class name are beyond the scope of this course.  Hence, we'll use a fairly generic set of classes.

* `JSONValue` is our handy-dandy interface.  It specifies which methods all JSON values provide and makes it easier to store these values in arrays and hashes.  These methods are, perhaps unsurprisingly, `toString()`, `equals()`, `hashCode`, `getValue()`, and `writeJSON()`.
* `JSONString` is used for strings and wraps the Java `String` class.
* `JSONInteger` is used for integers and wraps the Java `BigInteger` class.
* `JSONReal` is used for real numbers and wraps the Java `BigDecimal` class.
* `JSONArray` is used for arrays and wraps the Java `ArrayList` class.
* `JSONHash` is used for objects.  You'll implement this from scratch.
* `JSONConstant` is used for `null`, `true`, and `false`.

We will also have a `JSON` class that provides useful static methods.

* `JSONValue parse(String source)` parses a string to identify the JSON.
* `JSONValue parseFile(String fname)` parses a file to identify the JSON.
* `JSONValue parse(Reader source)` reads a JSON string from source.

## Work to do

You can find the starter code for the assignment at <https://github.com/Grinnell-CSC207/mp-json>.

Here's what you'll need to do for this assignment.

### Finish the basic classes

`JSONString`, `JSONInteger`, `JSONReal`, `JSONArray`, and `JSONConstant` are all partially implemented.  Finish implementing them.

### Implement hash tables

The basic classes are all implemented as "wrappers".  In contrast, I'd like you to build the `JSONHash` table as a hash table you implement yourself.  That is, you may not use Java's `HashMap` or anything similar; you should work with an array of `KVPair` values intead.

### Write the parser

Finally, you'll write the parser.

As you might expect, as you parse a string (or part of a string), you'll need to build JSON values on the fly.  For example, if you see a double quotation mark, you should keep looking forward until you find the closing quotation mark, gather all the characters (possibly in a `StringBuilder`), and then call the `JSONString` constructor.  In contrast, if you see an open bracket, you should create a new `JSONArray` and then recursively parse the next values you see, stopping when you hit an end brace.

### Ask questions

As always, you'll find it useful to ask questions along the way.

## Rubric

_Forthcoming._

## Questions and answers

What's the difference between `toString` and `writeJSON`?

> `toString` returns a string; `writeJSON` writes to a file (or elsewhere).

> In most cases, the string you return will be similar to the JSON you
  write. The primary difference that I see is that `toString` should just
  return the underlying string for `JSONString`, but should add the
  quotation marks and the backslashes when printing the JSON.

Should we do probed hash tables or chained hash tables?

> It's up to you. 

Would you recommend that we do chaining or probing?

> Chaining is generally easier, although perhaps a bit less space efficient.

How should we implement the lists for chained hash tables?

> I'd recommend usin `ArrayList` objects.

How should we implement `hashCode`?

> In most cases, you can just call the `hashCode` method of the underlying
  object.

What goes in our Main class?

> There is no Main class. You are writing utility methods; while you should
  test them (e.g., by reading a JSON file and then writing it again), you
  aren't making a program that is supposed to do something.

Will you provide us with tests or experiments?

> Stay tuned.

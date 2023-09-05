---
title: Object semantics
summary: |
  We consider ways of looking at the meanings of objects
---
As clients of Java objects, we know a bit about them.  In particular,

* We can create objects with the `new` operator and a constructor.
    * We can sometimes create objects using other methods.
* We can ask objects to perform tasks by writing the object name,
  a period, a method name, and any arguments.
* We can (sometimes) ask objects for their fields.  
    * Information hiding suggests that we should rarely access the fields
      of an object directly.

But what's going on behind the scenes?  Let's consider how Java objects and classes might be stored in memory (or at least how we can think about Java objects being stored in memory).

...

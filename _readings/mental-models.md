---
title: Mental models of Java programs
summary: |
  We consider some mental models of Java programs, particularly how
  we might think about the parts of a program being laid out in memory
  at runtime.
prereqs: |
  [OOP Basics](../readings/oop-basics).
---
Introduction
------------

As software developers, we need to be able to predict how our code will run (or, more precisely, how the computer or Java Virtual Machine) will run our code. As importantly, when we do not get the results we expect, we need a model of how the computer runs our code in order to figure out went wrong. We often refer to our view of how the computer runs code as a "mental model". It's okay if our mental model is incomplete, and even if it's not completely accurate. The key issue is that we can use the model to understand how our code works or does not work.

As you might expect, our mental model for Java will incorporate issues common to most imperative languages as well as some additional issues to handle Java's object-orientation, including the need to represent objects, classes, and inheritance.

Lookup tables
-------------

Throughout your program, you will use identifiers (variables, fields, parameters) to refer to values. The particular details of how the compiler and/or interpreter translate names to memory addresses (or registers) are not something we should consider in our mental models. For our mental model, we can think of having one or more "lookup tables" that take each identifier and map those identifiers to a corresponding value.

For example, consider the following declarations.

```
int x = 5;
double y = 2.1;
```

We might envision that as the following table.

```
x : 5
y : 2.1
```

We use lookup tables throughout the program. Such tables can store the state of an object, the parameters and local variables of a method, and more.

So far, so good. We have a way to represent the mapping of variable names (and field names and parameter names) to primitive values. But what about object values? That's a bit more complicated.

First, a detour.

It's all bits
-------------

As you've likely learned already, behind the scenes, everything in a computer program is represented (or can be represented) as a sequence of 0's and 1's, which we call "bits". The computer and the programming language determine how to interpret those 0's and 1's. Fortunately, while C programmers often have to pay close attention to this representation in modeling program behavior (after all, C permits you to treat any series of bits as any type of value), the Java compiler and interpreter hide these basic representations from you.

Nonetheless, there is one important distinction that you may have to make in your model. Most primitive types (e.g., integers, doubles, characters) are represented directly and stored as their bits. In contrast, most compound types (particlarly objects and classes, even "basic" classes like Strings or even Integer objects) end up with a more complex representation. In particular, we ofen use *references* to objects, rather than the contents of the objects themselves.

As we noted, the primitive types are stored as bits. These references are stored as bits, too. In reality, they are just memory locations.

Can you misinterpret or reinterpret the bits in another form? In C, that's standard practice. In Java, the compiler doesn't give you direct access to the bits, so it can ensure that you treat them appropriately.

Why references?
---------------

You may ask yourself why we store references rather than objects in lookup tables. One reason is efficiency. We don't want to have to copy a complete object each time we, say, do a functional call with the object. But there's another important reason: We can't always predict the "size" of an object (how many bits it takes to represent it). Suppose we have a class, `Person`, and we know the number of bits associated with person. It seems like we could make enough space in the table if we had a variable of type `Person`. However, as you know, Java lets us make subclasses, say `Student`, that adds information (e.g., the school they attend). Since we can store an `Student` in a `Person` variable, the room we would set aside for a `Person` won't be enough for a `Student`.

Here's some pointless code.

```
Person p = new Person("Jo Doe", 32);
int x = 11;
```

Here's a lookup table for that code.

```
p : name : "Jo Doe"
    age : 32
x : 11
```

As you'll note, we've allowed two "lines" in the table for the name and age.

Now, suppose we assign a `Student` to `p`.

```
p = new Student("Do Jo", 18, "SmileyCo");
```

Since there are only two lines reserved in the table for `p`, we don't
have room for all three fields of a student.

Of course, if we're sketching this by hand, we could probably "stretch out" our table or write multiple fields in a row. However, behind the scenes, the computer has only reserved a fix number of bits for `p`, and so fitting something in is not nearly as easy. And that doesn't even count the complexity of dealing with variable length strings.

Hence, instead of storing objects in both the real and simulated lookup tables, we instead store references.

Let's return to our joyfully pointless code, which we repeat here.

```
Person p = new Person("Jo Doe", 32);
int x = 11;
```

We should conceive of the lookup table something like the following.

```
p : *---------------------> Person 
x : 11                      +----------+
                            | name : *--------> String
                            | age : 32 |        +---------------+
                            +----------+        | length : 6    |
                                                | char[0] : 'J' |
                                                | char[1] : 'o' |
                                                | char[2] : ' ' |
                                                | char[3] : 'D' |
                                                | char[4] : 'o' |
                                                | char[5] : 'e' |
                                                | char[6] : nul |
                                                +---------------+
```

Note that each object has its own lookup table for its fields. We've given a detailed view of our string. We'll usually be a bit more casual about the representation of strings; we include the longer string object to clarify what is likely happening with the storage.

Now, let's suppose that we once more assign a `Student` to `p`.

```
p = new Student("JD", 18, "SmileyCo");
```

We'll need to build the new `Student` somewhere in our diagram and update our reference to refer to ("point to") that new object.

```
p : *---------\             Person 
x : 11        |             +----------+
              |             | name : *--------> String
              |             | age : 32 |        +--------------+
              |             +----------+        | length : 6   |
              |                                 | str[0] : 'J' |
              \-----------> Student             | str[1] : 'o' |
                            +------------+      | str[2] : ' ' |
                            | name : *-------\  | str[3] : 'D' |
                            | age : 18   |   |  | str[4] : 'o' |
                            | school : *---\ |  | str[5] : 'e' |
                            +------------+ | |  | str[6] : nul |
                                           | |  +--------------+
                                           | |
                        /------------------/ \-> String
                        |                       +---------------+
                        |                       | length : 2    |
                        \--> School             | str[0] : 'J'  |
                             +-----------+      | str[1] : 'D'  |
                             | ...       |      | str[2] : nul  |
                             +-----------+      +---------------+
```

What happens to the `Person` that `p` previously referenced, as well as the `String that `Person object referenced? Eventually, the Java garbage collector will come along and clean them out.

A danger of references
----------------------

This may seem all well and good (except that we are already clogging our screen with objects and references to those objects). However, it turns out that there are some important conceptual differences between the treatment of primitive types and objects. Let's start by considering a very simple class that holds only one integer.

```
public class Int {
  public int i;
  public Int(int i) {
    this.i = i;
  } // Int(int)
} // class Int
```

Now, let's define a few variables.

```
int a = 5;
Int x = new Int(5);
```

Here's our model for what those definitions have done.

```
a : 5
x : *---------> Int
                +-------+
                | i : 5 |
                +-------+
```

Now, what happens if we "copy" `a` and `x`?

```
b = a;
y = ;
```

```
a : 5
x : *---------> Int
            /   +-------+
            |   | i : 5 |
            |   +-------+
b : 5       |
y : *-------/
```

That's right, both `x` and `y` point to the same object. Remember: One of the reasons Java uses references is to save time and space for copying.

But that leads to some potentially unexpected behavior.  Suppose we increment both `b` and `y`.

```
b = 6;
y.i = 6;
```

```
a : 5
x : *---------> Int
            /   +-------+
            |   | i : 6 |
            |   +-------+
b : 6       |
y : *-------/
```

When we followed the reference from `y`, we incremented the field in the corresponding object. That means we also "changed" `x`. However, the change to `b` did not affect `a`. When we change objects or arrays, we need to remember that we will see indirect effects as well as direct effects.

Representing objects
--------------------

As you've seen, when representing an object, we should include its type (class) and a lookup table for its fields. Is there anything else we need to represent? 

Conceptually, we need a way to access the methods of the object so that we can decide what happens when, say, someone calls `obj.fun()`. The easiest way to do so is to assume that every object has a link to a corresponding class somewhere in memory. Writing the type at the top provides us with an indirect representation of that link; we will likely find that technique more convenient than drawing a reference. Nonetheless, we should remember that, behind the scenes, Java is storing a link.

Representing classes
--------------------

If objects refer to classes, we'll need to consider what information we store for each class. Take a moment and make a list for yourself.

.

.

.

.

.

Are you done? Great. Here's what we've come up with.

* We should represent the class's *name* (presumably as a string).
* We should have a lookup table for all of the class's *static fields*.
* Since we are relying on the class to provide the code for methods, we should have a look table for all the class's *methods and constructors*. We'll call this the "method table".
* The prior two entries may remind us that we should also have a lookup table for *static methods*.
* We should also have links to the class's *superclass* and perhaps to a list of *implemented interfaces*.

Note that there are two ways to model the method table: We can think of the table as containing only the methods declared in the class or we can think of the table as containing all the methods the class has, including all of the inherited methods.

The two models give us a slightly different understanding of what happens in a function call.

Suppose we call `obj.fun()`. How does the Java Virtual Machine know what code to run, since `obj` could potentially be one of many classes (the class it was declared as or any subclass)?

In the first model of method tables, we first check in the method table for the  object. If `fun` is in that table, we follow the reference to the code and use that code. If `fun` is not in that table, we go up to the immediate superclass and look again. If `fun` is in that table, we follow the reference to the code and use that code. If not, we do it all over again.

```
class X {
  void fun();
  ...
}
class Y extends X {
  void fu();
  public toString() { return "Why?"; }
  ...
}
class Z extends Y {
  void f();
  ...
}

X obj = new Z();
obj.fun();
```

Here's a diagram of those classes using the "new methods only" model.  Instead of drawing links to the superclasses, we've just included their names. (Hey, mental models are maleable.)

```
 Class
+----------------+
| Name: Object   |
| Methods:       |
|   toString : *------> code
|   equal : *---------> code
|   hashCode : *------> code
|   ...          |
+----------------+

 Class
+----------------+
| Name: X        |
| Methods:       |
|   fun : *------------> code
| super: Object  |
+----------------+

 Class
+----------------+
| Name: Y        |
| Methods:       |
|   fu : *-------------> code
|   toString : *-------> code
| super: X       |
+----------------+

 Class
+----------------+
| Name: Z        |
| Methods:       |
|   f : *-------------> code
| super: Y       |
+----------------+

obj : *-------------------> Z
                            +----------+
                            |          |
                            +----------+
```

What happens with the `obj.fun()` call? 

* First, we follow the reference from `obj` to the corresponding object.
* Then we follow the reference from that object's class to the `Z` class.
* We look in the table. The only method in the table is `f`. Time to
  try again.
* We follow the reference to the `X`'s superclass, `Y`.
* We look in `Y`'s methods table. The only method in the table is `fu`. Time to try again.
* We follow the reference to `Y`'s superclass, `Z`.
* We look in `Z`'s methods table. We find `fun` and execute the code.

That's a lot of pointer chasing, isn't it? Hence, we can also model the methods table as having *all* the methods available to the object. Here's what that might look like.

```
 Class
+----------------+
| Name: Object   |
| Methods:       |
|   toString : *--------------------------------------------> code
|   equal : *------------------------------> code             ^
|   hashCode : *-----------> code            ^^^              |
|   ...          |           ^^^             |||              |
+----------------+           |||             |||              |
                             |||             |||              |
 Class                       |||             |||              |
+----------------+           |||             |||              |
| Name: X        |           |||             |||              |
| Methods:       |           |||             |||              |
|   hashCode : *-------------/||             |||              |
|   equal : *-----------------++-------------/||              |
|   toString : *--------------++--------------++--------------/
|   fun : *--------> code     ||              ||
| super: Object  |    ^^      ||              ||
+----------------+    ||      ||              ||
                      ||      ||              ||
 Class                ||      ||              ||
+----------------+    ||      ||              ||
| Name: Y        |    ||      ||              ||
| Methods:       |    ||      ||              ||
|   fun : *-----------/|      ||              ||
|   hashCode : *-------+------/|              ||
|   equal : *----------+-------+--------------/|
|   fu : *-------------+-------+------> code   |
|   toString : *-------+-------+> code  ^      |
| super: X       |     |       |  ^     |      |
+----------------+     |       |  |     |      |
                       |       |  |     |      |
 Class                 |       |  |     |      |
+----------------+     |       |  |     |      |
| Name: Z        |     |       |  |     |      |
| Methods:       |     |       |  |     |      |
|   fun : *------------/       |  |     |      |
|   hashCode : *---------------/  |     |      |
|   toString : *------------------/     |      |
|   fu : *------------------------------/      |
|   f : *------------> code                    |
|   equal : *----------------------------------/
| super: Y       |
+----------------+

obj : *-------------------> Z
                            +----------+
                            |          |
                            +----------+
```

Isn't that fun? (No pun intended.) As you can tell, this second model involves more memory and more references. On the other hand, finding out which method to call is really easy.

* Follow the reference from `obj` to the corresponding object.
* Follow the reference from that object to the corresponding class.
* Look up the method in the table and follow the reference to the code.

In both models, it's important to remember that method calls are determined dynamically (at run time) not statically (at compile time). That is, we start with the corresponding object and look for methods there, rather than starting with the known type/class.

I'll admit that I find the first model simpler, especially since we build the tables in the second model by following the principles from the first model.

Key points
----------

* Whenever we call `new`, we create a new object in memory.
* Each object contains a lookup table for its fields and a reference to its class.
* When we assign objects or pass them as parameters, we are really assigning (or passing) references to objects.
* Since there can be many references to the same object, we need to pay attention to how a change through one variable can affect what we see through another.
* Each class contains lookup tables for its static fields, object methods/constructors, and static methods. Each class (other than `Object`) also contains a reference to it superclass.
* To execute a method on an object, follow the reference to the object and then to the object's class. Then look up the method "appropriately" (either in the giant reference table or by tracing up through parents).
* The method associated with a class is the "lowest level" declaration of that method in the inheritance hierarchy.

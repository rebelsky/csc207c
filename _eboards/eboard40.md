---
title: "Eboard 40: Traversing graphs"
number: 40
section: eboards
held: 2024-05-06
link: true
---
# {{ page.title }}

**You are being recorded and transcribed.**

_Approximate overview_

* Administrivia 
* Questions
* Lab

Preliminaries
-------------

### Upcoming work

* Tuesday, 2024-05-07, 11:00pm, Readings
    * [Wikipedia: Prim's Algorithm](https://en.wikipedia.org/wiki/Prim%27s_algorithm)
    * [Wikipedia: Kruskal's Algorithm](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)
* Saturday, 2024-05-11, 11:00pm, New set of LAs, repeated + old LAs

### Tokens

* Tuesday, 2024-05-07, noon, Some PDR.
  _CS Table: CS Humor_.
* Tuesday, 2024-05-07, 8:00pm, Science 3819.
  _Mentor Session_. Make Elene and Sam happy. Show up to mentor sessions!

Cultural

* Most days, 2024-04-xx and 2024-05-xx, 11am-6pm,
  Grinnell College Museum of Art.
  _BAX 2024_. Shouldn't it be BAE?
* Friday, 2024-05-10, 4:00--5:00pm, HSSC N1170.
  _Middle of Everywhere_ 

Peer

Wellness

* Friday, 2024-05-10, 5:00pm--??:??pm, Merrill Park West.
  _CS Picnic!_ Survey forthcoming.

Misc

### Other good things to do (no tokens)

### Other questionable things (no tokens)

LA Notes
--------

_Some things that went wrong, and a few that went right._

### Things that will get you an automatic "Redo" on an LA

* Printing error messages in the middle of utility code. Exceptions
  exist for a reason.
* Sample code that is unlikely to compile.
* Use of //-style comments to document methods.

### ADTs

Please phrase ADTs as interfaces.

### Sets

A set is an unordered collection of values. No value in the set appears
more than once.

### Lists

I don't care about the (stupid) decisions that Sun/Oracle made. Lists
are not designed to be indexed. Arrays are the primary indexed data structure.
**Do not have operations like `get(int index)` in your List ADT.**

### Hash tables

Hash tables are **not** associative arrays. They have a similar set of
methods, but that's because both implement the Dictionary (or MAP) ADT.

### Incorrect descriptions of BSTs

INCORRECT
A binary search tree is a binary tree in which the key of each
node's left subchild is less than the key of the node and the key
of the node's right subchild is greater than the key of the node.
INCORRECT

```
        7
      /   \
     5     8
    / \   / \
   2   9 1   9
```

### Bad design: Data structures

_Taken from "Design Data Structures"_

```
/**
 * Records in our tournament.
 */
class Record {
  /** An array of wins, losses, and ties. */
  int[] wlt;

  /** Create a new, empty, record. */
  public Record() {
    wlt = new int[3];
    wlt[0] = 0;
    wlt[1] = 0;
    wlt[2] = 0;
  } // Record()
} // Record

/**
 * The tournament
 */
class Tournament {
  // ...
  public record(String team) {
    Record r = this.lookup(team);
    return r.wlt;
  } // record(String)
} // class Tournament
```

### Interesting design: Data structures

One of you decided to have fields for the "current winner" and their score,
updating after each victory or tie. That made "winner" much faster. 

I like this as an example of amortizing the cost.

### Bad design: Object design

Here's are some classes I wrote to give an example of how a shelter
works. The Shelter class uses two lists, one of Cats and one of
Dogs. Both of those classes have a name, age and breed variable,
but they have different sounds that they make, and methods to go
along with those sounds. The Cat and Dog classes are contributing
to the Shelter class, which implements the other classes.

```
public class Dog {
    private String name;
    private int age;
    private String breed;

    public Dog(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String setName(int name) {
        this.name= name;
    }

    public int setAge(int age) {
        this.age = age;
    }

    public String setBreed(int breed) {
        this.breed= breed;
    }

    public void bark() {
        System.out.println(name + " barks!");
    }
}

public class Cat {
    private String name;
    private int age;
    private String breed;

    public Cat(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String setName(int name) {
        this.name= name;
    }

    public int setAge(int age) {
        this.age = age;
    }

    public String setBreed(int breed) {
        this.breed= breed;
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }
}

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Cat> cats;
    private List<Dog> dogs;

    public Shelter() {
        cats = new ArrayList<>();
        dogs = new ArrayList<>();
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void showAvailablePets() {
        System.out.print("Cats: ");
        for (Cat c: cats) {
            System.out.println(c.getName() + " - " + c.getBreed() + " - " + c.getAge());
            System.out.println(c.meow(););
        }

        System.out.println("Dogs: ");
        for (Dog d: dogs) {
            System.out.println(d.getName() + " - " + d.getBreed() + " - " + d.getAge());
            System.out.println(c.bark());
         }
    }
}
```

### Ethical reuse

Ethical reuse involves many things:

* Making sure that you can legally/ethically use the code.
* Making sure that you abide by any restrictions on the code's use.
* Providing proper citation (both in the code file and in your README).

Questions
---------

### Administrative

### LAs

Can you move the LA due date to Saturday night?

> Sure. 

### Misc

Labs
----

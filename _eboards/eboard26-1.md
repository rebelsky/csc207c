---
title: "Eboard 26 (Section 1): Graphs"
number: 26
section: eboards
held: 2024-12-05
link: true
---
# {{ page.title }}

**You are probably being recorded (and transcribed)**  

_Approximate overview_

* Preliminaries
    * Notes and news
    * Upcoming work
    * Tokens
    * Questions
* The shortest path algorithm

Preliminaries
-------------

### News / Notes / Etc.

* Class work
    * I have dropped MP 11.
    * I have dropped one of the LAs (design patterns).
    * Because I have not caught up on tokens, everyone has infinitely 
      many tokens.  (You may not use tokens to make up for missing readings, 
      labs, pre-reflections, or post-reflections.)
    * I've added redos for the mini-projects you have not submitted so that
      you can fix things you already know are wrong.
* Preregistration
    * Multiple second-years did not get a CS class in the spring. I don't
      know how many. The CS department isn't happy about this result, but
      don't really have a way to address it.
    * We plan to have more faculty next year, so we hope that (a) we won't
      have the problem again and (b) those who need two courses next year
      will be able to get two courses.

### Upcoming work

* Thursday, 2024-12-05
    * [MP 10](../mps/mp10) due.
    * [Submit MP10 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5380849)
* Friday, 2024-12-06
    * [Submit post-reflection for MP10](https://www.gradescope.com/courses/818402/assignments/5380852)
* Monday, 2024-12-09
    * [SoLA 12](../los/sola12) due
        * New: [ADT/DS 4: Priority queues](https://www.gradescope.com/courses/818402/assignments/5402118)
        * New: [ADT/DS 6: Hash tables](https://www.gradescope.com/courses/818402/assignments/5402119)
        * New: [ADT/DS 8: Heaps](https://www.gradescope.com/courses/818402/assignments/5402114)
        * New: [Algorithms 5: Heap sort](https://www.gradescope.com/courses/818402/assignments/5402117)
        * Dropped: OOP #07: Design Patterns
    * Reading: Two algorithms for minimum spanning trees
        * [Wikipedia: Prim's Algorithm](https://en.wikipedia.org/wiki/Prim%27s_algorithm)
        * [Wikipedia: Kruskal's Algorithm](https://en.wikipedia.org/wiki/Kruskal%27s_algorithm)
    * [Submit reading response for class 27](https://www.gradescope.com/courses/818402/assignments/5404446)
* Thursday, 2024-12-12
    * MP redos
* Saturday, 2024-12-12
    * Late MP redos
* Monday, 2024-12-16
    * [SoLA 13](../los/sola13) due
        * New: ADT/DS 9: Graphs
        * New: Algorithms 8: Graph and tree traversal
        * New: Algorithms 9: Shortest path
        * New: Algorithms 10: Greed
        * New: Algorithms 11: Divide and conquer
* Friday, 2024-12-20
    * MP redos
    * [SoLA 14](../los/sola14) due.

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Thursday, 2024-12-05, 4:00--5:00 p.m., Science 3821
  _CS Extras_
* Sunday, 2024-12-08, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

#### Multicultural

* Friday, 2024-12-06, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: ???_ 

#### Peer

* Friday and Saturday, Wall Theatre.
  _One-act festivals_
* Friday and Saturday, all day (1 hour suffices), Osgood Natatorium.
  _Pioneers Swim Meet_
* Sunday, 2:00 p.m., Sebring-Lewis.
  _Grinnell Singers_

#### Wellness

* Tuesday, 2024-12-03, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-12-03, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.
* Friday, 2024-12-06, 9:00 a.m.--3:00 p.m., CRSSJ.
  _Holiday baking_.
* Saturday, ???, Harris.
  _Winter Waltz_

#### Misc

* Friday, 2:30--3:50 p.m, HSSC N1112
  _Alumni Careers: Albert Owusu-Asare_
  **Sam recommends highly.**

### Other good things (no tokens)

Questions
---------

### Administrative

**Can we get an I on an MP and still get an A?**

> No.

### Graphs

### Miscellaneous

Dijkstra's shortest path algorithm
----------------------------------

TPS

_What is a shortest path?_

* Inputs:
* Outputs:
* Characteristics:

_What are the core ideas of Dijkstra's algorithm?_

*
*

### The algorithm

```text
To find the shortest path from SOURCE to SINK,
  Indicate that all vertices have infinite distance from SOURCE
  Indicate that SOURCE has a distance of 0 from itself
  While unmarked(SINK) and there exists an unmarked node with finite distance from SOURCE
    Find the nearest unmarked vertex, U
    Mark U
    For each unmarked neighbor, V, of U
      If distanceTo(U) + edgeWeight(U,V) < distanceTo(V)
        Note that the best known path to V is the path to U plus the
          edge from U to V.
        Update the distance to V
  Report the path to SINK, if there is one
```

Implementing Dijkstra's shortest path algorithm
-----------------------------------------------

_TPS_

### a. How will you represent the distance (sum of edge weights) from the source to each vertex?

### b. How will you represent the path to each vertex?

### c. How will you efficiently "find the nearest unknown vertex", particularly given that the distance of vertices can change?

### d. How will you mark vertices?

Labs
----

Two labs today!

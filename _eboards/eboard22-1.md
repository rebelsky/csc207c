---
title: "Eboard 22 (Section 1): Binary search trees"
number: 22
section: eboards
held: 2024-11-19
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
* Applying the ACM code of ethics
* Designing a Dictionary/Map ADT
* Binary search trees, reviewed
* Lab(s)

Preliminaries
-------------

### News / Notes / Etc.

* We have both talking and lab(s) today. 
* There are two labs; it's okay if you don't do much of the second one.
* Please fill out peer educator evaluation forms.
* Note that "lower-bound inclusive, upper-bound exclusive" is a common
  approach.  Think about, say, `String.substring(lb, ub)`. I strongly
  ecnourage you to use it.
    * `String.substring(lb, mid) + "," + String.subString(mid, ub)`
    * The length of the range is `ub - lb`.
* I've added a three-day extension for MP9. It's now due on Sunday to
  give you another weekend.
* Grading updates
    * MPs/A: Was 5E, 5M, 1R, now 4E, 5M, 2R
    * MPs/B: Was 3E, 6M, 2R, now 2E, 5M, 3R
    * MPs/C: Was 2E, 5M, 4R, now 1E, 5M, 5R
    * MPs/D: Remains 4M, 5R, 2I
    * LAs/A: Was 46/48, now 45/48
    * LAs/B: Was 44/48, now 43/48
    * LAs/C: Was 42/48, now 41/48
    * LAs/D: Remains 15/48

### Upcoming work

* Wednesday, 2024-11-20
    * [Submit lab writeup from class 22 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5346898)
    * Reading for class 23: 
      [Osera 12: Hashing](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/osera/chap12.pdf)
    * [Submit reading response for class 23 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5346927) (Time plus questions)
* Thursday, 2024-11-21 
    * MP10 assigned (due in two weeks)
* Sunday, 2024-11-24
    * [MP9](../mps/mp09) (Blockchains) due.
    * [Submit MP9 on Gradescope](https://www.gradescope.com/courses/818402/assignments/5321058)
* Monday, 2024-11-25
    * [Submit post-reflection for MP9](https://www.gradescope.com/courses/818402/assignments/5321060)
    * [SoLA 10](../los/sola10) due
        * New: [ADT/DS #5: Dictionaries](https://www.gradescope.com/courses/818402/assignments/5354889)
        * New: [ADT/DS #7: BSTs](https://www.gradescope.com/courses/818402/assignments/5354897)
        * New: [Development #9: Use libraries](https://www.gradescope.com/courses/818402/assignments/5354901)
        * New: [Development #12: Professional ethics](https://www.gradescope.com/courses/818402/assignments/5354912)
* Tuesday, 2024-11-26

### Tokens

_If you'd like to suggest token events, please let me know in advance of 
class._

#### Academic/Scholarly

* Tuesday, 2024-11-19, noon--1:00 p.m., Day PDR.
  _CS Table: Gopher_
* Tuesday, 2024-11-19, 4:15 p.m., Burling Lounge.
  _Fernanda Eliott Harris Lecture, 
   "Can Insights from the Multi-Agent Systems’ Coordination/Cooperation 
    Dichotomy Enlighten Empathy Investigation?"_
* Thursday, 2024-11-21, 4:00--5:00 p.m., Science 3821.
  _CS Extras_
* Sunday, 2024-11-24, 7:00--8:00 p.m., Science 3819.
  _Mentor Session_

#### Cultural

* Weekend of November 23, Roberts Theatre.
  _Pity_

#### Multicultural

* Friday, 2024-11-22, 4:00--5:00 p.m., HSSC N1170 - Global Living Room.
  _Middle of Everywhere: Somewhere_

#### Peer

* Tuesday, 2024-11-19, 7:00--8:00 p.m., HSSC S1325.
  _GHAMP Study Break_
* Thursday, 2024-11-21, 7:00--8:00 p.m., HSSC S1325.
  _GHAMP Study Break_
* Friday, 2024-11-22, 8:00 p.m., Main Lounge.
  _Improv Double Header_.

#### Wellness

* Tuesday, 2024-11-19, 4:30--6:30 p.m., BRAC P103 - Multipurpose Dance Studio.
  _Wellness Yoga_.
* Tuesday, 2024-11-19, 4:30--6:30 p.m., Secret Place.
  _Forest Bathing_.
* Tuesday, 2024-11-19, 5:00--6:00 p.m., HSSC S1003 - Atrium.
  _Therapy Dogs_.

#### Misc

* Fill in the peer-educator evaluation form (see email).
* Friday, 2024-11-22, 5:00--8:00 p.m., Downtown Grinnell.
  _Jingle Bell Holiday_.

### Other good things (no tokens)

Notes on MP9
------------

* Goals of assignment
    * Build something like a linked list
    * Build iterators for the structure
    * In a non-trivial context
    * Read and understand documentation for library classes
    * More collaboration
* Due date extended until Sunday (with late assignments accepted until Tuesday).
* These hashes are not the same as the hash values/hash codes we use for 
  hash tables.
    * The also aren't the same as hash tables.
    * These hashes are values we compute so that we can validate
      data in the future. If we compute a hash now and compute a hash
      later, the two hashes should be the same. (Hashes are generally
      smaller than the data.)

Questions
---------

### Administrative

**Are you going to increase the number of missing assignments permitted?**

> No

**Can I treat non-missing assignments as tokens?**

> No

**Can I use tokens to permit more non-missing assignments?**

> Probably not.

### MP9

### Miscellaneous

Applying the ACM Code of Ethics
-------------------------------

<https://www.acm.org/code-of-ethics>

_Modified from <https://ethics.acm.org/code-of-ethics/using-the-code/case-malware-disruption/>.  Please don't read the analysis._

Responsible Services advertised its web hosting services as “cheap, guaranteed uptime, no matter what.” While some of Responsible’s clients were independent web-based retailers, the majority were focused on malware and spam. Several botnets used Responsible’s reliability guarantees to protect their command-and-control servers from take-down attempts. Spam and other fraudulent services leveraged Responsible for continuous delivery. Corrupted advertisements often linked to code hosted on Responsible to exploit browser vulnerabilities to infect machines with ransomware.

Despite repeated requests from major ISPs and international organizations, Responsible refused to intervene with these services, citing their “no matter what” pledge to their customers. Furthermore, international pressure from other governments failed to induce national-level intervention, as Responsible was based in a country whose laws did not adequately proscribe such hosting activities.

Ultimately, Responsible was forcibly taken offline through a coordinated effort from multiple security vendors working with several government organizations. This effort consisted of a targeted worm that spread through Responsible’s network. This denial-of-service attack successfully took Responsible’s machines offline, destroying much of the data stored with the ISP in the process. All of Responsible’s clients were affected. No other ISPs reported any impact from the worm, as it included mechanisms to limit its spread. As a result of this action, spam and botnet traffic immediately dropped significantly. In addition, new infections of several forms of ransomware ceased.

_TPS: Was the response appropriate?  Ethical?  What principles would permit the security vendors and government organizations to write such software?_

* Neither Responders nor Responsible were following the ACM code of ethics.
    * 1.2 Avoid harm
        * Responsible was indirectly doing harm. Permitting harm from your users
          seems to violate this policy. (DMCA has a "safe harbor" provision
          for ISPs - you're not responsible for your users.)
        * Responders by taking down innocent retailers also did harm.
          Is it justified?
              * Yes: Some may need to suffer for the greater good.
    * 3.1 Keep the Public good in mind
* Responsible was clearly ignoring the code.
    * 3.7 Recognize and take special care of systems that become integrated 
          into the infrastructure of society.
* Maybe Responders were doing okay things
    * 3.4 Articulate, apply, and support policies and processes that reflect the principles of the Code.
        * Responders attempted.
        * Responders took "appropriate action"
    * 1.6 Respect privacy
        * Malware doesn't.
* Maybe not
    * 3.6 Use care when modifying or retiring systems.
        * Responsibility to the users of those systems.
* More general issues
    * Perhaps there's a question of proportion: How many "good" sites are there.
    * Context: How was Responsible marketed?
    * Questions of how people ended up with their sites on Resonsible.

Designing a Dictionary (Map) ADT
--------------------------------

Strategy: 

* A generalized way to create a collection in which you can look up values
  by their corresponding keys.
* "Arrays with homogeneous keys of types other than integer".

Applications:

* Keep track of deposits for a block chain.
* Keep track of the relationship between images and words that those
  images represent.
* Keep track of student grades.
* Keep track of events that happen on different days.

Methods: (TPS)

```java
public interface SimpleMap<K, V> {
  /**
   * Set the value associated with a given key. If the key is already
   * in the map, replace the given value.
   *
   * @param key
   *   The key whose value we are setting.
   * @param value
   *   The associated value.
  public void set(K key, V value);

  /**
   * Get the value associated with a ke.
   *
   * @param key
   *   The key used for searching
   *
   * @return the corresonding value.
   *
   * @throws IndexOutOfBoundsException
   *   If the key is not there.
   */
  public V get(K key);

  /**
   * Determine whether or not a key is in the map.
   *
   * @param key
   *   The key we're checking.
   *
   * @return true if the key is in the map and false o/w.
   */
  public boolean hasKey(K key);

  /**
   * Remove a key/value pair.
   *
   * @param key
   *   The key we're removing.
   *
   * @return the correspond value that is being removed.
   */
  public V remove(K key);

  /**
   * Determine how many elements (key/value pairs) are in the map.
   *
   * @return how many elements there are.
   */
  int size();

  /**
   * Get an iterator.
   */
  Iterator<KVPair<K, V>> iterator();

  /**
   * Get an iterator of the keys.
   */
  Iterator<K> keys();

  /**
   * Get an iterator that produces the values in sorted order.
   *
   * NO!
   */
  Iterator<KVPair<K, V>> sortedIterator();

} // SimpleMap<K, V>
```

Side note:

* Regular exceptions: Must be declared with a "throws clause"; clients
  must try/catch or throw the same exceptions.
* Runtime exceptions: Do not need to be declared; clients do not need
  to catch (but can). If the exceptions aren't caught, the program crashes.
  Example: `IndexOutOfBoundsException`.

Implementing the Dictionary (MAP) ADT
-------------------------------------

Arrangements

* Associative Array: An array of key/value pairs.
* Association List: A list of key/value pairs.
* Sorted Array of Key/Value pairs.
* Sorted List of Key/Value pairs.
* Binary search tree: A tree in which smaller keys fall to the left
  and larger keys fall to the right. (This holds at every node.)
* Hash table: Forthcoming.

Binary search trees
-------------------

Let $$n$$ be the number of elements in the tree and $$h$$ be the height of the tree.

Lab
---

Make sure that the lab repo ends with `-maven`.

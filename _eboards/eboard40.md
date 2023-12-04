---
title: "EBoard 40: Minimum spanning trees"
number: 40
section: eboards
held: 2023-12-04
link: true
---
# {{ page.title }}

**Warning** This class is being recorded (and transcribed) (assuming Teams succeeds).

_Approximate overview_

* Administrivia
* Questions
* Pre-lab
* Lab
* Implementing graphs (maybe)

Administrivia
-------------

* Today's important lesson: Do not attempt to trim your beard while you
  are over-tired.
* LAs (aka "Portfolio Entries") have been posted.
* Replacement MPs have been posted.
* MP redos have not been posted. 
* I have no scheduled office hours during Finals Week. I will be in
  my office as much as I can. Feel free to DM me to check if I'm there
  or to ask questions.

### Upcoming Token activities

Academic

* Monday, 2023-12-04, noon--1pm, _Lunch & Learn: Summer Research_

Cultural

* Wednesday, 2023-12-06, Noon--1:30pm, _Vox Feminae Christmas Concert_

Peer

* Monday, 2023-12-04, 5:00--6:30, HSSC S1325, _GrinTech Open Source Workshop_
* Monday, 2023-12-04, 6:30--??, Bucksbaum, _Vocal Recitals_
* Tuesday, 2023-12-05, 7:00--??, Bucksbaum, _Percussion Ensemble_

Wellness

* Monday, 2023-12-04, 4:00--5:00pm, HSSC North Atrium, _Therapy Dogs_.

Misc

* Monday, 2023-12-04, noon--1pm, JRC 101, _Registration Feedback_

### Other good things (no tokens)

### Upcoming work

* Reading for Wednesday: Wikipedia on Dijkstra's shortest path algorithm.
* Attendance is expected on Friday.
* MP redos: As you can do them.  Last possible moment is 5pm on Dec 15th.
* LAs: As you can do them. Last possible moment is 5pm on Dec 15th.

### About LAs

Each one looks like the following.

> **Title**

> _Explanation_

> Please provide evidence that you have mastered this learning objective.  Your evidence will often consist of a combination of program code and narrative text to explain the code and its relationship to the objective.

> |______|

> Please include citations, as appropriate.

> |______|

> [ ] I certify that the answers above represent my own work, except as indicated in the citations.

I'm going to try to look at a few each day.

### About MP updates

Each one looks like the following.

> Please enter the GitHub repo of the latest version of your code.

> |______|

> What are the primary flaws in your mini-project?

> |______|

> What grade do you expect you would have been able to achieve had you received more timely feedback on this mini-project?

> * [ ] Incomplete
> * [ ] Redo
> * [ ] Meets Expectations
> * [ ] Exemplary

> Please explain why.

> |______|

Questions
---------

### Graphs

### Administrative

What should citations look like in the LAs?

> Similar to MPs, almost anything that acknowledges help/partnership.

> E.g., "I worked on this lab with X."  "Pom and Micah helped me."

Where should the code we use come from?

> I would prefer that it comes from MPs, since that's primarily your code.
  But if you think a lab provides a better exemplar, use that.

How quickly will we get feedback on LAs?

> I'm hoping that this feedback is quicker.

What about MPs?

> Less hopeful, which is why we have the new alternate approach.  I still
  need to write rubrics and "grade helper code".

For MPs in which there is no rubric, what should we do?

> Wait a few days. A rubric will appear. You can then use that rubric
  on yourself.

Do we just copy and paste for the LAs?

> Yes.  I'd prefer everything in one place so that I can see.

What happens if I don't check the "This is my code (except as mentioned
in the citations)" button?

> We have a chat.

What are the MP updates?

> They are a solution to the problem of "you didn't get timely grades".

> If, for example, you got an M on MP4 but you didn't get the grade until
  yesterday, and you are confident that you could have fixed the issue,
  you would select "E" on the update and write a short note about it.

Are you worried about known gender stereotypes and self-assessment?

> I assume Grinnellians know enough about the issue that it will at least
  be partially addressed.

Aren't you worried that everyone will just say that they'd get all E's?

> 'eh

What if I FAILED TO FOLLOW INSTRUCTIONS and did not put my partner's name
on the top of the code from a lab?

> "I worked with one of the awesome but anonymous members of this class
  on the lab."

What if I FAILED TO ENSURE THAT MY PARTNER GAVE ME LAB CODE?

> Too bad, so sad. I guess you have to redo it yourself. It's a good
  lesson for the future.

Can I also turn in real redos?

> Certainly. But please take care of your mental and emotional wellbeing.

What happens if I turn in a redo and do not turn in an update?

> You will get the highest grade of originals + redos?

Do you recommend that I turn in the update just in case?

> Definitely.

> You might want to write something like "I reviewed the rubric and believe
  that I meet all of the criteria."

Are you going to look at style in grading these?

> Yup. Four space indent -> FAIL!

> Probably not close to that extreme.

Can we submit non-working code for MP redos and still say we'd make an E?

> If you *think you could* fix it with good feedback, help from Sam or 
  mentors or evening tutors, in a reasonable amount of time, then you
  can choose an E.

How will you compute our grade?

> See the course home page. No tokens counted (so no marks off for late
  submissions or missed classes). No assessments/labs counted.
  It was a bad semester for me and your grade shouldn't suffer for that.

Pre-Lab
-------

_A bit of TPS time._

What is a spanning tree?

> A tree that spans (connects) all the vertices

What is a minimum spanning tree (informally or formally)?

> A spanning tree whose total weight is no more than all other
  spanning trees.

To which "city management problem" do MSTs most closely correspond?

> Building roads to connect houses in a city.

> What roads to plow to ensure everyone can get out of their house.

What is Prim's algorithm?

> Pick an arbitrary point

> Find the closest neighboring point that is not in the tree (the shortest 
  edge from the tree to outside the tree)

> Keep doing those previous two until we've added all the points (or
  failed to do so because there is no MST)

Alternately ...

> Pick an arbitrary vertex.  

> Mark it.  

> Add all of its outgoing edges to a priority queue based on weight

> While the queue is not empty

> > Grab the next edge. 

> > If it leads to an unmarked vertex

> > > Mark it

> > > Add all of its outgoing edges to the priority queue

How do we know Prim's algorithm is correct?

> It clearly builds a tree.

> If we're always choosing the smallest edge, it seems like we should
  be building a minimum tree.

> In 301, we'll do a beautiful proof by contradiction + construction

What is the running time?

> O(m*costofaddingtoprioqueue)

What is Kruskal's algorithm?

> Pick the smallest remaining edge

> If it does not create a cycle

> > Add it to our structure

How do the two algorithms differ?

> Which set of edges we choose among.

> What criteria we use to add an edge.

How do we know Kruskal's algorithm is correct?

How can we quickly determine if two vertices are in the same connected subgraph? (Alt: Is there a cycle?)

> Issue: You can't just check whether both vertices are marked because they
  may be in separate trees.

> Issue: You can't just name the tree a vertex is in when you add it because
  sometimes your new edge connects to trees.

> Option one: Explore all the other vertices.  That's an O(n) operation.
  So our overall algorithm is O(mn + m*costofprioqueue).

> Option two: Wait until 301

_One of these questions is not like the others._

Lab
---

Implement Prim's.

Please plan to return to the same lab group to finish Prim's next class.

How should you implement priority queues? 

> `java.util.PriorityQueue`.

How should you keep track of what edges are in the MST? 

> `ArrayList<Edge>`

How do we represent undirected graphs with directed graphs?

> Use edges in both directions with the same weight.

Where does our method go?

> Option 1: In the Graph class

> Option 2: In a separate class

What does it take as input?

> Option 1: A graph

> Option 2: A file that describes a graph.

> Option 3: An ArrayList that describes a graph.



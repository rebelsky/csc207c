---
title: Object composition
summary: |
  We consider a bit about object composition, one of the core techniques
  of object-oriented design, and reflect on some design patterns related
  to composition.
prereqs: |
  Class basics.  
  [Subtype polymorphism](../readings/subtype-polymorphism).
  [Interfaces](../readings/interfaces).
  [Inheritance](../readings/inheritance).
---
As you've recently learned, inheritance is a programming strategy that embodies the _is-a_ relationship. If class `A` _is-a_ `B`, then we might make class `A` extend (inherit from) from class `B`. Of course, we've also seen _is-a_ relationships with interfaces. If class `A` _is-a_ `B`, then we might make `A` implement interface `B`. Making the right choice involves some careful consideration, as well as some experience.

Certainly, inheritance is not the only possible relationship between classes. As you've already seen, classes may have fields whose values are objects in other classes. For example, our `BigFraction` objects have fields that hold `BigInteger` objects. In this case, we say that there is a _has-a_ relationship between objects (e.g., a `BigFraction` object _has-a_ `BigInteger` for its numerator and another `BigInteger` for its denominator. We use the term _Composition_ for a case in which one object/class has a _has-a_ relationship with other objects/classes.

Composition seems straightforward enough, doesn't it? It's hard to envision writing classes without having some fields that hold objects. It makes you wonder why anyone would call out composition as a special feature.

However, once you start designing complex object-oriented programs, you will find yourself considering whether to use inheritance or composition for different parts of your program. Let's turn to Sandi Metz (or at least her [_Practical Object-Oriented Design in Ruby_](https://www.poodr.com)) to learn a bit more about design issues.

> Remember that classical inheritance is a code arrangement technique. Behavior is dispersed among objects and these objects are organized into class relationships such that automatic delegation of messages invokes the correct behavior. Think of it this way: For the cost of arranging objects in a hierarchy, you get message delegation for free.
 
> Composition is an alternative that reverses these costs and benefits. In composition, the relationship between objects is not codified in the class hierarchy; instead objects stand alone and as a result must explicitly know about and delegate messages to one another. Composition allows objects to have structural independence, but at the cost of explicit message delegation.

What does she mean by "explicit message delegation"? We've seen that with inheritance, if `A` inherits from `B`, we call a method on an object of type `A`, and `A` doesn't override that method, then our object automatically executes `B`'s method of the same name. That is, we have implicitly delegated the message call to another class.

In code ...

```java
public class B {
  public int foo() {
    return ...;
  } // foo()
} // class B

public class A extends B {
} // class A

  A a = new A();
  System.err.println(a.foo());      // This calls the `foo` method in `B`
```

In contrast, let's assume we didn't have inheritance. What would we do to achieve similar behavior "by hand". Probably something like the following.

```java
public interface Foo {
  public int foo();
} // interface Foo

public class B implements Foo {
  public int foo() {
    return ...;
  } // foo()
} // class B

public class A implements Foo {
  B b;

  public int foo() {
    return b.foo();
  } // int foo()
} // class A

  A a = new A();
  System.err.println(a.foo());
```

Once again, a call to `a.foo()` results in the computation in `B.foo()`. However, this time, we've had to explicitly describe the connection, rather than implicitly. That is, we've "explicitly delegated the message call".

Given that added complexity, why would we want to use composition rather than inheritance?  Let's consider a situation where inheritance breaks down and composition seems to be an appropriate solution. In fact, it's a situation we've already seen.

Suppose we are modeling a small college. We'll call it "SmileCo". While it's not relevant to this example, SmileCo's motto is "Where the liberal arts make you happy." Or something like that.

There are many people at SmileCo. And the people fulfil different roles. For example, some people are students, some people are faculty, and some people are staff members. Those observations might encourage us to design an inheritance hierarchy something like the following.

```
/**
 * People at SmileCo.
 */
public class SmilePerson {
  // ...
} // class SmilePerson

/**
 * Students at SmileCo.
 */
public class SmileStudent extends SmilePerson {
  /** The courses a student has taken. */
  ArrayList<Course> courses = new ArrayList<Course>();

  /**
   * Enroll in a course.
   */
  public void enroll(Course course) throws Exception {
    if (!(this.hasPrerequisites(course) || this.hasPermission(course))) {
      throw new PrerequisiteException();
    } // if no prereqs
    if (this.hasTaken(course)) {
      throw new DuplicateCourseException();
    } // if taken already
    // We've gotten this far, enroll!
    this.courses.add(course);
  } // enroll(Course)

  /**
   * Generate a transcript. 
   *
   * @param fileName
   *   The name of the file in which the transcript should be stored.
   * @throws Exception if the file cannot be opened.
   */
  public void generateTranscript(String fileName) throws Exception {
    PrintWriter pen = new PrintWriter(new File(fileName));
    pen.println("Unofficial SmileCo Transcript");
    pen.println("Student: " + this.name());
    for (Course c : this.courses) {
      pen.println(c);
    } // for
    pen.close();
  } // generateTranscript(String)

  // ...
} // class SmileStudent

/**
 * Teachers at SmileCo
 */
public class SmileTeacher extends SmilePerson {
  /** The courses a faculty member has taught or is teaching. */
  ArrayList<Course> courses = new ArrayList<Course>();

  /**
   * Assign a faculty member to teach a course.
   */
  public void assignCourse(Course course) throws Exception {
    if (this.overlappingTime(course)) {
      throw new ScheduleException("overlapping times");
    }
    this.courses.add(course);
  } // assignCourse(Course)

  // ...
} // SmileTeacher
```

Wasn't that exciting? It should even seem familiar, since we did something similar in [the reading on inheritance](../readings/inheritance).

It also has some problems. For example, what happens if someone is _both_ a student and a teacher? (Yes, teachers can take classes. At some institutions, students can also teach classes.) We can't declare a class like `SmileStudentTeacher` that extends both `SmileStudent` and `SmileTeacher`, even though such a person _is-a_ faculty member and _is-a_ student. Remember! Java only lets you extend one class. And perhaps that's good! We have two fields called `courses`, one for the courses someone has taken and one for the courses someone has taught. How would we keep them straight if we could extend both?

What do we do instead? That's right, we use composition. A `SmileStudent` has characteristics of a `SmilePerson` and characteristics of a `Student`. (And yes, I'd like to say that a `SmileStudent` _is_ a `SmilePerson` and a `Student`. As I said, the model breaks down.) Here's one approach.

```
public interface Person {
  /**
   * Get the person's name.
   */
  public Name name();

  // ...
} // interface Person

public class SmilePerson implements Person {
  // ...
} // class SmilePerson

public interface StudentInfo {
  /**
   * Enroll in a course.
   */
  public void enroll(Course c) throws Exception;

  /**
   * Generate a transcript. 
   *
   * @param fileName
   *  The file in which the transcript should be stored.
   * @throws Exception
   *  If the file is not available.
   */
  public void generateTranscript(String fileName);
} // interface StudentInfo

public class SmileStudentInfo implements StudentInfo {
  /** The courses a student has taken. */
  ArrayList<Course> courses = new ArrayList<Course>();

  /**
   * Enroll in a course.
   */
  public void enroll(Course course) throws Exception {
    // ...
  } // enroll(Course)

  /**
   * Generate a transcript. 
   *
   * @param name
   *   The name of the student.
   * @param fileName
   *   The name of the file in which the transcript should be stored.
   * @throws Exception if the file cannot be opened.
   */
  void generateTranscript(String name, String fileName) throws Exception {
    PrintWriter pen = new PrintWriter(new File(fileName));
    pen.println("Unofficial SmileCo Transcript");
    pen.println("Student: " + name);
    for (Course c : this.courses) {
      pen.println(c);
    } // for
    pen.close();
  } // generateTranscript(String,String)

  public void generateTranscript(String fileName)  throws Exception {
    generateTranscript("<ANONYMOUS>", fileName);
  } // generateTranscript(String)

  // ...
} // class SmileStudentInfo

/**
 * Students at SmileCo.
 */
public class SmileStudent extends SmilePerson implements StudentInfo {
  StudentInfo sinfo = new SmileStudentInfo();

  public void enroll(Course course) throws Exception {
    sinfo.enroll(course);
  } // enroll(Course)

  public void generateTranscript(String fileName) throws Exception {
    sinfo.generateTranscript(this.name(), fileName);
  } // generateTranscript(String fileName)
} // class SmileStudent

/**
 * Student-teachers at SmileCo
 */
public class SmileStudentTeacher extends SmilePerson implements StudentInfo
    implements TeacherInfo {
  
  StudentInfo sinfo = new SmileStudentInfo();
  TeacherInfo tinfo = new SmileTeacherInfo();

  public void enroll(Course course) throws Exception {
    sinfo.enroll(course);
  } // enroll(Course)

  public void assignCourse(Course course) throws Exception {
    tinfo.enroll(course);
  } // assignCourse(Cousre)

  // ...
} //  class SmileStudentTeacher
```

As you may have noted, our `SmileStudent` implicitly delegates some method calls to `Person` (e.g., the call to `this.name()`( and explicitly delegates other method calls to `SmileStudentInfo` (e.g., a call to `generateTranscript`). And we can have student-teachers, who provide both `StudentInfo` methods and `TeacherInfo` methods, but through explicit delgation. We've handled the problem.

More generally, when faced with an object design problem, how do you find the best approach? That is, how do you decide when to use inheritance and when to use composition (and explicit delegation)? The normal suggestion is to use inheritance for _is-a_ relationships and composition for _has-a_ relationships. And that often works. But as we've seen, it also breaks down. Unfortunately, there isn't a hard and fast formula that works every time. The more experience you have, the better you'll get at deciding whether to use inheritance, implementation, or composition. While you're learning, you should always be prepared to redesign your code when you encounter a stumbling block, such as our student-teachers.

References
----------

Metz, Sandi. 2013. _Practical Object-Oriented Design in Ruby_. Upper Saddle River, NJ: Addison-Wesley. p. 184.

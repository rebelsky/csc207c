import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

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
   */
  public void generateTranscript(String fileName) throws Exception {
    PrintWriter pen = new PrintWriter(new File(fileName));
    pen.println("Unofficial SmileCo Transcript");
    pen.println("Student: " + this.name);
    for (Course c : this.courses) {
      pen.println(c);
    } // for
    pen.close();
  } // generateTranscript(String)

  // ...

  boolean hasTaken(Course c) {
    return false;       // STUB
  }

  boolean hasPrerequisites(Course c) {
    return true;        // STUB
  }

  boolean hasPermission(Course c) {
    return true;        // STUB
  }
} // class SmileStudent


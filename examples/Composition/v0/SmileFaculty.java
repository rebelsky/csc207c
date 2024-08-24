import java.util.ArrayList;

/**
 * Faculty at SmileCo
 */
public class SmileFaculty extends SmilePerson {
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

  /**
   * Determine if a course overlaps times with other courses.
   */
  boolean overlappingTime(Course course) {
    return false;       // STUB
  }
} // SmileFaculty


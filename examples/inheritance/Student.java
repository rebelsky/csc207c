/**
 * A simple representation of students for exploring inheritance.
 */
public class Student extends Person {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * How much debt does this student have?
   */
  int debt;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new student.
   */
  public Student(String given, String family, int age, Gender gender) {
    super(given, family, age, gender);
    this.debt = 0;
  } // Student(String, String, int, Gender, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  // +----------------+----------------------------------------------
  // | Person Methods |
  // +----------------+

  @Override
  public String answer(String question) {
    return "Um ... I'm not sure ...";
  } // answer(String)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  @Override
  public String toString() {
    return "Scholar " + given;
  } // toString()
} // class Student

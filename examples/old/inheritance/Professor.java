/**
 * A simple representation of Professors for exploring inheritance.
 */
public class Professor extends Person {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * What year was this person hired?
   */
  int yearHired;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new professor.
   */
  public Professor(String given, String family, int age, Gender gender, int yearHired) {
    super(given, family, age, gender);
    this.yearHired = yearHired;
  } // Professor(String, String, int, Gender, int)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  // +----------------+----------------------------------------------
  // | Person Methods |
  // +----------------+

  @Override
  public String answer(String question) {
    return "The solution is obvious if you simply consider the Church-Rosser theorem.";
  } // answer(String)

  // +------------------+--------------------------------------------
  // | Standard Methods |
  // +------------------+

  public String toString() {
    return "Professor " + family;
  } // toString()
} // class Professor

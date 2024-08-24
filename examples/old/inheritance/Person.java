public class Person {
 
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * Their given name.
   */
  String given;

  /**
   * Their family name.
   */
  String family;

  /**
   * The age of the person, in months.
   */
  int age;

  /**
   * The gender of the person.
   */
  Gender gender;
 
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new person.
   */
  public Person(String given, String family, int age, Gender gender) {
    this.given = given;
    this.family =  family;
    this.age = age;
    this.gender = gender;
  } // Person(String, String, int, Gender)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public int getAge() {
    return this.age;
  } // getAge()
 
  public String answer(String question) { 
    return "Maybe.";
  } // answer(String)
 
  public void askQuestionOf(Person other) {
    other.answer("What is the meaning of life?");
  } // askQuestionOf(Person)

  // +------------------+--------------------------------------------
  // | Standard methods |
  // +------------------+

  public String toString() {
    return this.given+ " " + this.family;
  } // toString()

} // class Person


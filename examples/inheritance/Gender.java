/**
 * A relatively primitive representation of genders.
 */
public class Gender {
  // +-----------+---------------------------------------------------
  // | Constants |
  // +-----------+

  public static final Gender MALE = new Gender("Male");
  public static final Gender FEMALE = new Gender("Female");
  public static final Gender NON_BINARY = new Gender("Non-binary");

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * A string that describes the gender.
   */
  String gender;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new gender object. (Not available to the public.)
   */
  private Gender(String gender) {
    this.gender = gender;
  } // Gender(String)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Convert to a string (e.g., for printing).
   */
  public String toString() {
    return this.gender;
  } // toString

} // class Gender

import java.io.PrintWriter;

/**
 * A simple example of using our people classes.
 */
public class Example {
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    Person river = new Person("River", "Jones", 240, Gender.NON_BINARY);
    Person samr = new Professor("Samuel", "R", 716, Gender.MALE, 1997);
    Person stu = new Student("Stu", "Dent", 243, Gender.NON_BINARY);
    
    pen.println(river + " says \"" + river.answer("Why?") + "\"");
    pen.println(samr + " says \"" + samr.answer("Why?") + "\"");
    pen.println(stu + " says \"" + stu.answer("Why?") + "\"");

    pen.close();
  } // main(String[])
} // class Example

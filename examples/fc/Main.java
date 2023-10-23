public class Main {

public static void main(String[] args) {
  BetterFraction f1 = new BetterFraction();
  BetterFraction f2 = new BetterFraction();
  FractionComparator fc = new FractionComparator();
  if (fc.compare(f1,f2) == 0) {
    System.err.println("f1 and f2 are the same");
  }
}

} // class Main

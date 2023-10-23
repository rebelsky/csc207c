import java.util.Comparator;
import java.math.BigInteger;

public class FractionComparator implements Comparator<Fraction> {
  public int compare(Fraction f1, Fraction f2) {
    BigInteger tmp1 = f1.numerator().multiply(f2.denominator());
    BigInteger tmp2 = f2.numerator().multiply(f1.denominator());
    return tmp1.compareTo(tmp2);
  } // compare
} // FractionComparator


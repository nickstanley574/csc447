import java.math.BigInteger;


// The following Java program defines an immutable Pair class 
// (with type parameters X and Y). Complete the definition of 
// fibaux in the following Java program, which uses the immutable 
// Pair class. You may need to refer to the Java documentation 
// for use of Java's BigInteger class.

class Pair<X,Y> {
  final X x;
  final Y y;
  Pair (X x, Y y) {
    this.x = x;
    this.y = y;
  }
}   

public class Fib1 {
  static Pair<BigInteger,BigInteger> fibaux (BigInteger n) {
      if (n.compareTo(BigInteger.ZERO) <= 0) {
          return new Pair<> (BigInteger.ZERO, BigInteger.ONE);
      } else if (n.equals (BigInteger.ONE)) {
          return new Pair<> (BigInteger.ONE, BigInteger.ONE); 
      } else {
          Pair<BigInteger, BigInteger> p = fibaux (n.subtract(BigInteger.ONE));
          return new Pair<> (p.y,p.x.add(p.y));

      }
  }

  static BigInteger fib (BigInteger n) {
    return fibaux (n).x;
  }

  public static void main (String[] args) {
    for (int i = 0; i < 71; i++) {
      System.out.println (fib (BigInteger.valueOf (i)));
    }
  }
}
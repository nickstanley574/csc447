// If the final modifier is removed from the 
// fields of Pair, the caller to fibaux can pass 
// in (a reference to) a Pair instance, and the fields 
// of that instance can be updated with the results. 
// Complete the definition of fibaux in the following 
// Java program.

import java.math.BigInteger;

class Pair<X,Y> {
  X x;
  Y y;
  Pair (X x, Y y) {
    this.x = x;
    this.y = y;
  }
}   

public class Fib2 {
    static void fibaux (BigInteger n, Pair<BigInteger,BigInteger> result) {
    if (n.compareTo (BigInteger.ZERO) <= 0) {
        result.x = BigInteger.ZERO;
        result.y = BigInteger.ONE;
    }  else if (n.equals (BigInteger.ONE)) {
      result.x = BigInteger.ONE;
      result.y = BigInteger.ONE;
    }  else { 
        fibaux(n.subtract(BigIntger.One), result);
        BigInteger x = result.x;
        BigInteger y = result.y;
        result.x = y;
        result.y = x.add(y);
    }
  }

    static BigInteger fib (BigInteger n) {
        Pair<BigInteger, BigInteger> p = new Pair<> (BigInteger.ZERO, BigInteger.ZERO);
        fibaux (n, p);
        return p.x;
    }

    public static void main (String[] args) {
        for (int i = 0; i < 71; i++) {
            System.out.println (fib (BigInteger.valueOf (i)));
        }
    }
}
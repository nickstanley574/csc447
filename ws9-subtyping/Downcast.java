// 3.3 Downcasting
// Something is wrong with the method convert in the following 
// Java program. Does it fail at compile time or at runtime?

// Verify your answer by compiling and (perhaps) running the program.

// fails at runtime
// Main
// Exception in thread "main" java.lang.ClassCastException: Downcast$A cannot be cast to Downcast$B
// at Downcast.convert(Downcast.java:6)
// Downcast.java:6
// at Downcast.main(Downcast.java:14)

public class Downcast {
    static class A           { int x; }
    static class B extends A { int y; }
  
    static B convert (A p) {
        B result = (B) p;
        return result;
    }
  
    public static void main (String[] args) {
        System.out.println ("Main");
        A r = new A ();
        r.x = 5;
        B s = convert (r);
        System.out.println (s);
    }
  }
  

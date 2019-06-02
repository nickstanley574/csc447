class A {
    int f (int x) {
      System.out.format ("A.f (%d)%n", x);
      if (x == 0) {
        return g ();
      } else {
        return f (x - 1);
      }
    }
  
    int g () {
      System.out.println ("A.g ()");
      return 0;
    }
  }
  
  class B {
    A a = new A ();
  
    int f (int x) {
      System.out.format ("B.f (%d)%n", x);
      return a.f (x);
    }
  
    int g () {
      System.out.println ("B.g ()");
      return 0;
    }
  }
  
  public class Inheritance05 {
    public static void main (String[] args) {
      new B ().f (3);
    }
  }

/*
  B.f (3)
  A.f (3)
  A.f (2)
  A.f (1)
  A.f (0)
  A.g ()
*/
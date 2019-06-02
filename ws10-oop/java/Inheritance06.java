interface I {
    int f (int x);
    int g ();
  }
  
  class A implements I {
    I back = this;
  
    public int f (int x) {
      System.out.format ("A.f (%d)%n", x);
      if (x == 0) {
        return back.g ();
      } else {
        return back.f (x - 1);
      }
    }
  
    public int g () {
      System.out.println ("A.g ()");
      return 0;
    }
  }
  
  class B implements I {
    A a;
  
    B () {
      a = new A ();
      a.back = this;
    }
  
    public int f (int x) {
      System.out.format ("B.f (%d)%n", x);
      return a.f (x);
    }
  
    public int g () {
      System.out.println ("B.g ()");
      return 0;
    }
  }
  
  public class Inheritance06 {
    public static void main (String[] args) {
      new B ().f (3);
    }
  }
  /*
  
B.f (3)
A.f (3)
B.f (2)
A.f (2)
B.f (1)
A.f (1)
B.f (0)
A.f (0)
B.g ()

*/
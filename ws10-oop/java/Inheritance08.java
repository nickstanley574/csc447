class A {
    int f (int x) {
      System.out.format ("A.f (%d)%n", x);
      return (x == 0) ? g () : f (x - 1); 
    }
  
    int g () {
      System.out.println ("A.g ()"); 
      return 0;
    }
  
    void h () {
      System.out.println ("A.h ()"); 
    }
  }
  
  
  class B extends A {
    int f (int x) {
      System.out.format ("B.f (%d)%n", x);
      return super.f (x);
    }
  
    int g () { 
      System.out.println ("B.g ()"); 
      A r = this;
      r.h ();
      return 0;
    }
  
    void h () {
      System.out.println ("B.h ()"); 
      super.h ();
    }
  }
  
  
  public class Inheritance08 {
    public static void main (String[] args) {
      System.out.println ("Inheritance08"); 
      A x = new B (); 
      x.f (3);
    }
  }

  /*
Inheritance08
B.f (3)
A.f (3)
B.f (2)
A.f (2)
B.f (1)
A.f (1)
B.f (0)
A.f (0)
B.g ()
B.h ()
A.h ()

  */
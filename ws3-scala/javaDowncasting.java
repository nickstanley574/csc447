// 3.5 Java Downcasting Does the Java compiler javac type checker allow
// downcasting, e.g.,allowing a reference of type A to be used as a reference
// of type B (given the class declarations below)?

class javaDowncasting {

  class A { int x;}

  class B extends A { int y; }

  void f(A p) {
  B q = (B) p;
  }

  public static void main(String[] args) {}
}

/* 

nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws3-scala$ javap -c javaDowncasting
Compiled from "javaDowncasting.java"
class javaDowncasting {
  javaDowncasting();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: return

  void f(javaDowncasting$A);
    Code:
       0: aload_1
       1: checkcast     #2                  // class javaDowncasting$B
       4: astore_2
       5: return

  public static void main(java.lang.String[]);
    Code:
       0: return
}

Note: the code for method g does show a dynamic check this time!

The checkcast instruction is the one that dynamically checks whether the argument is an instance of B or not. It is generated by the compiler when we use the cast (B).
*/
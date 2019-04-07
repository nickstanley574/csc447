// 3.3 Java Upcasting Does the Java compiler javac type checker allow upcasting,
// e.g., allowing a reference of type B to be used as a reference of type A
// (given the class declarations below)?

class javaUpcasting {

    class A {
        int x;
    }

    class B extends A {
        int y;
    }

    void f(B p) {
        A q = p;
    }

    public static void main(String[] args) {

    }

}

// 3.4 Java Upcasting Disassembly Look at the Java Virtual Machine (JVM)
// bytecode for your program from the previous upcasting subsection.

// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws3-scala$ javap -c
// javaUpcasting
// Compiled from "javaUpcasting.java"
// class javaUpcasting {
// javaUpcasting();
// Code:
// 0: aload_0
// 1: invokespecial #1 // Method java/lang/Object."<init>":()V
// 4: return

// void f(javaUpcasting$B);
// Code:
// 0: aload_1
// 1: astore_2
// 2: return

// public static void main(java.lang.String[]);
// Code:
// 0: return
// }

// the code for method f does not show any dynamic checks (aload and astore are
// like the mov instructions in Intel assembly language).

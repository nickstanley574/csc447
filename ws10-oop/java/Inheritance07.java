abstract class A {
    int f (int x) {
        System.out.format("A.f (%d)%n", x);
        return (x == 0) ? g() : f(x - 1);
    }

    abstract int g();

    void h () {
        System.out.println("A.h ()");
    }
}

class B extends A { 
    int g() {
        System.out.println("B.g()");
        A r = this;
        r.h();
        return 0;
    }

    void h () { 
        System.out.println("B.h ()");
        super.h();
    }
}

public class Inheritance07 {
    public static void main(String[] args) {
        A x = new B();
        x.f(3);
    }
}

/*

A.f (3)
A.f (2)
A.f (1)
A.f (0)
B.g()
B.h ()
A.h ()
*/
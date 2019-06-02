interface I {
    void f();
}

class A implements I {
    public void f() {
        System.out.println("A");
    }
}

class B extends A {
    public void f() {
        System.out.println("B");
    }
}

public class Dispatch1 {
        
    public static void main(String[] args) {
        I[] arr1 = new I[] { new A(), new B()};
        A[] arr2 = new A[] { new A(), new B()};
        A[] arr3 = new B[] { new B(), new B()};

        System.out.println("arr1");
        for (int n = 0; n < arr1.length; n++) {
            arr1[n].f (); // print "A", "B"
            arr1[n] = new A ();
          }

        System.out.println("arr2");
        for (int n = 0; n < arr2.length; n++) {
            arr2[n].f (); // print "A", "B"
            arr2[n] = new A ();
        }

        System.out.println("arr3");
        for (int n = 0; n < arr3.length; n++) {
            arr3[n].f (); 
            arr3[n] = new A ();
          }
      

    }


}

/*
arr1
A
B
arr2
A
B
arr3
B
Exception in thread "main" java.lang.ArrayStoreException: A
    at Dispatch1.main(Dispatch1.java:39)
*/
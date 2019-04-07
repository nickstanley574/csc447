
class javaTypeCheaking {

    // 3.1 Java Type Checking 1 Does the Java compiler javac type checker allow
    // assigning an int variable to a char variable?
    public static void typechecking1() {
        System.out.println("typechecking1");

        // char c1 = 2;
        // System.out.println(c1);

        // typechecking1
        // 

        // int i1 = 1;
        // char c2 = (int) i1;
        // System.out.println(c2);

        // Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        // Type mismatch: cannot convert from int to char
        // at javaTypeCheaking.typechecking1(javaTypeChecking.java:15)
        // at javaTypeCheaking.main(javaTypeChecking.java:31)

        // int i2 = 5;
        // char c3 = i2;
        // System.out.println(i2);
        // System.out.println(c3);

        // Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        // Type mismatch: cannot convert from int to char
        // at javaTypeCheaking.typechecking1(javaTypeChecking.java:23)
        // at javaTypeCheaking.main(javaTypeChecking.java:30)

    }

    // 3.2 Java Type Checking 2 Does the Java compiler javac type checker allow
    // assigning an int variable to a String variable?
    public static void typechecking2() {
        System.out.println("typechecking2");
        String s1 = 1;
        System.out.println(s1);
        // Exception in thread "main" java.lang.Error: Unresolved compilation problem:
        // Type mismatch: cannot convert from int to String
        // at javaTypeCheaking.typechecking2(javaTypeChecking.java:41)
        // at javaTypeCheaking.main(javaTypeChecking.java:48)
    }

    public static void main(String[] args) {
        // typechecking1();
        typechecking2();
    }

}
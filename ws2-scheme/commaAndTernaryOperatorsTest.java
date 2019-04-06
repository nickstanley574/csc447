
/*
 * 2.1 Statements vs Expressions in Java
 * 
 * Java's syntax borrows heavily from C, but does it support the comma and
 * ternary operators?
 * 
 * Write your own simple Java program(s) to determine whether Java supports the
 * comma and ternary operators.
 * 
 * The conditional operator (? and :) is a special operator which requires three
 * operands. Its syntax is as follows:
 * 
 * Syntax: expression1 ? expression2 : expression3
 */

class commaAndTernaryOperatorsTest {
    public static void main(String[] args) {
        int a = 5, b = 13; // comma operator Supported in declarations
        int max = a > b ? a : b; // ternary operator
        System.out.println(max);

        int x = 1;
        // int r = (x += 2, 1); // Syntax error on token ",", invalid
        // AssignmentOperatorJava(1610612971)
        // System.out.println(r);

    }

}

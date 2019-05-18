class CBV {


    // 1 CBV in Java - Int
    //Confirm that Java uses call-by-value to pass int variables by
    // writing a simple Java program then running it.
    private static void swapInt(int x, int y) {
        System.out.format ("--> swapInt(x=%d, y=%d)\n", x, y);
        int oldX = x;
        int oldY = y;
        x = oldY;
        y = oldX;
        System.out.format ("-->         x=%d, y=%d\n", x, y);
    }


    // 2 CBV in Java - Reference
    // Confirm that Java uses call-by-value to pass reference variables 
    // (meaning references to instances on the heap) by writing a simple 
    // Java program then running it.
    private static void swapRef(Integer x, Integer y) {
        System.out.format ("--> swapRef(x=%d, y=%d)\n", x, y);
        Integer oldX = x;
        Integer oldY = y;
        x = oldY;
        y = oldX;
        System.out.format ("-->         x=%d, y=%d\n", x, y);

    }

    public static void main(String args[]) {
        System.out.format ("main()\n");
        // 1 
        {
            System.out.format ("-- 1 --\n");
            int a = 0;
            int b = 1;
            System.out.format ("a=%d, b=%d\n", a, b);
            swapInt (a, b);
            System.out.format ("a=%d, b=%d\n", a, b);
        }
        // 2 
        {
            System.out.format ("-- 2 --\n");
            Integer a = 0;
            Integer b = 1;
            System.out.format ("a=%d, b=%d\n", a, b);
            swapRef (a, b);
            System.out.format ("a=%d, b=%d\n", a, b);
        }
    }
}
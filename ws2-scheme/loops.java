public class Linear {

    static int sumWhile(int[] data) {
        int result = 0;
        int i = 0;
        while (i < data.length) {
            result += data[i];
            i++;
        }
        return result;
    }

    static int sumFor(int[] data) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            result += data[i];
        }
        return result;
    }

    static int sumIterator(int[] data) {
        int result = 0;
        for (int x : data) {
            result += x;
        }
        return result;
    }

    static int sumRecursive(int[] data) {
        return sumRecursiveAux(data, 0);
    }

    static int sumRecursiveAux(int[] data, int i) {
        if (i == data.length) {
            return 0;
        } else {
            return data[i] + sumRecursiveAux(data, i + 1);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            data[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("sumWhile     = %d%n", sumWhile(data));
        System.out.printf("sumFor       = %d%n", sumFor(data));
        System.out.printf("sumIterator  = %d%n", sumIterator(data));
        System.out.printf("sumRecursive = %d%n", sumRecursive(data));
    }
}
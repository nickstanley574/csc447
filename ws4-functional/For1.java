public class For1 {
    public static void main (String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}

// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For1 the rain in spain
// the
// rain
// in
// spain
// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For1 trains planes ships
// trains
// planes
// ships
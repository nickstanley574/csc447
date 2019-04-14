public class For2 {
    public static void main (String[] args){
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            System.out.println(arg);
        }
    }
}

// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For2 trains planes ships
// trains
// planes
// ships
// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For2 the rain in spain
// the
// rain
// in
// spain
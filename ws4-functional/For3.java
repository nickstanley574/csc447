public class For3 {
    public static void main (String[] args) {
      for (String arg : args) {
        System.out.println (arg);
      }
    }
  }

// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For3 the rain in spain
// the
// rain
// in
// spain
// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws4-functional$ java For3 trains planes ships
// trains
// planes
// ships
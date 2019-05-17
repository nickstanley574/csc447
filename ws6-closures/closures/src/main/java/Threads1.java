import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Threads1 {
    public static void main (String[] args) {
      try {
        String[] messages = new String[] { "the", "rain", "in", "Spain", "falls", "mainly", "on", "the", "plain" };
        BlockingQueue<Runnable> q = new LinkedBlockingQueue<> ();
        Sender sender = new Sender (messages, q);
        new Thread (sender).start ();
        while (true) {
          q.take ().run ();
        }
      } catch (InterruptedException e) {
        // ignore interruptions
      }
    }
  }
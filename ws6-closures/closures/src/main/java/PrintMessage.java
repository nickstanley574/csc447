import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class PrintMessage implements Runnable {
  final String message;

  PrintMessage (String message) {
    this.message = message;
  }

  public void run () {
    System.out.println (message);
  }
}

class Sender implements Runnable {
  private final String[] messages;
  private final BlockingQueue<Runnable> q;

  Sender (String[] messages, BlockingQueue<Runnable> q) {
    this.messages = messages;
    this.q = q;
  }

  public void run () {
    try {
      System.out.println ("Sender started");
      for (int i = 0; i < messages.length; i++) {
        Thread.sleep (1000);
        q.put (new PrintMessage (messages[i]));
      }
    } catch (InterruptedException e) {
      // ignore interruptions
    }
  }
}

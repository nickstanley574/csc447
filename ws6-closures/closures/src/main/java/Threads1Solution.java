import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Threads1Solution { 
    public static void main (String[] args) {
        try {
            String[] messages = new String[] { "the", "rain", "in", "Spain", "falls", "mainly", "on", "the", "plain" };
            final BlockingQueue<Runnable> q = new LinkedBlockingQueue<> ();
            Runnable sender = new Runnable () {
                public void run () {
                    try {
                        System.out.println ("Sender started");
                        for (int i = 0; i < messages.length; i++) {
                            final String message = messages[i];
                            Thread.sleep (1000);
                            q.put (new Runnable () {
                                public void run () {
                                    System.out.println (message);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        // ignore interruptions
                    }
                }
            }; 
            new Thread (sender).start ();
            while (true) {
                q.take ().run ();
            }
        } catch (InterruptedException e) {
            // ignore interruptions
        }
    }
}

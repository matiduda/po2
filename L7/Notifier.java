import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

import static java.lang.System.out;

public class Notifier implements Runnable {

    private BufferedWriter writer;

    private String notificationMsg;
    private int timeToSend;
    
    public Notifier(Socket s, String notificationMsg, int timeToSend) {
        try {
            this.writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.notificationMsg = notificationMsg;
        this.timeToSend = timeToSend;
    }

    @Override
    public void run() {
        // Wait for timeToSend seconds
        out.printf("Received '%s'\nwaiting for %d seconds...\n", notificationMsg, timeToSend);
        
        try {
            Thread.sleep(timeToSend * 1000);
        } catch (InterruptedException e) {
            // Send error message
            out.printf("An error occured while sending\n'%s'", notificationMsg);
            return;
        }

        try {
            out.printf("Sending '%s'...\n", notificationMsg);
            writer.write(notificationMsg);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return;
    }
}
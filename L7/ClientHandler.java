import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/* This class has to implement the Runnable interface, so it can be run in a thread */

public class ClientHandler implements Runnable {

    private Socket socket; // allows for the client <-> server connection
    private BufferedReader reader;
    private BufferedWriter writer;
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = reader.readLine();
            System.out.println(clientUsername);
        } catch(IOException e) {
            closeEverything(socket, reader, writer);
        }
    }

    private void closeEverything(Socket socket2, BufferedReader reader2, BufferedWriter writer2) {
        try {
            if(reader != null) {
                reader.close();
            }
            if(writer != null) {
                writer.close();
            }
            if(socket != null) {
                socket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void run() {
        String msg;

        while(socket.isConnected()) {
            try {
                msg = reader.readLine();
                System.out.println(msg);
            } catch(IOException e) {
                closeEverything(socket, reader, writer);
                break;
            }
        }

    }


}

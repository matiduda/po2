import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String username;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        } catch (IOException e) {
            closeEverything(socket, reader, writer);
        }
    }

    public void sendMessage() {
        try {
            writer.write(username);
            writer.newLine();
            writer.flush();

            Scanner scanner = new Scanner(System.in);
            while(socket.isConnected()) {
                String msg= scanner.nextLine();
                writer.write(msg);
                writer.newLine();
                writer.flush();
            }

            scanner.close();
        } catch(IOException e) {
            closeEverything(socket, reader, writer);
        }
    }

    public void listenForMsg() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                String msg;
                
                while(socket.isConnected()) {
                    try {
                        msg = reader.readLine();
                        System.out.println(msg);
                    } catch(IOException e) {
                        closeEverything(socket, reader, writer);
                    }
                }
            }
            
        }).start();
    }

    
    public void closeEverything(Socket socket2, BufferedReader reader2, BufferedWriter writer2) {
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

    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, username);
        client.listenForMsg();
        client.sendMessage();

        scanner.close();
    }
}
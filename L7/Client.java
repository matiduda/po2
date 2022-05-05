import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import static java.lang.System.out;

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
                
                out.print("Enter notification text and press enter\n");
                String msg = scanner.nextLine();

                int secInt = 0;
                boolean correctInput = false;
                while(!correctInput) {

                    out.print("Time to send: ");
                    String seconds = scanner.nextLine();
                    
                    try {
                        secInt = Integer.parseInt(seconds);
                    }
                    catch (NumberFormatException ex){
                        out.println("Incorrect input");
                        continue;
                    }
                    correctInput = true;
                    break;
                }

                // Send message
                writer.write(msg);
                writer.newLine();
                writer.flush();

                // Send time
                writer.write(secInt);
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
                        if(msg == null) {
                            break;
                        }

                        out.printf("You received a notification!\n%s\n", msg);
                    } catch(IOException e) {
                        e.printStackTrace();
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
        Socket socket = null;
        boolean tryToConnect = true;
        int tries = 0;
        int maxTries = 5;

        while(tryToConnect) {
            try {
                socket = new Socket("localhost", 1234);
                tryToConnect = false;
            } catch(ConnectException e) {

                if(tries++ == 5) {
                    System.out.println("Server did not respond.");
                    if(socket != null) {
                        socket.close();
                    }
                    scanner.close();
                    return;
                }

                System.out.printf("[%d of %d] Could not connect to server.\nRetrying in 2s...\n", tries, maxTries);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    break;
                }       
            }
        }

        Client client = new Client(socket, username);
        client.listenForMsg();
        client.sendMessage();

        scanner.close();
    }
}
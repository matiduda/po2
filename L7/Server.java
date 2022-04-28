import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

import java.io.IOException;

public class Server {

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        // Method responsible for initialization of the server

        try {
            while(!serverSocket.isClosed()) {
                // A new Socket object is created
                // when the user connects to the server
                Socket socket = serverSocket.accept();

                out.println("Kliend dołączył do serwera.");

                ClientHandler handler = new ClientHandler(socket);

                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket() {
        // Check if server isn't null
        try {
            if(serverSocket != null) {
                serverSocket.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        server.startServer();
    }
}
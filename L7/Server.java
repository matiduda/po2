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
        out.printf("Initialized server at port " +
                    serverSocket.getLocalPort() +
                    "\nwaiting for connections...\n");


        try {
            while(!serverSocket.isClosed()) {
                
                Socket socket = serverSocket.accept();
                ClientHandler handler = new ClientHandler(socket);

                Thread thread = new Thread(handler);
                thread.start();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket() {
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
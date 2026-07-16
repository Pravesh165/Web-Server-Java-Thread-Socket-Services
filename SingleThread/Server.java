package SingleThread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public void run() throws IOException{
        int port = 8010;
        ServerSocket socket = new ServerSocket(port);
        socket.setSoTimeout(10000);
        while(true){
            try{
                System.out.println("Server is listening on port:"+port);
                Socket acceptedConection = socket.accept();
                System.out.println("Connection accepted from client "+acceptedConection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConection.getOutputStream(),true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConection.getInputStream()));
                toClient.println("Hello from the server");
                String line = fromClient.readLine();
                if (line != null) {
                    System.out.println("Response from client: " + line);
                } else {
                    System.out.println("Client closed connection without sending data.");
                }
                toClient.close();
                fromClient.close();
                acceptedConection.close();
            } catch (IOException ex){
                ex.getStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        
        try{
        Server server1 = new Server();
        server1.run();
        } catch(IOException ex){
            ex.getStackTrace();
        }
    }
}
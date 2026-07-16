package SingleThread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client{
    public void run () throws IOException{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        try{
        Socket socket = new Socket(address,port);
        PrintWriter toServer = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
       String line = fromServer.readLine();
            if (line != null) {
                System.out.println("Message from server: " + line);
            }
        toServer.println("Hello from the client");
        toServer.close();
        fromServer.close();
        socket.close();
        }catch(IOException ex){
            ex.getStackTrace();
        }
    }
    public static void main(String[] args){
        try{
        Client client1 = new Client();
        client1.run();
        } catch (IOException ex){
            ex.getStackTrace();
        }
    }
}
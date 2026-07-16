package MultiThread;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public Runnable getRuunable() throws IOException {
        return new Runnable() {
            @Override
            public void run() {
                int port = 8010;
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    try {
                        Socket socket = new Socket(address, port);
                        PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
                        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String line = fromServer.readLine();
                        if (line != null) {
                            System.out.println("Message from server: " + line);
                        }
                        toServer.println("Hello from the client");
                        toServer.close();
                        fromServer.close();
                        socket.close();
                    } catch (IOException ex) {
                        ex.getStackTrace();
                    }
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client clients = new Client();
        for (int i = 0; i < 100; i++) {
            try {
                Thread thread = new Thread(clients.getRuunable());
                thread.start();
            } catch (Exception e) {
                return;
            }
        }
    }
}

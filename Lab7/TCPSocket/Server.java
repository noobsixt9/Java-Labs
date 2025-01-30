// Shivaram Chalise (222036)

package Lab7.TCPSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try (ServerSocket ss = new ServerSocket(1234)) {
            System.out.println("Waiting for client");
            Socket server = ss.accept();
            System.out.println("Client Connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
            while (true) {
                String data = br.readLine();
                System.out.println("Message from client: " + data);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

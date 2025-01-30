// Shivaram Chalise (222036)

package Lab7.TCPSocket;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        try (Socket sc = new Socket("localhost", 1234)) {
            System.out.println("Client Connected");

            Scanner s = new Scanner(System.in);
            PrintWriter fw = new PrintWriter(sc.getOutputStream());

            while (true) {
                System.out.print("-> ");
                String data = s.nextLine();
                fw.println(data);
                fw.flush();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
// Shivaram Chalise (222036)

package Lab5.SequentialFileIO;

import java.io.*;

public class BufferedReaderWriter {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("text.txt"))) {
            bw.write("Hello Earth");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            int line;
            while ((line = br.read()) != -1) {
                System.out.print((char) line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

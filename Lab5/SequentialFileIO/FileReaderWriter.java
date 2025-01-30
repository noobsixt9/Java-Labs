// Shivaram Chalise (222036)

package Lab5.SequentialFileIO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("text.txt")) {
            fw.write("Hello Earth");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (FileReader fr = new FileReader("text.txt")) {
            int line;
            while ((line = fr.read()) != -1) {
                System.out.print((char) line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

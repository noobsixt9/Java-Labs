// Shivaram Chalise (222036)

package Lab5.RandomAccessIO;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomFileRW {
    public static void main(String[] args) {
        String filename = "text.bin";

        try (RandomAccessFile file = new RandomAccessFile(filename, "rw")) {
            file.writeBytes("Hello from the planet Earth!"); // Write data at the start of the file

            file.seek(29); // Move the pointer to position 29 in the file
            file.writeBytes("Writes something");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (RandomAccessFile file = new RandomAccessFile(filename, "r")) {
            file.seek(0); // Read from the beginning of the file

            byte[] bytes = new byte[27]; //
            file.read(bytes);
            System.out.println("Reading first 20 bytes: " + new String(bytes));

            byte[] rest = new byte[16];
            file.seek(29);
            file.read(rest);
            System.out.println("Reading the rest bytes (from position 29): " + new String(rest));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Shivaram Chalise (222036)
package Lab1;

import java.util.Scanner;

public class PrintPattern {

    public static void printSeries(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = sc.nextInt();

        printSeries(num);
    }
}

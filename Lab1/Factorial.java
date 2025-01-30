// Shivaram Chalise (222036)
package Lab1;

import java.util.Scanner;

public class Factorial {
    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = sc.nextInt();
        System.out.printf("The factorial of %d is %d.", num, fact(num));

    }
}

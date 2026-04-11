import java.util.Scanner;

public class problem10 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = myObj.nextInt();
        System.out.println("Enter the number: ");
        int number2 = myObj.nextInt();
        System.out.println(gcd(number, number2));
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
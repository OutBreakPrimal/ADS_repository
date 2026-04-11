import java.util.Scanner;

public class problem3 {
    public static String checkPrime(int n, int divisor) {
        if (n <= 1)
            return "Not Prime";
        if (n == 2)
            return "Prime";
        if (n % divisor == 0)
            return "Composite";
        if (divisor * divisor > n)
            return "Prime";
        return checkPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        System.out.println(checkPrime(n, 2));
    }
}

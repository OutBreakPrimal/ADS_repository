import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = myObj.nextInt();
        System.out.println("Enter the number: ");
        int m = myObj.nextInt();
        System.out.println(power(n, m));
    }

    public static int power(int n, int m) {
        int FinalNumber = 0;
        if (m == 0) {
            return 1;
        }
        for (int i = 1; i <= m; i++) {
            FinalNumber = n * power(n, m - 1);
        }
        return FinalNumber;
    }
}
import java.util.Scanner;

public class problem8 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = myObj.nextLine();
        char[] charArray = str.toCharArray();
        for (int i = charArray.length - 1; i >= 0;) {
            if (Character.isDigit(charArray[i])) {
                System.out.println("Yes");
                break;
            } else {
                System.out.println("No");
                break;
            }
        }
    }
}

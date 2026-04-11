import java.util.Scanner;

public class problem7 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = myObj.nextLine();
        generatorRandoma(str.toCharArray(), 0);
    }

    public static void generatorRandoma(char[] arr, int index) {
        if (index == arr.length - 1) {
            System.out.println(String.valueOf(arr));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generatorRandoma(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
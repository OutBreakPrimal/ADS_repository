import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyLinkedList<String> sumArrayList = new MyLinkedList<>();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            }
            sumArrayList.add(input);
        }
        for (int i = 0; i < sumArrayList.length(); i++) {
            System.out.println(sumArrayList.get(i));
        }
        scanner.close();
    }
}
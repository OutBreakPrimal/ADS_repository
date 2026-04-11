public class problem1 {
    public static void main(String[] args) {
        int arr[] = { 10, 1, 32, 3, 45 };
        System.out.println(min_val(arr));
    }

    public static int min_val(int arr[]) {
        int min_val = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min_val) {
                min_val = arr[i];
            }
        }
        return min_val;
    }
}

public class problem2 {
    public static void main(String[] args) {
        int n = 4;
        int arr[] = { 3, 2, 4, 1 };
        System.out.println(avr_value(arr, n));
    }

    public static float avr_value(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        float avr_value = (float) sum / n;
        return avr_value;
    }
}
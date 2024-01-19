package gr.aueb.cf.ch6;

/**
 * Search and find the highest value of
 * an array and displays it.
 */
public class ArrayMaxValueApp {

    public static void main(String[] args) {
        int[] arr = {4, 7, 98, 34, 23};
        int low = 0;
        int high = arr.length - 1;

        int maxPosition = getMaxPosition(arr, low, high );

        System.out.println("Max value is at position: " + (maxPosition +1));

    }
    public static int getMaxPosition(int[] arr, int low, int high) {
        int maxValue = arr[low];
        int maxPosition = low;

        if (arr == null) return -1;
        if (low < 0 || high > arr.length) return -1;
        if (low > high) return -1;

        for (int i = low + 1; i < high; i++) {
            if (arr[i] > maxValue) {
                maxPosition = i;
                maxValue = arr[i];
            }
        }
        return maxPosition;
    }
}

package gr.aueb.cf.ch6;

/**
 * Finds and Displays the second lowest
 * element of an array
 */
public class SecondLowestElementArray {

    public static void main(String[] args) {
        int[] arr = {9, 4, 8, 12, 3, 23, 2};
        int min;
        int minPosition;
        int tmp;

        for (int i = 0; i < arr.length - 1; i++) {

            min = arr[i];
            minPosition = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPosition = j;
                }
            }

            swap(arr, i, minPosition);

        }

        System.out.println(arr[1]);
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

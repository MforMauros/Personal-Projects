package gr.aueb.cf.ch6;

public class GetLowAndHighIndexOf {

    public static void main(String[] args) {
        int[] sorted = {0, 1, 4, 4, 4, 6, 7, 8, 8, 8, 8, 8};

        int[] LowHigh = getLowAndHighIndexOf(sorted, 8);

        System.out.println("The low and high index of the array is: " + LowHigh[0] + " " + LowHigh[1]);
    }

    public static int[] getLowAndHighIndexOf (int[] arr, int key ) {
        int[] findLowHigh = {0,0};
        int counter = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            if (findLowHigh[0] != 0 && key == arr[i]) {
                found = true;
                counter++;
            }
                if (key == arr[i] && found == false) {
                    findLowHigh[0] = i;
                }
        }
        findLowHigh[1] = findLowHigh[0] + counter;

        return findLowHigh;
    }
}

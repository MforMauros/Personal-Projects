package gr.aueb.cf.ch6;

import java.util.Arrays;

public class ParkingApp {

    public static int findMaxCars(int[][] arr) {
        int[][] events = new int[arr.length * 2][2]; // Each car contributes two events (arrival and departure)

        // Convert the arrival and departure times to events
        for (int i = 0; i < arr.length; i++) {
            events[i * 2] = new int[] { arr[i][0], 1 }; // arrival
            events[i * 2 + 1] = new int[] { arr[i][1], 0 }; // departure
        }

        // Sort the events by time
        // Sort the events using bubble sort
        for (int i = 0; i < events.length - 1; i++) {
            for (int j = 0; j < events.length - i - 1; j++) {
                if (events[j][0] > events[j + 1][0] || (events[j][0] == events[j + 1][0] && events[j][1] > events[j + 1][1])) {
                    // Swap events[j] and events[j + 1]
                    int[] temp = events[j];
                    events[j] = events[j + 1];
                    events[j + 1] = temp;
                }
            }
        }

        int currentCars = 0, maxCars = 0;
        for (int[] e : events) {
            if (e[1] == 1) { // arrival
                currentCars++;
            } else { // departure
                currentCars--;
            }
            maxCars = Math.max(maxCars, currentCars);
        }

        return maxCars;
    }

    public static void main(String[] args) {
        int[][] arr = {{1012, 1136}, {1317, 1417}, {1015, 1020}};
        System.out.println("Maximum number of cars parked at the same time: " + findMaxCars(arr));
    }
}

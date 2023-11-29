package gfgalgo.deque;

public class Prob_04FirstCircularTour {
    /*
    Consider an arrangement where n petrol pumps are arranged in a circular manner.
     We need to find the first petrol pump from where we can visit all petrol pumps and come back to the petrol pump
     without ever going out of the petrol.
    using a deque
     */

    static int firstPetrolTour(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0;          // Starting point of the tour
        int curr_petrol = 0;    // Current petrol in the tank
        int prev_petrol = 0;    // Accumulated petrol deficit

        // Start the loop to traverse the petrol pumps
        for (int i = 0; i < n; i++) {
            // Calculate the net petrol at the current petrol pump
            curr_petrol = curr_petrol + (petrol[i] - distance[i]);

            // If the net petrol becomes negative, indicating that we can't proceed from the current pump,
            // reset the start to the next pump and reset the current petrol to 0
            if (curr_petrol < 0) {
                prev_petrol = curr_petrol;  // Accumulate the petrol deficit
                start = i + 1;              // Set the start to the next pump
                curr_petrol = 0;            // Reset the current petrol to 0
            }
        }

        // Check if the total accumulated petrol (including deficit) is sufficient to complete the tour
        // If yes, return the starting point of the tour, otherwise, return -1
        return ((curr_petrol + prev_petrol) >= 0) ? (start + 1) : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {50, 10, 60, 100};
        int[] distance = {30, 20, 100, 10};

        System.out.println(firstPetrolTour(petrol, distance));
    }
}

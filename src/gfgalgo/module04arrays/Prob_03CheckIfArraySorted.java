package gfgalgo.module04arrays;

public class Prob_03CheckIfArraySorted {

    public static void main(String[] args) {
        // Given array
        int[] arr = {1, 3, 4, 5, 5, 6, 60};

        // Initialize indices for comparison
        int first = 0;
        int second = 1;

        // Iterate through the array for pairwise comparison
        for (int i = 0; i < arr.length - 1; i++) {
            // Check if the current pair is in non-decreasing order
            if (arr[first] <= arr[second]) {
                // Move to the next pair by incrementing both indices
                first++;
                second++;
            } else {
                // If the current pair is not in non-decreasing order, print "Not sorted" and exit the loop
                System.out.println("Not sorted");
                return;
            }
        }

        // If the loop completes without returning, the array is sorted
        System.out.println("Sorted");
    }
}

package gfgalgo.module04arrays;

public class Prob_02SecondLargestElementIndex {
    public static void main(String[] args) {
        // Given array
        int[] arr = {10, 40, 24, 22, 45};

        // Initialize indices for the largest and second largest elements
        int secondLargest = -1;  // -1 indicates that second largest is not found yet
        int largest = 0;  // Initialize largest as the first element

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Check if the current element is greater than the largest element
            if (arr[i] > arr[largest]) {
                // Update both largest and secondLargest indices
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                // Check if the current element is different from the largest element
                // and if secondLargest is not found yet or the current element is greater than the current secondLargest
                if (secondLargest == -1 || arr[i] > arr[secondLargest]) {
                    // Update secondLargest index
                    secondLargest = i;
                }
            }
        }

        // Print the index of the second largest element
        System.out.println(secondLargest);
    }
}
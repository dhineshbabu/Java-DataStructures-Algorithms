package gfgalgo.module05binarysearch;

public class Prob_12RepeatingElement {
    /*
    In this problem, we have an array where each element appears only once except for a single element that has multiple occurrences.
    Additionally, the array always contains the number 0, and if the maximum element in the array is x,
    then all elements from 0 to x are guaranteed to be present in the array.
     */

    // Function to find a repeated element in an array using Floyd's cycle detection algorithm
    static int repeat(int arr[], int n) {
        // Initialize two pointers, 'slow' and 'fast', both starting at the first element
        int slow = arr[0], fast = arr[0];

        // Move 'slow' one step at a time and 'fast' two steps at a time until they meet
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Reset 'slow' to the first element and move both pointers one step at a time until they meet
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        // The meeting point is the repeated element
        return slow;
    }

    public static void main(String args[]) {

        int arr[] = {1, 3, 2, 4, 6, 5, 7, 3}, n = 8;

        System.out.println(repeat(arr, n));


    }
}
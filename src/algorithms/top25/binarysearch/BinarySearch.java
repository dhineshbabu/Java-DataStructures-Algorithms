package algorithms.top25.binarysearch;

public class BinarySearch {
    public static int binarySearchIterative(int[] numbers, int numberToFind){
        // set the low value
        int low = 0;
        // set the high value to point the last element in the array
        int high = numbers.length - 1;

        // create the while loop for iteratively divide the array and check the number
        while(low <= high) {
            // find the middle position in the array
            int middlePosition = (low + high) / 2;
            // base case = check if the middle number is the target
            // if yes return the position
            if(numbers[middlePosition] == numberToFind) {
                return middlePosition;
            }
            // else check if the target is less than the number in the middle position
            // then we need to search from the left half of the array
            if(numberToFind < numbers[middlePosition]) {
                // just change the high pointer to the left of the middle position
                high = middlePosition - 1;
            }

            // else check if the target is higher than the number in the middle position
            // then we need to search from the right half of the array
            if(numberToFind > numbers[middlePosition]) {
                // just change the low pointer to the next of middle position
                // low will be start of the right sub array for the next while loop iteration
                low = middlePosition + 1;
            }
        }

        // return -1 as nothing found from the while loop
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedNumberArray = {1,5,12,16,27,29,32,34,35,36,42,48,52,58,62,68};
        System.out.println(binarySearchIterative(sortedNumberArray, 27));
        System.out.println(binarySearchIterative(sortedNumberArray, 53));
        System.out.println(binarySearchIterative(sortedNumberArray, 68));
    }

}

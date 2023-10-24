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

    // method for recursive technique: send the high and low in the method param
    public static int binarySearchRecursive(int[] numbers, int target, int low, int high) {
        // start with the while loop
        while(low <= high) {
            // find the middle position
            int middlePosition = (low + high) / 2;

            // check if the middle position is the target number
            if(numbers[middlePosition] == target) {
                return middlePosition;
            }
            // check if the target is less than the middle position number
            if(target < numbers[middlePosition]) {
                // then search recursively in the left half of the array
                return binarySearchRecursive(numbers, target, low, middlePosition-1);
            }

            // check if the target is higher than the middle position number
            if(target > numbers[middlePosition]) {
                // then search recursively in the right half of the array
                return binarySearchRecursive(numbers, target, middlePosition+1, high);
            }
            }

        // return -1 if none found inside while loop
        return -1;
        }


    public static void main(String[] args) {
        int[] sortedNumberArray = {1,5,12,16,27,29,32,34,35,36,42,48,52,58,62,68};

        // Iterative method
        System.out.println(binarySearchIterative(sortedNumberArray, 27));
        System.out.println(binarySearchIterative(sortedNumberArray, 53));
        System.out.println(binarySearchIterative(sortedNumberArray, 68));

        // Recursive method
        System.out.println(binarySearchRecursive(sortedNumberArray, 27, 0, sortedNumberArray.length-1));
        System.out.println(binarySearchRecursive(sortedNumberArray, 53,0, sortedNumberArray.length-1));
        System.out.println(binarySearchRecursive(sortedNumberArray, 68,0, sortedNumberArray.length-1));
    }

}

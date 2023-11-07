package gfgalgo.arrays;

public class Prob_SecondLargestElementIndex {
    public static void main(String[] args) {
        int[] arr = {10,40,24,22,45};

        int secondLargest=-1, largest=0;

        for(int i=1; i<arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if(arr[i] != arr[largest]) {
                if(secondLargest==-1 || arr[i] > arr[secondLargest]) {
                    secondLargest = i;
                }
            }
        }

        System.out.println(secondLargest);
    }
}

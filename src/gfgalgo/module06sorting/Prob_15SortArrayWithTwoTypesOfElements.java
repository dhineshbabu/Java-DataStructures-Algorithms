package gfgalgo.module06sorting;

public class Prob_15SortArrayWithTwoTypesOfElements {
    /*
    use modified Hoare's partition algorithm
    Objective to move all the negatiove elemtns to the beginning
     */


    static void sort(int arr[], int n) {
        int i = -1, j = n;
        while (true) {
            do {
                i++;
            } while (arr[i] < 0);
            do {
                j--;
            } while (arr[j] >= 0);
            if (i >= j) return;

            //swapping arr[i] & arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

    public static void main(String[] args) {
        int arr[] = new int[]{13, -12, 18, -10};

        int n = arr.length;

        sort(arr, n);

        for (int x : arr)
            System.out.print(x + " ");

    }
}

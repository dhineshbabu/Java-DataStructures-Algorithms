package gfgalgo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class DemoClass {
    public static int subset(int[] arr, int n, int sum) {
        // base case
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }

        return subset(arr, n - 1, sum) + subset(arr, n - 1, sum - arr[n - 1]);
    }

    public static int removeArrDuplicates(int[] arr) {
        int n = arr.length;
        int res = 1;


        for (int i = 1; i < arr.length; i++) {
            if (arr[res - 1] != arr[i]) {
                arr[res] = arr[i];
                res++;
            }
        }

        return res;
    }

    static int bSearchRec(int[] arr, int low, int high, int item) {
        // basecase
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (arr[mid] == item) return mid;
        else {
            return (arr[mid] > item) ? bSearchRec(arr, low, mid - 1, item) : bSearchRec(arr, mid + 1, high, item);
        }
    }

    public static void bubble(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }

                if (!swapped) {
                    break;
                }
            }
        }
    }

    public static void mergeArrays(int[] a, int[] b) {
        int i = 0, j = 0;
        int m = a.length, n = b.length;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }

        while (i < m) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j < n) {
            System.out.print(b[j] + " ");
            j++;
        }
    }

    public static void hashDemo() {
        HashSet<Integer> h = new HashSet<>();
        h.add(40);
        h.add(20);
        h.add(30);

        System.out.println(h.size());

        h.add(50);
        h.add(30);
        h.add(30);

        Iterator<Integer> it = h.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Integer[] arr = h.toArray(new Integer[]{});
        System.out.println("here");
        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {


        /*
        int[] nums = {10, 20, 15, 5};
        int sum = 25;
        System.out.println(subset(nums, nums.length, sum));

        int[] arr = {10, 20, 20, 30, 30, 30};
        System.out.println(removeArrDuplicates(arr));
        System.out.println(Arrays.toString(arr));


        int[] arr1 = {10, 20, 30, 40, 50, 65, 70};
        System.out.println(bSearchRec(arr1, 0, arr.length - 1, 65));
        System.out.println(Arrays.binarySearch(arr1, 25));

        int a[] = {2, 1, 4, 3};
        bubble(a);
        System.out.println(Arrays.toString(a));

        int[] a1 = {10, 20, 30};
        int[] b1 = {5, 50, 60};

        mergeArrays(a1, b1);

        */

        hashDemo();


    }
}

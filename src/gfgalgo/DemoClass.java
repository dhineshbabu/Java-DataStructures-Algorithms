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

    public static void stringFreq(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                System.out.println((char) (i + 'a') + " is " + count[i]);
            }
        }

    }

    public static boolean subSequence(String s1, String s2, int len1, int len2) {

        int n1 = len1, n2 = len2;

        if (n2 == 0) return true;
        if (n1 == 0) return false;

        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return subSequence(s1, s2, n1 - 1, n2 - 1);
        } else {
            return subSequence(s1, s2, n1 - 1, n2);
        }
    }

    static boolean subSequenceRec(String s1, String s2, int len1, int len2) {
        // calculate the length
        int n1 = len1;
        int n2 = len2;

        // base cases
        if (n2 == 0) {
            // we found the subsequqnce
            return true;
        }

        if (n1 == 0) {
            // source string ended we did not find the subsequence
            return false;
        }

        // for each recurive call if char matches then recude both n1 and n2
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1)) {
            return subSequenceRec(s1, s2, n1 - 1, n2 - 1);
        } else {
            // just reduce the n1 count
            return subSequenceRec(s1, s2, n1 - 1, n2);
        }
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

//        hashDemo();


//        stringFreq("hello");

        String s1 = "helloo";
        String s2 = "llo";
        System.out.println(subSequence(s1, s2, s1.length(), s2.length()));
    }

}

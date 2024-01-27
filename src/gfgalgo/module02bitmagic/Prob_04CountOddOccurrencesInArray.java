package gfgalgo.module02bitmagic;

public class Prob_04CountOddOccurrencesInArray {
    /*
    uses x^x = 0
    x^0 = x formula

    so in an array all the even numbers will be xor-ed and will become 0
    all the same odd numbers will be xor-ed and will become x
     */
    public static int oddOccurrences(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        return res;
    }

    // below method used to identify 2 odd occurring numbers
    public static void twoOddOccurrences(int[] arr) {
        int x = arr[0];

        //create an xor of all the numbers in the array
        for (int i = 1; i < arr.length; i++) {
            x = x ^ arr[i];
        }

        // find a number which has only 1 bit set and the set bit corresponds to the last set bit of x
        int k = (x & ~(x - 1));

        // create 2 variables to store the w result numbers
        int res1 = 0, res2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & k) != 0) res1 = res1 ^ arr[i];
            else res2 = res2 ^ arr[i];
        }

        System.out.println(res1 + " " + res2);
    }

    public static void main(String[] args) {
        System.out.println(oddOccurrences(new int[]{4, 4, 4, 5, 5, 6, 6, 8, 8}));
        twoOddOccurrences(new int[]{4, 4, 4, 5, 5, 6, 6, 6, 8, 8});
    }
}

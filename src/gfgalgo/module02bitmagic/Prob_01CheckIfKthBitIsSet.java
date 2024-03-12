package gfgalgo.module02bitmagic;

public class Prob_01CheckIfKthBitIsSet {
    /*
    Intuition is to multiply the given number with number for which only the kth bit is set
    formula to get the number with only Kth bit - 2 ^ (k-1)
     */
    public static void checkKthBit(int n, int k) {
        int x = 1;
        // generate the number to be multiplied:  2 ^ (k-1)
        for (int i = 0; i < (k - 1); i++) {
            x = x * 2;
        }

        // the above for loop can be achieved by left shift operator
        // int x = (1 << (k-1); // 2 ^ (k-1)

        // do the bitwise &
        if ((n & x) != 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        checkKthBit(4, 3);
    }
}

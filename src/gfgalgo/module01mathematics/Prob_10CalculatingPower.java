package gfgalgo.module01mathematics;

public class Prob_10CalculatingPower {
    public static int powerNumber(int x, int n) {
        // base case
        if (n == 0) return 1;

        int temp = powerNumber(x, n / 2);

        temp = temp * temp;

        if (n % 2 == 0) {
            return temp;
        } else {
            return temp * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(powerNumber(3, 5));
    }
}

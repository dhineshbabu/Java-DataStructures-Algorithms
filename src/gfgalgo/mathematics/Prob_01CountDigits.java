package gfgalgo.mathematics;

public class Prob_01CountDigits {
    /*
    Do Integer division until the x is > 0
    time complexity: ø(d)
     */
    public static int digits(int x) {
        int count = 0;
        while(x>0) {
            x = x/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(digits(34545));
    }
}

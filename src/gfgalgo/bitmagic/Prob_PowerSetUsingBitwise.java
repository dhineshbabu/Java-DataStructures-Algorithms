package gfgalgo.bitmagic;

public class Prob_PowerSetUsingBitwise {
    public static void powerSet(String s){
        int n = s.length();
        // get the 2^n for the combinations using leftshift operator
        int pSize = (1 << n);

        for(int i=0; i<pSize; i++) {
            for(int j=0; j<n; j++) {
                if((i & (1 << j)) != 0)
                    System.out.print(s.charAt(j));
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        powerSet("kani");
    }

}

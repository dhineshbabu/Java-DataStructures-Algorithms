package gfgalgo.mathematics;

public class Prob_04Euclidean_Algorithm {
    // to identify the greatest common divisor or HCF
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    // similarly for LCM = (a*b) / gcd(a,b)

    public static void main(String[] args) {
        System.out.println(gcd(12, 15));  //3
    }
}

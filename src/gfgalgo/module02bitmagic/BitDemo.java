package gfgalgo.module02bitmagic;

public class BitDemo {
    public static void main(String[] args) {
        // Bitwise AND
        int x = 3, y = 6;
        System.out.println(x & y); // 2

        //Bitwise OR
        System.out.println(x | y);

        // Bitwise XOR
        System.out.println(x ^ y);

        // Bitwiese NOT
        System.out.println(~x);

        // Leftshift - we can use leftshift when we need to multiply with power of 2
        System.out.println(x << 1); // formula is x * (2^y) if there is no overflow

        // signed right shift
        System.out.println(x >> 1);

    }
}

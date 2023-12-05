package gfgalgo.mathematics;

public class Prob_02PalindromeNumbers {
    /*
    ex.g: 78987 is a palindrome number
    1. do the modulo and get the last digit and add the output digit to the target
    2. Do the integer division for the rest

     */

    public static boolean isPalindromeNumber(int inputNumber) {
        int reverse = 0;
        int n = inputNumber;
        while(n > 0) {
            // get the last digit
            int digit = n%10;
            // remove the final digit by dividing with 10
            n = n/10;
            // add the digit to the reverse
            reverse = reverse*10 + digit;
        }

        // check the palindrome status
        return inputNumber == reverse;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(78987));
    }
}

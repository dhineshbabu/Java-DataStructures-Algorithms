package gfgalgo.module01mathematics;

public class Prob_05PrimeNumber {
    public static boolean isPrime(int n) {
        // Special case: 1 is not a prime number
        if (n <= 1) {
            return false;
        }

        // Special cases: 2 and 3 are prime numbers
        if (n == 2 || n == 3) {
            return true;
        }

        // Check divisibility by 2 or 3
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check divisibility by numbers of the form 6k ± 1, up to the square root of n
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                // If n is divisible by i or i+2, then it's not a prime number
                return false;
            }
        }

        // If no divisor is found, n is a prime number
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(523));
    }

    /*
    ChatGPT's explanation of the code


Certainly! This code is a part of a prime number checking algorithm that uses a specific optimization technique to quickly determine if a number n is prime.

Here's an explanation of the code:

Looping through numbers of the form 6k ± 1 up to the square root of n:

The loop iterates over values of i starting from 5 and incrementing by 6 in each iteration (i = i + 6). This is because prime numbers (except for 2 and 3) can be represented in the form of 6k ± 1.
The loop continues until i * i <= n, which means it iterates up to the square root of n. This is because if n has a factor larger than its square root, then it must also have a factor smaller than its square root. Checking only up to the square root reduces the number of iterations required.
Checking divisibility:

Inside the loop, the code checks if n is divisible by i or i + 2 using the modulo operator (%).
If n is evenly divisible by i or i + 2 (meaning there's no remainder), it means n is not a prime number because it has factors other than 1 and itself.
If either condition (n % i == 0 or n % (i + 2) == 0) is true, the function immediately returns false, indicating that n is not a prime number.
Optimization:

This approach reduces the number of divisions required to check for primality by only checking numbers of the form 6k ± 1 up to the square root of n.
By incrementing i by 6, the algorithm skips even numbers and numbers that are multiples of 3, since those numbers are not prime except for 2 and 3.
Overall, this code efficiently checks for primality by employing a specific optimization technique that reduces the number of divisions needed to determine if a number is prime.
     */

}

package gfgalgo.module12queue;

import java.util.LinkedList;
import java.util.Queue;

public class Prob_07GenerateNumbersWithGivenDigits {
    /*
    if given numbers is 5 and 6 then we need to generate the below numbers
    if n=10
    5,6,55,56,65,66,555,556,565,566
    Note: to be in sorted order

    idea is to use a queue to push first 2 digits
    and subsequently pop from the queue and add 5 and 6 and print the numbers and push them to the queue
     */

    static void printFirstN(int n, String digit1, String digit2) {
        Queue<String> queue = new LinkedList<>();

        // add the first 2 digits
        queue.offer(digit1);
        queue.offer(digit2);

        for (int count = 0; count < n; count++) {
            String curr = queue.remove();
            System.out.print(curr + " ");
            // append the digits again to the curr and then push the combination
            queue.add(curr + "5");
            queue.add(curr + "6");
        }
    }

    public static void main(String[] args) {
        printFirstN(10, "5", "6");
    }
}

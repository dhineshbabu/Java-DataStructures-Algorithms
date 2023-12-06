package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_06BalanceParenthesis {

    // Function to check if the parentheses in the given string are balanced
    static boolean balance(String str) {
        // Using Deque as a stack to track opening parentheses
        Deque<Character> stack = new ArrayDeque<>();

        // Iterate through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);

            // If the character is an opening parenthesis, push it onto the stack
            if (x == '(' || x == '{' || x == '[') {
                stack.push(x);
            } else {
                // If the stack is empty and the current character is a closing parenthesis,
                // the parentheses are not balanced
                if (stack.isEmpty()) {
                    return false;
                } else if (matching(stack.peek(), x) == false) {
                    // If the current character does not match the corresponding opening parenthesis
                    // at the top of the stack, the parentheses are not balanced
                    return false;
                } else {
                    // Matching pair found, pop the opening parenthesis from the stack
                    stack.pop();
                }
            }
        }

        // The parentheses are balanced if the stack is empty at the end
        return stack.isEmpty();
    }

    // Function to check if two characters form a matching pair of parentheses
    static boolean matching(char a, char b) {
        return ((a == '(' && b == ')')) ||
                ((a == '{' && b == '}')) ||
                ((a == '[' && b == ']'));
    }


    public static void main(String[] args) {
        String str = "(()))";
        System.out.println(balance(str));
        String str1 = "{}([()])";
        System.out.println(balance(str1));
    }
}

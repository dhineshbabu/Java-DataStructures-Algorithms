package gfgalgo.module11stacks;

import java.util.*;

public class Prob_13AInfixToPostFixConversion {
    // Create a stack
    private static Deque<Character> stack = new ArrayDeque<>();

    // initiate a map for operator precedence
    private static Map<Character, Integer> precedence = new HashMap<>();

    // output variable
    private static String output = "";

    // populate the precedence of the operator - can be customized
    public static void populateMap() {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    // isOperand method
    public static boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    // method for checking operator precedence
    public static boolean isNotGreater(char i) {
        int a, b;

        if (precedence.containsKey(i) && precedence.containsKey(stack.peek())) {
            a = precedence.get(i);
            b = precedence.get(stack.peek());
            return (a <= b);
        } else {
            return false;
        }
    }


    public static void infixToPostfix(String exp) {
        // Loop through each character in the infix expression
        for (int i = 0; i < exp.length(); i++) {
            // If the character is an operand, append it to the output
            if (isOperand(exp.charAt(i))) {
                output += exp.charAt(i);
            } else if (exp.charAt(i) == '(') {
                // If the character is an opening parenthesis, push it onto the stack
                stack.push(exp.charAt(i));
            } else if (exp.charAt(i) == ')') {
                // If the character is a closing parenthesis,

                // Pop and append operators from the stack until an opening parenthesis is encountered
                while (!stack.isEmpty() && stack.peek() != '(') {
                    char a = stack.pop();
                    output += a;
                }

                // Check for a matching opening parenthesis in the stack
                if (!stack.isEmpty() && stack.peek() != '(') {
                    // If there is no matching opening parenthesis, the expression is invalid
                    System.out.println("Invalid expression: Unmatched ')'");
                    return;
                } else {
                    // Pop the opening parenthesis from the stack
                    stack.pop();
                }
            } else {
                // If the character is an operator,

                // Pop and append operators with higher precedence from the stack
                while (!stack.isEmpty() && isNotGreater(exp.charAt(i))) {
                    char a = stack.pop();
                    output += a;
                }

                // Push the current operator onto the stack
                stack.push(exp.charAt(i));
            }
        }

        // Pop and append any remaining operators in the stack to the output
        while (!stack.isEmpty()) {
            char a = stack.pop();
            output += a;
        }

        // Print the postfix expression
        System.out.println(output);
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        populateMap();
        infixToPostfix(exp);
        System.out.println();
        output = "";
        String exp1 = "a+b*i";
        infixToPostfix(exp1);
    }

}

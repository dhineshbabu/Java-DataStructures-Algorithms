package gfgalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob_06BalanceParenthesis {
    static boolean balance(String str){
        // using Deque as stack
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++){
            char x = str.charAt(i);
            if(x == '(' || x == '{' || x == '['){
                stack.push(x);
            } else {
                if(stack.isEmpty() == true) {
                    return false;
                } else if(matching(stack.peek() , x) == false) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }

    static boolean matching(char a, char b){
        return((a=='(' && b == ')')) ||
                ((a=='{' && b == '}')) ||
                ((a=='[' && b == ']'));
    }

    public static void main(String[] args) {
        String str = "(()))";
        System.out.println(balance(str));
        String str1 = "{}([()])";
        System.out.println(balance(str1));
    }
}

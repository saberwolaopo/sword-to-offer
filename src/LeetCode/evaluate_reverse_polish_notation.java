package LeetCode;

import java.util.Stack;

/*
题目描述

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are+,-,*,/. Each operand may be an integer or another expression.

Some examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            try{
                int num = Integer.valueOf(tokens[i]);
                stack.push(num);
            }catch (Exception e){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(cauclute(a,b,tokens[i]));
            }
        }
        return stack.pop();
    }

    private int cauclute(int a, int b, String token) {
        switch (token){
            case "+":
                return a+b;
            case "-":
                return b-a;
            case "*":
                return a*b;
            case "/":
                return b/a;
            default:
                return 0;
        }
    }
}

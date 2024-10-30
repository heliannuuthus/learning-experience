package com.github.heliannuuthus.stackandqueue;

import java.util.Stack;

public class D8EvalRPN {

    public static void main(String[] args) {
        System.out.println(new Solution().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        Integer subtrahend = stack.pop();
                        Integer minuend = stack.pop();
                        stack.push(minuend - subtrahend);
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        Integer divisor = stack.pop();
                        Integer dividend = stack.pop();
                        stack.push(dividend / divisor);
                        break;
                    default:
                        stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}

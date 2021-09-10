package com.sc.cd.demo;

import java.util.Stack;

public class 递归实现栈的反序 {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        System.out.println(stack.toString());

        reverse(stack);


        System.out.println(stack.toString());

    }

    private static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        Integer e = stack.pop();
        reverse(stack);
        stack.push(e);
    }
}

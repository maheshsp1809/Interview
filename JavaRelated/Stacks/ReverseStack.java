package Stacks;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {
        // Create a stack
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Print the original stack
        System.out.println("Original stack: " + stack);

        // Reverse the stack using recursion
        reverseStack(stack);

        // Print the reversed stack
        System.out.println("Reversed stack: " + stack);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverseStack(stack);
            insertAtBottom(stack, temp);
        }
    }

    public static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertAtBottom(stack, value);
            stack.push(temp);
        }
    }
}

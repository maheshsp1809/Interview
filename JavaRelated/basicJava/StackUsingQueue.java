package basicJava;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int element) {
        queue1.add(element);

    }

    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        int poppedElement = queue1.poll();
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        System.out.println("popped element" + poppedElement);
        return poppedElement;

    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop()); // 3

        stack.pop();
        stack.pop();

        System.out.println(stack.isEmpty()); // true
    }
}
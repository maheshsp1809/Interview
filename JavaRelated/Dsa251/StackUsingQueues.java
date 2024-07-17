import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element onto stack
    public void push(int x) {
        queue1.add(x);
    }

    // Removes the element on top of the stack
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element in queue1 is the top element of the stack
        int topElement = queue1.remove();

        // Swap the references of the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Get the top element
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all elements except the last one from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // The last element in queue1 is the top element of the stack
        int topElement = queue1.peek();

        // Move the top element to queue2
        queue2.add(queue1.remove());

        // Swap the references of the two queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.top()); // Should print 3

        System.out.println("Popped element is: " + stack.pop()); // Should print 3

        System.out.println("Top element is: " + stack.top()); // Should print 2

        stack.push(4);

        System.out.println("Popped element is: " + stack.pop()); // Should print 4

        System.out.println("Popped element is: " + stack.pop()); // Should print 2

        System.out.println("Popped element is: " + stack.pop()); // Should print 1

        System.out.println("Is stack empty? " + stack.isEmpty()); // Should print true
    }
}

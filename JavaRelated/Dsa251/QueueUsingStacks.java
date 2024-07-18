import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(T item) {
        stack1.push(item);
    }

    // Dequeue operation
    public T dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2

        // Enqueue more elements
        queue.enqueue(4);
        queue.enqueue(5);

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 3
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 4
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 5

        // Check if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}

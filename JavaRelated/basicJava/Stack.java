package basicJava;

public class Stack {
    
    private int[] items;    // array to hold stack elements
    private int top;        // index of the top element

    public Stack(int capacity) {
        items = new int[capacity];
        top = -1;   // stack is initially empty
    }

    public void push(int item) {
        if (top == items.length - 1) {
            throw new StackOverflowError("Stack is full!");
        }
        items[++top] = item;   // increment top and add new item
    }

    public int pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty!");
        }
        return items[top--];   // remove and return top item
    }

    public int peek() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty!");
        }
        return items[top];     // return top item without removing it
    }

    public boolean isEmpty() {
        return top == -1;      // stack is empty if top is -1
    }

    public int size() {
        return top + 1;        // size of the stack is the number of elements
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());   // Output: 30
        System.out.println(stack.peek());  // Output: 20
        System.out.println(stack.size());  // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
    }
}


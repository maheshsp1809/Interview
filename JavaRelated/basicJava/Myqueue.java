package basicJava;
import java.util.Stack;

public class Myqueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    
    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
    public static void main(String[] args) {
        Myqueue stack = new Myqueue();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40); 
        stack.push(50);
        stack.push(60);
        System.out.println(stack.pop());   // Output: 30
        System.out.println(stack.peek());  // Output: 20
        System.out.println(stack.empty()); // Output: false
    }
}

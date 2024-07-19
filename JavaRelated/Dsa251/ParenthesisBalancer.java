import java.util.Stack;

public class ParenthesisBalancer {

    // Method to check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If the character is a closing bracket
            else if (ch == ')' || ch == '}' || ch == ']') {
                // If the stack is empty or the top of the stack doesn't match the closing
                // bracket
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        // If the stack is empty, all opening brackets were matched
        return stack.isEmpty();
    }

    // Helper method to check if the pair of characters is matching
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
                "()", // Balanced
                "({[]})", // Balanced
                "({[})", // Not Balanced
                "((()))", // Balanced
                "{[()]}]", // Not Balanced
                "[]{}()" // Balanced
        };

        for (String test : testCases) {
            System.out.println(test + " : " + (isBalanced(test) ? "Balanced" : "Not Balanced"));
        }
    }
}

package recursion;

public class BalancedParentheses {

    public static void generateParentheses(int n) {
        generateParenthesesHelper(n, 0, "");
    }

    public static void generateParenthesesHelper(int n, int open, String str) {
        if (n == 0 && open == 0) {
            System.out.println(str);
            return;
        }

        if (n > 0) {
            generateParenthesesHelper(n - 1, open + 1, str + "(");
        }
        if (open > 0) {
            generateParenthesesHelper(n, open - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        generateParentheses(n);
    }
}

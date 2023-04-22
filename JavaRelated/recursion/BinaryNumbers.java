package recursion;

public class BinaryNumbers {
    public static void generate(int n, int ones, int zeroes, String output) {
        if (n == 0) {
            System.out.print(output + " ");
            return;
        }

        generate(n - 1, ones + 1, zeroes, output + "1");

        if (ones > zeroes) {
            generate(n - 1, ones, zeroes + 1, output + "0");
        }
        return;
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n, 0, 0, "");
    }
}

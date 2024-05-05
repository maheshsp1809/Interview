package DSAcoding;

import java.util.LinkedList;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        return (josephus(n - 1, k) + (k - 1)) % n + 1;
        // (f(n-1,k)+k-1)%n +1;
    }

    public static void main(String[] args) {
        int n = 3; // Number of people
        int k = 2; // Elimination count

        int survivor = josephus(n, k);
        System.out.println("The survivor is at position: " + survivor);
    }
}

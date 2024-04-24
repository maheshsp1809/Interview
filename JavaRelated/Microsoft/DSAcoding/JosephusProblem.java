package DSAcoding;

import java.util.LinkedList;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Elimination count

        int survivor = josephus(n, k);
        System.out.println("The survivor is at position: " + survivor);
    }
}

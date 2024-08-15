package TreePractice;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < n; ++i) {
            tree.insert(arr[i]);
        }
        tree.inorder();

    }
}

package basicJava;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BoundaryTraversal {
    public static void printBoundary(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printLeftBoundary(root.left);

        printLeaves(root.left);
        printLeaves(root.right);

        printRightBoundary(root.right);
    }

    private static void printLeftBoundary(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.print(node.val + " ");
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            System.out.print(node.val + " ");
            printLeftBoundary(node.right);
        }
    }

    private static void printRightBoundary(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.right != null) {
            printRightBoundary(node.right);
            System.out.print(node.val + " ");
        } else if (node.left != null) {
            printRightBoundary(node.left);
            System.out.print(node.val + " ");
        }
    }

    private static void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            System.out.print(node.val + " ");
            return;
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         * / \
         * 7 8
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        printBoundary(root); // Output: 1 2 4 5 7 8 6 3
    }
}

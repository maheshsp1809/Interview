package TreePractice;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    public TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else if (data < root.val) {
            root.left = insertRecursive(root.left, data);
        } else {
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    public void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.val);
            inorderRecursive(root.right);
        }
    }

}

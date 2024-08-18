package TreePractice;

import java.util.Stack;

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
            System.out.print(root.val + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorder() {
        preorderRecursive(root);
    }

    public void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void ipreorder() {
        ipreorderRecursive(root);
    }

    public void iinorder() {
        iinorderRecursive(root);
    }

    public void iinorderRecursive(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }

    public void ipostorder() {
        ipostorderRecursive(root);
    }

    public void ipostorderRecursive(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                root = st.pop();
                TreeNode temp = root.right;
                while (temp != null) {
                    st.push(temp);
                    temp = temp.right;
                }

            }
        }
    }

    public void ipreorderRecursive(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            System.out.print(node.val + " ");
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);

        }
    }

    public void postorder() {
        postorderRecursive(root);
    }

    public void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.val + " ");
        }
    }

}

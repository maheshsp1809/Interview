import java.util.*;

public class Codec {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Serialize BST to a string
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserialize string to BST
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] nodes = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for (String node : nodes) {
            queue.offer(Integer.parseInt(node));
        }
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(Queue<Integer> queue, int lower, int upper) {
        if (queue.isEmpty())
            return null;
        int val = queue.peek();
        if (val < lower || val > upper)
            return null;
        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, lower, val);
        node.right = deserializeHelper(queue, val, upper);
        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.new TreeNode(5);
        root.left = codec.new TreeNode(3);
        root.right = codec.new TreeNode(7);
        root.left.left = codec.new TreeNode(2);
        root.left.right = codec.new TreeNode(4);
        root.right.left = codec.new TreeNode(6);
        root.right.right = codec.new TreeNode(8);

        // Serialize the BST
        String serialized = codec.serialize(root);
        System.out.println("Serialized BST: " + serialized);

        // Deserialize the string back to BST
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized BST: " + codec.serialize(deserialized));
    }
}

package javacodes;

import java.util.*;

public class BinaryTreeBottomView {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            int level = pair.level;

            // Update the value at the current horizontal level
            map.put(level, node.val);

            if (node.left != null) {
                queue.offer(new Pair(node.left, level - 1));
            }

            if (node.right != null) {
                queue.offer(new Pair(node.right, level + 1));
            }
        }

        // Traverse the TreeMap to get the bottom view values
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        BinaryTreeBottomView solution = new BinaryTreeBottomView();
        List<Integer> bottomView = solution.bottomView(root);
        System.out.println(bottomView); // Output: [2, 4, 5, 6]
    }
}

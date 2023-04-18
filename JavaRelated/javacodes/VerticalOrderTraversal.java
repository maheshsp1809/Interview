package basicJava;

import java.util.*;

public class VerticalOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // Use a TreeMap to store the nodes at each horizontal distance
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // Use a Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> hdQueue = new LinkedList<>(); // Queue to store the horizontal distances

        // Start with the root node at horizontal distance 0
        queue.offer(root);
        hdQueue.offer(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int hd = hdQueue.poll();

            // Add the node to the map at the corresponding horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, new ArrayList<>());
            }
            map.get(hd).add(node.val);

            // Enqueue the left child with a horizontal distance of hd-1
            if (node.left != null) {
                queue.offer(node.left);
                hdQueue.offer(hd - 1);
            }

            // Enqueue the right child with a horizontal distance of hd+1
            if (node.right != null) {
                queue.offer(node.right);
                hdQueue.offer(hd + 1);
            }
        }
        for (Integer level : map.keySet()) {
            System.out.println(level);
        }

        // Traverse the TreeMap and add the nodes to the result list
        for (List<Integer> level : map.values()) {
            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalOrder(root);
        System.out.println(result);
    }
}

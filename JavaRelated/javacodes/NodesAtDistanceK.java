package javacodes;

import java.util.*;

public class NodesAtDistanceK {
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

    public List<Integer> findNodesAtDistanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        findNodesDownwards(target, k, result);
        findNodesUpwards(root, target, k, result);
        return result;
    }

    private int findNodesDownwards(TreeNode node, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        }

        if (k == 0) {
            result.add(node.val);
            return -1;
        }

        int leftDist = findNodesDownwards(node.left, k - 1, result);
        int rightDist = findNodesDownwards(node.right, k - 1, result);

        if (leftDist >= 0) {
            if (leftDist + 1 == k) {
                result.add(node.val);
            }
            return leftDist + 1;
        }

        if (rightDist >= 0) {
            if (rightDist + 1 == k) {
                result.add(node.val);
            }
            return rightDist + 1;
        }

        return -1;
    }

    private int findNodesUpwards(TreeNode node, TreeNode target, int k, List<Integer> result) {
        if (node == null) {
            return -1;
        }

        if (node == target) {
            return 0;
        }

        int leftDist = findNodesUpwards(node.left, target, k, result);
        int rightDist = findNodesUpwards(node.right, target, k, result);

        if (leftDist >= 0) {
            if (leftDist + 1 == k) {
                result.add(node.val);
            } else {
                findNodesDownwards(node.right, k - leftDist - 2, result);
            }
            return leftDist + 1;
        }

        if (rightDist >= 0) {
            if (rightDist + 1 == k) {
                result.add(node.val);
            } else {
                findNodesDownwards(node.left, k - rightDist - 2, result);
            }
            return rightDist + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        NodesAtDistanceK tree = new NodesAtDistanceK();
        TreeNode target = root.left;
        int k = 2;
        List<Integer> nodesAtDistanceK = tree.findNodesAtDistanceK(root, target, k);
        System.out.println(nodesAtDistanceK); // Output: [7, 4, 1]
    }
}

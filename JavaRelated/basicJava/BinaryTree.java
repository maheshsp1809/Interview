package basicJava;

import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;
    
    public BinaryTree() {
        root = null;
    }
    
    public void insert(int data) {
        Node newNode = new Node(data);
        
        if (root == null) {
            root = newNode;
            return;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            
            if (current.left == null) {
                current.left = newNode;
                return;
            }
            else if (current.right == null) {
                current.right = newNode;
                return;
            }
            
            queue.add(current.left);
            queue.add(current.right);
        }
    }
    
    public void traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        
        traverseInOrder(node.left);
        System.out.print(node.data + " ");
        traverseInOrder(node.right);
    }

    public void diameterOfBinaryTree(Node root) {
        int [] d=new int[1];
        height1(root,d);
        System.out.print(d[0]);     
        }
    public int height1(Node root, int[] d){
        if(root==null) 
            return 0;
        int lh=height1(root.left,d);
        int rh=height1(root.right,d);
        d[0]=Math.max(lh+rh,d[0]);
        return 1+Math.max(lh,rh);
    }

    public void maxPathSum(Node root) {
        int [] d=new int[1];
           d[0]=root.data;
           height(root,d);
           System.out.println(d[0]);     
       }
    public int height(Node root, int[] d){
        if(root==null) 
            return 0;
        int lh=height(root.left,d);
        int rh=height(root.right,d);
        d[0]=Math.max(root.data+lh+rh,d[0]);
        return root.data+Math.max(lh,rh);
    }   

    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.insert(1);
        tree.insert(-2);
        tree.insert(3);
        // tree.insert(4);
        // tree.insert(5);
        
        // tree.traverseInOrder(tree.root);
        System.out.println();
        tree.maxPathSum(tree.root); // Output: 4 2 5 1 3
    }

}

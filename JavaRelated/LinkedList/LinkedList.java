package LinkedList;

public class LinkedList {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;

    public void add(int val) {
        Node ele = new Node(val);
        if (head == null) {
            head = ele;

        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = ele;

        }
    }

    public void remove(int val) {
        if (head == null)
            return;
        Node cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if (head != null && head.val == val)
            head = head.next;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); // prints "1 2 3"
        list.remove(2);
        list.printList(); // prints "1 3"
    }
}
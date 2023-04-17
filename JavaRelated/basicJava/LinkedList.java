package basicJava;

public class LinkedList{
  private Node head;
  
  private static class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
    }

    public void add(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newNode;
    }
    public void delete(int data){
        if(head==null) return;
        if(head.data==data){ head=head.next; return;}
        Node prev=head;
        Node current=head.next;
        while(current!=null && current.data!=data) {prev=current; current=current.next;}
        if(current!=null) prev.next=current.next;

    }

    public void printlist(){
        Node current=head;
        while(current!=null){
            System.out.println(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }

    public void reverse(){
        if(head==null){
            return;
        }
        Node prev=null; 
        Node current=head;
        while(current!=null){
            Node nex=current.next;
            current.next=prev;
            prev=current;
            current=nex;
        }
        head=prev;

    }

    public static void main(String[] args){
        LinkedList list=new LinkedList();
        list.add(10);
        list.add(40);
        list.add(30);
        list.printlist();
        // list.delete(40);
        list.printlist();
        list.reverse();
        list.printlist();
    }
  }


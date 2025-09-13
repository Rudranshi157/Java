public class DoubleLL{
    public class Node{
        int data;
        Node prev;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void  addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    public void addlast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next = newNode;
        newNode.next=null;
        newNode.prev = tail;
        tail = newNode;
    }
    public static void print(){
        Node temp =head;
        while(temp != null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.print("null\n");
    }
    public static int removeFirst(){
        if(head==null){
            System.out.print("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head=head.next;
        head.prev = null;
        size--;
        return val;
    }
    public static int removeLast(){
        if(head == null){
            System.out.println("empty Double LinkedList");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val = head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val =tail.data;
        tail= tail.prev;
        tail.next = null;
        size--;
        return  val;

    }
    public static void reverse(){
        Node curr = head;
        Node prev = null;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr =next;
        }
        head = prev;
    }
    public static void main(String args[]){
        DoubleLL dll= new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addlast(25);
        dll.print();
        // System.out.println(dll.size);
        // System.out.println(dll.removeFirst());
        // System.out.println(dll.size);
        // dll.print();
        dll.reverse();
        dll.print();
        dll.removeLast();
        dll.print();
    }
}
import java.util.*;

public class StackB{

    // Stack implementation by LinkedList
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class StackLL{
        static Node head = null;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return head.data;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }
    }
    // Stack implementation by ArrayList
    static class StackArr{
        static ArrayList<Integer> list = new ArrayList<>();
        public static boolean isEmpty(){
            return list.size()==0;
        }  
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }
        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args []){
        // by ArrList
        StackArr s = new StackArr();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        // by LinkedList
        StackLL ll = new StackLL();
        ll.push(10);
        ll.push(11);
        ll.push(12);
        while(!ll.isEmpty()){
            System.out.println(ll.peek());
            ll.pop();
        }
        //  Stack using Collection Framework
        Stack<Integer> c = new Stack<>();
        c.push(1);
        c.push(2);
        c.push(3);
        while(!c.isEmpty()){
            System.out.println(c.peek());
            c.pop();
        }
    }
}
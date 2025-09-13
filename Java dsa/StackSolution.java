import java.util.*;
public class StackSolution{
    public static boolean isPalindrome(Node head){
        Node curr=head;
        Stack<Character> s=new Stack<>();
        while(curr!=null){
            s.push(curr.data);
            curr=curr.next;
        }
        while(!s.isEmpty()){
            if(s.pop()!=head.data){
                return false;
            }
            head=head.next;
        }

        return true;
    }
    public static void decoded(String str){
        StringBuilder sb =new StringBuilder("");
        Stack <Character> s= new Stack<>();
        for(int i=str.length()-1;i>0;i--){
            char ch= str.charAt(i);
            if(ch=='['){
                StringBuilder sb1 =new StringBuilder("");
                int n=str.charAt(i+1);
                while(ch!=']'&& (!s.isEmpty())){
                    String a =s.pop().toString();
                    StringBuilder l=new StringBuilder(a);
                    sb1.append(l);
                }
                s.pop();
                while(n>0){
                    sb.append(sb1);
                }
            }else{
                s.push(ch);
            }
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        // Node head=new Node('A');
        // Node two=new Node('B');
        // Node three=new Node('C');
        // Node four=new Node('C');
        // Node five=new Node('A');
        // head.next=two;
        // two.next=three;
        // three.next=four;
        // four.next=five;
        // System.out.println("Palindrome: "+isPalindrome(head));
        String st="2[cv]";
        decoded(st);
    }

}
class Node{
    Node next;
    char data;
    public static Node head;
    public Node(char data){
        this.data =data;
        this.next =null;
    }
}
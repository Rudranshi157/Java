import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class QueueL3{
    public static void firstNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(int i= 0; i<str.length(); i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
               q.remove();
            }
            if(q.isEmpty()){
                System.out.print(-1+" ");
            }else{
                System.out.print(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void interLeave(Queue<Integer> q){
        int size = q.size();
        Queue<Integer> firstQueue = new LinkedList<>();
        for(int i= 0 ; i<size/2 ; i++){
            firstQueue.add(q.remove());
        }
        while(!firstQueue.isEmpty()){
            q.add(firstQueue.remove());
            q.add(q.remove());
        }
    }
    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
    public static void main(String[] args) {
        // String str = "aabccxb";
        // firstNonRepeating(str);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // q.add(6);
        // q.add(7);
        // q.add(8);
        // q.add(9);
        // q.add(10);
        //interLeave(q);
        reverse(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();

        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addLast(3);
        d.addLast(4);
        System.out.println(d);
        d.removeLast();
        System.out.println(d);
        d.removeFirst();
        System.out.println(d+ "first ele = "+d.getFirst() + " last ele = "+d.getLast());

    }
}
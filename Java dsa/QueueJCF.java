
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueJCF{
    public static class QueueStacks{
        static Stack<Integer> S1 = new Stack<>();
        static Stack<Integer> S2 = new Stack<>();
        public static boolean isEmpty(){
            return S1.isEmpty() ;
        }
        public static void add(int data){
            while(!S1.isEmpty()){
                S2.push(S1.pop());
            }
            S1.push(data);
            while(!S2.isEmpty()){
                S1.push(S2.pop());
            }
        }
        public static int remove(){
            if(S1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return S1.pop();
        }
        public static int peek(){
            if(S1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return S1.peek();
        }
    }
    public static class QueueStacks2{
        static Stack<Integer> S1 = new Stack<>();
        static Stack<Integer> S2 = new Stack<>();
        public static boolean isEmpty(){
            return S1.isEmpty() ;
        }
        public static void add(int data){
            S1.push(data);
        }
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!S1.isEmpty()){
                S2.push(S1.pop());
            }
            int result = S2.pop();
            while(!S2.isEmpty()){
                S1.push(S2.pop());
            }
            return result;
        }
        public static int peek(){
            if(S1.isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            while(!S1.isEmpty()){
                S2.push(S1.pop());
            }
            int result = S2.peek();
            while(!S2.isEmpty()){
                S1.push(S2.pop());
            }
            return result;
        }
    }   
    /*public*/ static class Stack1{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        public static int pop(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int result = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    result = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(result);
                }
                // while(!q2.isEmpty()){
                //     q1.add(q2.remove());
                // }
            }else{
                while(!q2.isEmpty()){
                    result = q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(result);
                }
                // while(!q1.isEmpty()){
                //     q2.add(q1.remove());
                // }
            }
            return result;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("empty stack");
                return -1;
            }
            int result = -1;
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    result = q1.remove();
                    q2.add(result);
                }
                // while(!q2.isEmpty()){
                //     q1.add(q2.remove());
                // }
            }else{
                while(!q2.isEmpty()){
                    result = q2.remove();
                    q1.add(result);
                }
                // while(!q1.isEmpty()){
                //     q2.add(q1.remove());
                // }
            }
            return result;
        }
    }
    
    public static void main(String args[]) {
        // QueueStacks2 q = new QueueStacks2();  //ArrayDeque
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while(!q.isEmpty()){
        //     System.out.println(q.peek());
        //     q.remove();
        // }
        Stack1 s = new Stack1();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
import java.util.Deque;
import java.util.LinkedList;
public class QueuePractice{
    public static void binaryTransform(int N){
        Deque<Integer> q = new LinkedList<>();

        int ele=0 , rem=0 , num;
        for (int i= 1 ; i<=N ; i++){
            num = i;
            ele=0;
            while(num>0){
                rem = num%2;
                num = num/2;
                //ele = ele*10 + rem;
                q.addLast(rem);
            }
            while(!q.isEmpty()){
            int r = q.removeLast();
            System.out.print(r);
            }
            System.out.print(" ");
            //q.add(ele);
        }


    }
    public static void main(String[] args) {
        binaryTransform(5);
    }
}
import java.util.*;
public class StackB2{
    // Amazom
    public static void addToBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        addToBottom(s,data);
        s.push(top);
    }
    // Reverse a string using a stack
    // Microsoft , Adobe , Amazom , Paytm
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        return sb.toString();
    }
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        addToBottom(s,top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    public static void nextGreaterElement(int arr[], Stack<Integer> s, int nG[]){
        for(int i = arr.length-1; i>=0 ; i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nG[i]=-1;
            }else{
                nG[i]=arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void stockSpan(int stocks[] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i=1 ; i<stocks.length ; i++){
            while(!s.isEmpty() && stocks[i]> stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                span[i]=i-s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // addToBottom(s,4);
        // while(!s.isEmpty()){
        //     System.out.println(s.pop());
        // }

        // String s = "hell0 world";
        // System.out.println(s);
        // System.out.println(reverseString(s));

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // printStack(s);

        // Stack<Integer> s = new Stack<>();
        // int arr[] = {6,8,0,1,3};
        // int nextGreater[] = new int[arr.length];
        // nextGreaterElement(arr,s,nextGreater);
        // for(int i=0 ; i<nextGreater.length ; i++){
        //     System.out.print(nextGreater[i]+" ");
        // }

        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        stockSpan(stocks,span);
        for(int i=0 ; i<span.length ; i++){
            System.out.print(span[i]+" ");
        }
    }

}
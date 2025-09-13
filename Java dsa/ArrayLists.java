import java.util.*;
public class ArrayLists{
    public static void swap(ArrayList<Integer> list , int idx1 , int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static int storeWater(ArrayList<Integer> height){
        int max=Integer.MIN_VALUE;
        for(int i = 0 ; i<height.size() ; i++){
            for( int j=i+1 ; j<height.size() ; j++){
                int length = j-i;
                int width = Math.min(height.get(i), height.get(j));
                int currWater = length*width;
                max = Math.max(max, currWater);
            } 
        }
        return max;
    }
    public static int optimisedStoreWater(ArrayList<Integer> height){
        int max = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = height.size()-1;
        while(leftPointer<rightPointer){
            int width = rightPointer-leftPointer;
            int ht = Math.min(height.get(leftPointer), height.get(rightPointer));
            int currWater = width *ht; 
            max = Math.max(max, currWater);

            //Updation
            if(height.get(leftPointer)< height.get(rightPointer)){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return max;
    }
    public static boolean pairSum(ArrayList<Integer> list , int  target){
        for(int i=0 ; i<list.size() ; i++){
            for(int j= i+1 ; j<list.size() ; j++){
                if((list.get(i)+list.get(j))==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean pairSum2(ArrayList<Integer> list,int target){
        int rp=list.size()-1;
        int lp = 0;
        while(lp<rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)>target){
                rp--;
            }else{
                lp++;
            }
        }
        return false;
    }
    public static boolean rotatedArrayListPairSum(ArrayList<Integer> list,int target){
        int n = list.size();
        int bp = -1;  // breaking point
        //fint braking point
        for(int i =0 ; i<n-1 ; i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp=bp+1;
        int rp = bp;
        while(lp!=rp){
            //case 1
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }
            //case 2
            if(list.get(lp)+list.get(rp)<target){
                lp = (lp+1)%n;
            }else{ //case 3
                rp = (rp+n-1)%n;
            }
        }
        return false;
    }
    public static boolean monotonicArrayList(ArrayList<Integer> list){
        if(list.get(0)<list.get(list.size()-1)){
            for(int i=0 ; i<list.size()-1 ; i++){
                if(list.get(i)>list.get(i+1)){
                    return false;
                }
            }
        }else{
            for(int i=0 ; i<list.size()-1 ; i++){
                if(list.get(i)<list.get(i+1)){
                    return false;
                }
            }
        }
        return true;
    }
    public static ArrayList lonelyPairs(ArrayList<Integer> list){
        Collections.sort(list);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1 ; i<list.size()-1 ; i++){
            if(list.get(i)+1<list.get(i+1) && list.get(i)>list.get(i-1)+1){
                ans.add(list.get(i));
            }
        }
        
        if(list.size()==1){
            ans.add(list.get(0));
            return ans;
        }
        if(list.get(0)+1<list.get(1)){
            ans.add(list.get(0));
        }
    
    
        if(list.get(list.size()-1)>list.get(list.size()-2)+1){
            ans.add(list.get(list.size()-1));
        }
            
        return ans;
    }
    public static int mostFreqTarget(ArrayList<Integer> list ,int key){
        ArrayList<Integer> target = new ArrayList<>();
        for(int i=0 ; i<list.size()-1 ; i++){
            if(list.get(i)==key){
                target.add(list.get(i+1));
            }
        }
        Collections.sort(target);
        int max = Integer.MIN_VALUE;
        int ans=0 ;
        for(int i = 0 ; i<target.size() ; i++){
            int count= 1;
            while(i != target.size()-1 && Objects.equals(target.get(i), target.get(i+1))){
                count++;
                i++;
            }
            if(max<count){
                ans= target.get(i);
                max=count;

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //add element --O(1)
            //list.add(4);
            //list.add(1,99);    ------O(n)
        //get operation ---O(1)
            //System.out.println(list.get(4));
        //Delete  ---O(n)
            //list.remove(2);
        //Set ---O(n)
            //list.set(2, 1009);
        // Contains elements
            //System.out.println(list.contains(100));
        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<list.size(); i++){
            max = Math.max(max, list.get(i));
        }
        //System.out.println(max);
        int idx1  =1 , idx2 = 3;
        //swap(list, idx1, idx2);
        //Collections.sort(list);   //ascending
        //Collections.sort(list , Collections.reverseOrder());
        //System.out.println(list);
        
        //MultiDimentional ArrayList
        // ArrayList<Integer> hello =new ArrayList<>();
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        // ArrayList<Integer> hi =new ArrayList<>();
        // ArrayList <Integer> Namaste = new ArrayList<>();
        // for(int i=1 ; i<=5 ; i++){
        //     hi.add(i);
        //     hello.add(i*2);
        //     Namaste.add(i*3);
        // }
        // mainList.add(hi);
        // mainList.add(hello);
        // mainList.add(Namaste);
        // System.out.println(mainList);
        ArrayList<Integer> container = new ArrayList<>();
        container.add(2);
        container.add(2);
        container.add(2);
        container.add(2);
        
        container.add(3);
        //container.add(100);
        //System.out.println(monotonicArrayList(container));
        System.out.println(mostFreqTarget(container, 2));


    }
}
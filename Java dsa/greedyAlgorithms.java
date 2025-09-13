import java.util.*;
public class greedyAlgorithms{
    public static void fractionalKnapsack(int val[], int weight[], int W){
        double ratio[][] = new double[val.length][2];
        // 0th col => idx; 1st col => ratio

        for(int i=0 ; i< val.length ; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        //ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i=ratio.length-1 ; i>=0 ; i--){
            int idx = (int)ratio[i][0];
            if(capacity>=weight[idx]){ //include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            }else{
                //include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        System.out.println("final value ="+ finalVal);
    }
    public static void maxLengthChainOfPair(int arr[][]){
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
        int chainLen = 1;
        int chainEnd = arr[0][1]; //last selected pair end // chain end

        for(int i=1 ; i<arr.length; i++){
            if(arr[i][0]> chainEnd){
                chainLen++;
                chainEnd = arr[i][1];
            }
        }

        System.out.println("max length of chain = "+ chainLen);
    }
    static class Job{
        int deadline;
        int profit;
        int id;
         public Job(int i, int d, int p){
            this.id = i;
            this.deadline = d;
            this.profit = p;
         }
    } 
    public static void minCostChocolateCut(Integer verCost[] , Integer horCost[]){
        int vp=1 , hp = 1;
        int h=0 , v=0;
        int minCost=0;
        Arrays.sort(verCost , Collections.reverseOrder());
        Arrays.sort(horCost , Collections.reverseOrder());
        while(h< horCost.length && v < verCost.length){
            if(horCost[h] > verCost[v]){
                minCost += horCost[h]*vp;
                hp++;
                h++;
            }else{
                minCost += verCost[v]*hp;
                vp++;
                v++;
            }
        }
        if(h<horCost.length){
            minCost += horCost[h]*vp;
            hp++;
            h++;
        }
        if(v < verCost.length){
            minCost += verCost[v]*hp;
            vp++;
            v++;
        }
        System.out.println("min cost is = "+minCost);
    }
    public static void maxNumOfSubstrings(String str){
        int r=0 , l=0;
        int maxNum =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='R'){
                r++;
            }else{
                l++;
            }
            if(r==l){
                maxNum++;
            }
        }
        System.out.println("max no. of substrings = "+maxNum);
    }
    public static int largestKthNum(int l , int r , int k){
        if(k<=r && k>l){
            int ans = ((r%2 != 0)? r : r-1);
            return ans;
        }
        
        return 0;

    }
    public static void main(String[] args) {
        // int val[] = {60, 100, 120};
        // int weight[] = {10, 20 ,30};
        // int W = 50;
        // //fractionalKnapsack(val, weight,W);
        // int pairs[][] = {{5,24},{39,60},{5,28},{27,40},{50,90}};
        // maxLengthChainOfPair(pairs);

        //jobs
    //     int jobsInfo[][] = {{2,20},{3,10},{5,40},{1,30}};
    //     ArrayList<Job> jobs = new ArrayList<>();
    //     for(int i=0 ; i<jobsInfo.length ; i++){
    //         jobs.add(new Job(i,jobsInfo[i][0],jobsInfo[i][1]));
    //     } 

    //     Collections.sort(jobs, (obj1 , obj2) -> obj2.profit-obj1.profit);
    //     ArrayList<Integer> seq = new ArrayList<>();
    //     int time = 0;
    //     for(int i=0; i<jobs.size(); i++){
    //         Job curr = jobs.get(i);
    //         if(curr.deadline > time){
    //             seq.add(curr.id);
    //             time++;
    //         }
    //     }

    //     System.out.println("max jobs = "+ seq.size());
    //     for(int i=0 ; i<seq.size() ; i++){
    //         System.out.print(seq.get(i)+" ");
    //     }
    //     System.out.println();
    // Integer horCost[] = {2,1,4};
    // Integer verCost[] = {2,1,3,1,4};
    // minCostChocolateCut(verCost, horCost);
    // String str = "LRRRRLLRLLRL";
    // maxNumOfSubstrings(str);

    System.out.println(largestKthNum(-3, 3, 1));
    }
}
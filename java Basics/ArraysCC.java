import java.util.* ;

public class ArraysCC{
    public static void printArray(String menu[]) {
        System.out.println("your array");
        for (int i = 0 ; i<menu.length ; i++){
            System.out.print(menu[i]+ " ");
        }
        System.out.println();
    }
    public static void formArray(String menu[]) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i<menu.length ; i++){
           System.out.print("enter the data : ");
           menu[i] = sc.next();  
        }
        System.out.println("YOUR ARRAY IS FORMED");
    }    
    public static String abc(int a) {
        if (a==1){
            return "sf";
        }
        System.out.println("hi i am rudranshi mittal.");
        return "2nd";
        
    }
    public static void subArrays(int a[]) {
        int u=Integer.MAX_VALUE , k , t = Integer.MIN_VALUE , h;
        for (int i =0 ; i< a.length; i++){
            int f=i;
            for(int j=i ; j<a.length ; j++){
                int e = j;
                h=0;
                System.out.print("(");
                for( k = f; k<=e ; k++){
                    System.out.print(a[k]);
                    if(k!=e){
                        System.out.print(",");
                    }
                    h = h + a[k];
                }
                System.out.print(")");
                System.out.println();
                if(h>t){
                    t=h;  //max
                }
                if(h<u){
                    u=h;   //min
                }
            }
            //System.out.println();
            }
            System.out.println("max "+ t);
            System.out.println("min "+u);
        
    }


    //--------BRUTE FORCE-------
    public static void maxSubarraySum(int a[]){
         int u=Integer.MAX_VALUE , k , t = Integer.MIN_VALUE , h;
        for (int i =0 ; i< a.length; i++){
            int f=i;
            for(int j=i ; j<a.length ; j++){
                int e = j;
                h=0;
                
                for( k = f; k<=e ; k++){
                    h+=a[k];
                }
                System.out.println(h);
                t = Math.max(h,t);
                u= Math.min(u,h);
            }
        } 
        System.out.println("max : "+t);
        System.out.println("min : "+u);
    }       



               //PREFIX SUM METHOD
    public static void prefixmaxSum(int a[]){
        int max=Integer.MIN_VALUE ,prefix[]= new int[a.length],curr;
        prefix[0]= a[0];
        //calc prefix array
        for(int i=1 ; i<a.length ; i++){
            prefix[i]= prefix[i-1] + a[i];
            }
        for (int i =0 ; i< a.length; i++){
            int f=i;
            for(int j=i ; j<a.length ; j++){
                int e = j;
                curr = f==0? prefix[e] : prefix[e] - prefix[f-1];
                 
                max = Math.max(max,curr);
            }
        }           
        System.out.println("max sum of subarray is : "+ max);
        System.out.println(Arrays.toString(prefix));
    }

    public static void kadanes(int a[]){
        int max=Integer.MIN_VALUE , cs=0 ;
        for (int i=0 ; i<a.length ; i++){
            cs += a[i] ;
            if (cs<0){
                cs=0;
            }
            max = Math.max(cs,max);
        }
        System.out.println("our max subarray sum is"+max);
    }


    //----------TRAPPED RAINWATER PROBLEM----------------
    public static int trappedRainwater(int height[]){
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];
        int trappedWater = 0;

        //calc left max boundary
        leftMax[0] = height[0];
        for(int i=1 ; i<n ; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        //calc right max boundary
        rightMax[n-1] = height[n-1];
        for (int i=n-2 ; i>=0 ; i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);    
        }
        
        //loop
        //waterlevel = min btw left and right boundary
        for(int i =0 ; i<n ; i++){
            int waterlevel = Math.min(leftMax[i],rightMax[i]);

        //trappedwater = waterlevel - height[i]
            trappedWater += waterlevel - height[i];
            

        }
        
        return trappedWater;
    }

    //1 <= nums.lengtth <= 105•     -109 <= nums [ i ] <= 109
    public static boolean isRepeated(int nums[]){
        int l = nums.length;
        
        for (int i = 0 ; i < l-1 ; i++){
            for(int j = i+1 ; j< l ; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }        
        return false;
    }


    public static int numLocation(int a[] ,int  target){
        for(int i = 0 ; i<a.length ; i++){
            if(target==a[i]){
                return i;
            }
        }
        return -1 ; 
    }

    public static int stockProfit(int prices[]) {
        int l = prices.length   , maxprofit=0  , buyprice = Integer.MAX_VALUE;
        for(int i = 0 ; i<l ; i++){
            if(buyprice < prices[i]){
                int profit = prices[i] - buyprice;
                maxprofit  = Math.max(profit , maxprofit);
            }else{
                buyprice = prices[i];
            }
            }
        return maxprofit;    
            
    }

    public static void tripets(int nums[]){
        int l = nums.length ;
        int b[] = new int[3];
        System.out.print("[");
        for (int i = 0 ; i<l-2 ; i++){
            for(int j = i+1 ; j<l-1 ; j++){
                for(int k= j+1 ; k<l ; k++){
                    if( i!=j && j!=k && i!=k && (nums[i]+nums[j] +nums[k]==0) ){
                        int a[]= {nums[i],nums[j],nums[k]};
                        System.out.print(Arrays.toString(a) +",");
                    }
                }
            }
        } 
        System.out.println("] ");       
    }
    


    public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
        // System.out.println("enter limit of array");
        // int n = sc.nextInt();
        // String menu[] = new String[n];
        // formArray(menu);
        // printArray(menu);
        
    //     int a = 3;
    //     System.out.println(abc(a));
    //int b[]={1,-2,6,-1,3};
    //maxSum(b);
    //kadanes(b);
    //subArrays(b);
    //maxSubarraySum(b);
    //prefixmaxSum(b);
        int a[] = {-1,0,1,2,-1,-4};
        int b[] = {};
        int c[] = {0};

        tripets(a);
        tripets(b);
        tripets(c);

          //System.out.println(trappedRainwater(a));
        // if( 1 > a.length ||  a.length > Math.pow(10, 5)){
        //     System.out.println("length of array is inapropriate");
            
        // }
        // for (int i = 0 ; i<= a.length ; i++){    
        //     if( a[i] < Math.pow(-10,9) || a[i] > Math.pow(10,9)){
        //         System.out.println("arrays value inappropriate");
            
        //     }
        // }


        
        //System.out.println(stockProfit(c));
      
       
    }
}

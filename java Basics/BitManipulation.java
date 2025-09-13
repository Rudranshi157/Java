public class BitManipulation{

    public static void oddOrEven(int n){
        int bitwise = 1;
        if((bitwise & n) == 0){
            System.out.println("even number");
        }else{
            System.out.println("odd number");
        }
    }
    public static int getIthBit(int n , int i){
        int BitMask = 1<<i;
        if((BitMask & n)==0){
            return 0;
        }else{
            return 1;
        }
    }

    public static int clearIthBit(int n,int i ){
        int BitMask = ~(1<<i);
        return n & BitMask;

    }
    public static int setIthBit(int n,int i){
        int BitMask = 1<<i;
        return n | BitMask;
    }
    public static int updateIthBit(int n, int i , int newBit){
        n = clearIthBit(n, i);
        int BitMask = newBit<<i;
        return (n | BitMask);
    }
    public static int clearIthBits(int n , int i){
        int bitMask = (~0)<<i;
        return n & bitMask;
    }
    public static int clearIthBitsRange(int n , int i,int j){
        int a = (~0)<<(j+1);
        int b = 1<<i - 1;
        int bitMask = a | b;
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }
    public static int countSetBits(int n){
        int count = 0;
        while(n>0){
            if((n & 1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static int fastExpo(int a , int n){
        int ans = 1;
        while(n>0){
            if((n & 1) != 0){
                ans = ans * a;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }
    public static void swapNum(int x , int y){
        System.out.println("Numbers before swaping : x= "+x+"  y= "+y);
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("Numbers after  swaping : x= "+x+"  y= "+y);
    }
    public static void main(String[] args) {
        //System.out.println(6>>1);
       // oddOrEven(3);
       // oddOrEven(2538);
        //System.out.println(clearIthBitsRange(10, 2, 4));
        //System.out.println(clearIthBits(15, 2));
        //System.out.println(setIthBit(1, 1));
        //System.out.println(fastExpo(2, 2));
        //System.out.println(~-3556);
        try{
            int a[]={2,3,4,5};
            for(int i=0 ; i<41 ;i++){
                System.out.println(a[i]);

            }
            
        }catch(Exception a){
            System.out.println("out of index");
            throw new ArrayIndexOutOfBoundsException("error hai ji ...");
            
        }finally{
            System.out.println("byee");
            
        }
    }
}
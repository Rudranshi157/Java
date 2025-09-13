
import java.util.Arrays;

public class RecursionBasics{
    public static void printDecs(int n){
        if(n<=1){
            System.out.println(n);
            return ;
        }
        System.out.print(n+ " ");
        printDecs(n-1);
    }
    public static void printAsc(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        printAsc(n-1);
        System.out.print(n+ " ");
    }
    public static boolean isSorted(int arr[] , int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr,i+1);
    }
    public static int tilePrblm(int n){
        if(n == 0 || n==1 ){
            return 1;
        }
        // //vertical ways
        // int v = tilePrblm(n-1);
        // //horizontal
        // int h = tilePrblm(n-2);
        // // retun totalways
        // return v+h;
        return tilePrblm(n-1)+ tilePrblm(n-2);
    }
    public static int firstOccurence(int arr[], int key , int i){
        
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOccurence(arr,key , i+1);
    }
    public static int lastOccurence(int arr[], int key , int i){
        
        if(i == arr.length){
            return -1;
        }
        int isFound =  lastOccurence(arr,key , i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static int power(int b , int n){
        if(n == 0){
            return 1;
        }
        return  b*power(b ,n-1);
    }
    public static int optimisedPower(int b ,int n){
        if(n==1){
            return b;
        }
        int halfPower = optimisedPower(b, n/2);
        int halfPowerSq = halfPower * halfPower;

        //n is odd
        if (n%2 != 0){
            halfPowerSq = b * halfPowerSq;
        }
        return halfPowerSq;
    }
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    public static void removeDuplicate(String str , StringBuilder newstr , int idx , boolean map[]){
        if(str.length() == idx){
            System.out.println(newstr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar- 'a']== true){
            removeDuplicate(str, newstr, idx+1, map);
        }else{
            map[currChar- 'a']=true;
            removeDuplicate(str, newstr.append(currChar), idx+1, map);
        }
    }
    public static int frndPairing(int n){
        if(n ==1 || n==2 || n==0 ){
            return n;
        }
        return frndPairing(n-1) + (n-1)*frndPairing(n-2);
    }
    public static void printBinString(int n, String str,int lastPlace){
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinString(n-1, str+"0", 0);
        if(lastPlace==0){
            printBinString(n-1, str+"1", 1);
        }
    }
    public static void towerOfHanoi(char src , char dest , char aux ,int n){
        //base
        if(n==0){
            return;
        }
        towerOfHanoi(src, aux, dest, n-1);
        System.out.println(n+"th  is move from "+src+" to "+dest);
        towerOfHanoi(aux, dest, src, n-1);
    }

        public static void convert(int n , int idx){
            String str[] = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
            if(n==0){
                return;
            }
            int lastDigit = n%10;
            convert(n/10, idx);
            System.out.print(str[lastDigit]+" ");
        }
    
    public static void printDigits(Integer num,int idx){
        if(num%10==0){
            System.out.println("Invalid input");
            return;
        }
        String numstr = num.toString();
        if(idx == numstr.length()){
            System.out.println();
            return;
        }
        String str[] = {"zero", "one","two","three","four","five","six","seven","eight","nine"};
        int t = numstr.charAt(idx)-'0';
        System.out.print(str[t]+" ");
        printDigits(num, idx+1);
    }
    public static void findKey(int arr[],int idx , int key){
        if(idx == arr.length){
            System.out.println();
            return;
        }
        if(arr[idx]==key){
            System.out.print(idx+" ");
        }
        findKey(arr, idx+1, key);
    }
    public static void stringLength(String str, int idx , StringBuilder sb){
        if(str.equals(sb.toString())){
            System.out.println(idx);
            return;
        }
        sb.append(str.charAt(idx));
        stringLength(str, idx+1, sb);
    }
    public static void contigiuosSubStr(String str , int idx , int count , int var){
        if(idx==str.length()-1){
            System.out.println(count);
            return;
        }
        char arr[]=str.toCharArray();
        Arrays.sort(arr);
        if(idx ==0){
            count++;
            var++;
        }
        if(arr[idx]==arr[idx+1]){
            var++;
            count+=var;
        }else{
            count++;
            var =1;
        }
        contigiuosSubStr(str, idx+1, count,var);
    }
    public static int cS(String str , int i ,int j , int n){
        if(n==1){
            return 1;
        }
        if(n<=0){
            return 0;
        }
        int res = cS(str, i+1, j, n-1)+ cS(str, i, j-1,n-1)-cS(str, i+1, j-1, n-2);
        if(str.charAt(1)==str.charAt(j)){
            res++;
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        //System.out.println(optimisedPower(2, 5));
        //removeDuplicate("aappnnacollege", new StringBuilder(""), 0,new boolean[26]);
        //printBinString(3, "", 0);
        //System.out.println(frndPairing(4));
        //findKey(arr, 0, 2);
        //convert(99075478, 0);
        //stringLength("hello,nx+_?<", 0, new StringBuilder());
        //printDigits(19470870, 0);
        //contigiuosSubStr("abcab", 0, 0,0);
        String st = "abcab";
        int n = st.length();
       // System.out.println(cS(st, 0, n-1, n));
       towerOfHanoi('A', 'C', 'B', 3);
    }
}
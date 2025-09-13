//ques 1 ---empty wings-----
// public class JavaBasics{
//     public static void main(String[] args) {
//         int n =5; 
//         for (int i= 1; i<=n ; i++){

//             System.out.print("*");
//             for (int j=2 ; j<i ; j++){
//                 System.out.print(" ");
//             }    
//             if(i>1){
//                 System.out.print("*");
//             }
//             for (int j=1 ; j<=n-i ; j++){
//                 System.out.print("  ");
//             }
//             System.out.print("*");
//             for (int l=2 ; l<i ; l++){
//                 System.out.print(" ");
//             }
//             if(i>1){
//             System.out.print("*");                 
//             }
//             System.out.println();    
        
//         }
    
//         for (int i= 1; i<=n ; i++){

//             System.out.print("*");
//             for (int j=2 ; j<=n-i ; j++){
//                 System.out.print(" ");
//             }    
//             if(i<5){
//                 System.out.print("*");
//             }
//             for (int j=1 ; j<i ; j++){
//                 System.out.print("  ");
//             }
//             System.out.print("*");
//             for (int l=2 ; l<=n-i ; l++){
//                 System.out.print(" ");
//             }    
//             if(i<5){
//                 System.out.print("*");                 
//             }
//             System.out.println();    
//         }
        
//     }
//     }
    
   


//------------------12345  pyramid-------------------
// public class JavaBasics{
//     public static void main(String[] args) {
//         int n = 5;
//         for (int i = 1 ; i<=n ; i++){
//             for(int j=1 ; j<=n-i ; j++){
//                 System.out.print(" ");
//             }
//             for(int j=1 ; j<=i ; j++){
//                 System.out.print(i+" ");
//             }
//             System.out.println();
//         }
//     }
// }
  
//----emp  parallgm-------
// public class JavaBasics{
//     public static void main(String[] args) {
//         int n=5;
//         for (int i=n ; i>0 ; i--){
//             for (int j=1 ; j<=i-1; j++) {
//                 System.out.print(" ");
//             }
//             System.out.print("*");
//             if(i==1 || i==n){
//                 for(int j=1 ; j<=3 ; j++){
//                     System.out.print("*");
//                 }
//             }
//             else{
//                 for (int j=1 ; j<=3 ; j++){
//                     System.out.print(" ");
//                 }
//             }
//             System.out.println("*");
//         }
//     }
// }    



// half pyramid------
//public class JavaBasics{
//     public static void main(String[] args) {
//         int n=5;
//         for(int i=1 ; i<=5 ; i++){
//             for(int j=n-i ; j>0 ; j--){
//                 System.out.print(" ");
//             }
//             for (int j=1 ; j<=i ; j++){
//                 System.out.print(j+" ");
//             }
//             System.out.println();
//         }
//     }
// }


//inverted pyramid----------
// public class JavaBasics{
//     public static void main(String[] args) {
//         int n=5;
//         for(int i=1 ; i<=n ; i++){
//             for(int j=1 ; j<i ; j++){
//                 System.out.print(" ");
//             }
//             for(int j=1 ; j<=n-i+1 ; j++){
//                 System.out.print(i+" ");
//             }
//             System.out.println();
//         }
//     }
// }



// import java.util.*;
// public class JavaBasics{
//     // public static int calculateSum(int a,int b){
//     //     int sum = a+b;
//     //     return sum;
//     // }
//     public static int calculateProduct(int a, int b){
//         return a*b ;
//     }
//     public static void main(String[] args) {
//         Scanner sc= new Scanner(System.in);
//         int a = sc.nextInt();
//         int b = sc.nextInt();
//         // int sum = calculateSum(a,b);
//         // System.out.println("sum "+sum);
//         System.out.println("product  "+ calculateProduct(a,b));
//     }
// }
  


/*import java.util.*;
public class JavaBasics{
    public static void calculateFactorial(int a){
        if(a<0){
            System.out.println("Invalid number");
            return;
        }
        int j = 1;
        for (int i=1 ; i<=a ; i++){
            j=j*i;
        }
        System.out.println(j);
        return;
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        calculateFactorial(a);
        
    }
    
}
*/  

import java.util.* ;
public class JavaBasics{
    public static void avgNum(int a,int b, int c){
        int avg = (a+b+c)/3;
        System.out.println(avg);
    }

    public static boolean isEven(int a) {
        return a%2 == 0;
    }

    public static void isPalindrome(int a) {
        int c=0;
        int b = a;
        int h;
        while(a>0){
            h = a%10;
            c = (c*10) + h;
            a = a/10;
        }
        if (b==c){
            System.out.println(b+" is a palindrome"); 
        }else{
            System.out.println(b+" is not a palindrome");
        }
    }

    public static void digSum(int a) {
        int c = 0;
        int d = a;
        int h ;
        //int d = c;
        while(a>0){
            h = a%10;
            c+=h;
            a = a/10;
        }

        System.out.println("sum of digits of  "+d+" is "+c);
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        // System.out.println("enter 3 no.");
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int c = sc.nextInt();
        // avgNum(a,b,c);
        System.out.println("enetr the no.");
        int n = sc.nextInt();
        //System.out.println(isEven(n));
        
        // isPalindrome(n);
        System.out.println("so here it is");
        digSum(n);
    }
}



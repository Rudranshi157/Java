public class BasicSorting{
    public static void bubblesort(int arr[]){
        
        int c = 0;
        for(int i = 0 ; i< arr.length-1 ; i++){
            if(arr[i]<arr[i+1]){
                c++;
            }
        }
        if(c==arr.length-1){
            System.out.println("Array is already sorted...");            
        }else{
            for (int i = 0 ; i< arr.length-1 ; i++){
            int swap = 0 ;
            for(int j = 0 ; j < arr.length - 1 - i ; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap+=1;
                }
            }System.out.println("swap no. : "+ swap);
        }
        
        }
    }

    public static void insertionSort(int a[]){
        for(int i=1 ; i<a.length; i++){
            int curr = a[i];
            int prev = i-1;
            while(prev>=0 && a[prev] > curr){
                a[prev+1] = a[prev];
                prev--;
            }
            a[prev +1] = curr;
        }
    }

    public static void printArray(int arr[]) {
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }


    public static void countingSort(int a[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0 ; i<a.length ; i++){
            largest = Math.max(largest, a[i]);
        }

        int count[] = new int[largest+1];
        for (int i = 0 ; i<a.length ; i++){
            count[a[i]]++;
        }

        int j=0;
        for(int i=0 ; i<count.length ; i++){
            while(count[i]>0){
                a[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void selectionSort(int arr[]){
        for(int i=0 ; i< arr.length-1 ; i++){
            int minPos = i;
            for(int j = i+1 ; j<arr.length ; j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

        
    
    public static void main(String[] args) {
        //int a[] = {5,4,1,3,2};
        //int a[] = {1,4,1,3,2,4,3,7};
        // int a[] = {3,6,2,1,8,7,4,5,3,1};
        // printArray(a);
        //insertionSort(a);
        //selectionSort(a);
        //bubblesort(a);
        //countingSort(a);
        //printArray(a);

        // a[2] = a[1];
        // a[1] = a[0];
        // a[0] = a[2];
        // printArray(a);

       
        

              
    
    }
}
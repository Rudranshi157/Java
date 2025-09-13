public class Matrices{

    public static void print2Darray(int arr[][]){
        for(int i =0 ; i<arr.length ; i++){
            for(int j = 0 ; j< arr[0].length ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //Q1-----no. of 7s------int array[][]={{4,7,8},{8,8,7}}--out=2
    public static void numOfTimes(int array[][] , int key){
        int times = 0;
        for(int i = 0 ; i<array.length ; i++){
            for(int j = 0 ; j<=array[0].length-1 ; j++){
                if(array[i][j] == key){
                    times++;
                }
            }
        }
        System.out.println("Numbers of times 7 comes"+ times);
    }


    //Q2-----2nd row no. sum  ----nums = {{1,4,9},{11,4,3},{2,2,3}}--out=18
    public static void rowSum(int nums[][] ,int  row){
        int sum=0;
        row--;
        for (int i =0; i<nums[row].length ;i++  ){
            sum+=nums[row][i];
        }
        System.out.println(sum);
    }

    //Q3-----wap to transpose of matrix---swapping of rows to cols---2*3matrix
    public static void transpose(int matrix[][]){
        int rows=matrix.length ,col=matrix[0].length;
        int transpose[][] = new int[col][rows];
        for(int i = 0 ; i<col ; i++){
            for(int j= 0 ; j<rows ; j++){
                transpose[i][j] = matrix[j][i];
            }
            
        }
        print2Darray(transpose);
        matrix=transpose;
        print2Darray(matrix);
    }

    
    public static void spiral(int matrix[][]){
        int startcol = 0 , startrow = 0;
        int endcol = matrix[0].length -1;
        int endrow = matrix.length-1;
        while(startrow<=endrow && startcol <= endcol){
            //top
            for(int i = startcol ; i<= endcol ; i++){
                System.out.print(matrix[startrow][i] + " ");
            }

            //right
            for(int i = startrow+1; i<=endrow ; i++){
                System.out.print(matrix[i][endcol]+" ");
            }

            //bottom
            for(int i = endcol-1 ; i>=startcol; i--){
                if(startcol == endcol){
                    break;
                }
                System.out.print(matrix[endrow][i] + " ");
            }

            //left
            for(int i = endrow-1 ; i>=startrow+1 ; i--){
                if(startrow == endrow){
                    break;
                }
                System.out.print(matrix[i][startcol] +" ");
            }
            startcol++;
            startrow++;
            endcol--;
            endrow--;
        } 
        System.out.println();
    }


    public static int diagonalSum(int matrix[][]){
        int sum = 0;
        for(int i= 0 ; i<matrix.length ; i++){
            sum += matrix[i][i];
            if(i != matrix.length-1-i){
                sum+=matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }

    public static boolean staircaseSearch(int matrix[][] , int key){
        int col = 0;
        int row =matrix.length-1;
        while(col<matrix[0].length && row>=0){
            if(matrix[row][col]==key){
                System.out.println("Found at row "+row +" and at column "+col+" .");
                return true;
            }
            else if (matrix[row][col] < key){
                col++;
            }else{
                row--;
            }
        }
        System.out.println("Not Found...");
        return false;
        
    }
    
    
    public static void main(String[] args) {

        //int array[][]={{4,7,8},{8,8,7}};
        //numOfTimes(array, 7);
      //  int nums[][] = {{1,4,9},{11,4,3},{2,2,3}};
        //System.out.println();
        //transpose(array);
        
        //int a[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       // print2Darray(a);
       // staircaseSearch(a, 11);        
}
}
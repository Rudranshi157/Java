public class Backtracking{
    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    public static void optimisedGridWays(int i , int j , int n,int m){
        int r1 = factorial(n-i-1);
        int r2 = factorial(m-j-1);
        int w = factorial(n-i-1+m-j-1);
        System.out.println(w/(r1*r2));
    }
    public static void changeArr(int arr[],int i){
        //Base Case
        if(i==arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i]=i+1;
        changeArr(arr, i+1);   //fxn call step
        arr[i]= arr[i]-2;      //backtracking step
    }
    
    public static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void findSubsets(String str , String ans , int i){
        //Base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }


        //Recursion
        //Choose yes
        findSubsets(str, ans+str.charAt(i), i+1);
        //Choose no
        findSubsets(str, ans, i+1);
    }
    public static void findPermutation(String str,String ans){
        //Base Case
        if(str.length()==0){
            System.out.println(ans);
            
        }
        //Recursion
        for(int i=0 ; i<str.length() ; i++){
            String Str = str.substring(0 , i)+str.substring(i+1);
            findPermutation(Str, ans+str.charAt(i));
        }
    }
    public static boolean isSafe(String board[][] , int row ,int col){
        //vertical
        for(int i=row-1 ; i>=0 ; i--){
            if(board[i][col]=="Q"){
                return false;
            }
        }
        //diagonal left
        for(int i=row-1 , j=col-1 ; i>=0&&j>=0 ; i--,j--){
            if(board[i][j]=="Q"){
                return false;
            }
        }
        //diagonal right
        for(int i=row-1, j=col+1 ; i>=0 && j<board[0].length ; i-- , j++){
            if(board[i][j]=="Q"){
                return false;
            }
        }
        return  true;
    }
    public static void nQueens(String board[][],int row ){
        //base case
        if(row==board.length){
            System.out.println("----------- chess board is here ----------");
            printBoard(board);
            count++;
            return;
        }
        //column loop
        
        for(int i=0 ; i<board.length ;i++){
            if(isSafe(board , row , i)){
                board[row][i]="Q";
                nQueens(board, row+1 );    //function call
                board[row][i]="X";        //backtracking step

            }
        }
    }
    public static boolean  isNQueensPossible(String board[][],int row ){
        //base case
        if(row==board.length){
            return true;
        }
        //column loop
        
        for(int i=0 ; i<board.length ;i++){
            if(isSafe(board , row , i)){
                board[row][i]="Q";
                if(isNQueensPossible(board, row+1 )){
                    return true;
                }   
                board[row][i]="X";        //backtracking step

            }
        }
        return false;
    }
    public static void printBoard(String board[][]){
        for(int i=0 ; i<board.length ; i++){
            for(int j=0 ; j<board.length ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int count =0;
    public static int gridWays(int i ,int j , int n , int m){
        //base case
        if(i==n-1 && j == m-1){     //last cell condition
            return 1;
        }else if(i==n ||j==m){      //boundry cross condition
            return 0;
        }

        return gridWays(i+1, j, n, m)+gridWays(i, j+1, n, m);
    }
    public static void printMatrix(int matrix[][]){
        for(int i=0 ; i<matrix.length ; i++){
            for(int j =0 ; j<matrix[0].length ; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static int mazes=0;
    public static void ratInMaze(int initial[][] , int output[][] , int i , int j){
        if(i==initial.length || j==initial[0].length){
            return;
        }else if(initial[i][j]==0){
            return;
        }
        output[i][j]=1;
        if(i==initial.length-1 && j==initial[0].length-1){
            printMatrix(output);
            mazes++;
            System.out.println();
            return;
        }
        ratInMaze(initial, output, i+1, j);
        ratInMaze(initial, output, i, j+1);
        output[i][j]=0;
    }
    public static void printSudoku(char sudoku[][]){
        for(int i=0 ; i<9 ; i++){
            // if(i==0){
            //     System.out.println("__________________");
            // }
            for(int j=0 ; j<9 ; j++){
                // if(j==0){
                //     System.out.print("|");
                // }
                System.out.print(sudoku[i][j]+" ");
                // if(j==2 || j==5 || j==8){
                //     System.out.print("|");
                // }
            }
            System.out.println();
            // if(i==2 || i ==5 || i==8){
            //     System.out.println("__________________");
            // }
        }
    }
    public static boolean isSudokuSafe(int sudoku[][] , int row ,int col , int digit){
        //row
        for(int i=0 ; i<9 ; i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //col
        for(int i = 0 ; i<9 ; i++){
            if(sudoku[row][i]==digit){
                return false;
            }
        }
        //grid
        int startCol=(col/3)*3 , startRow = (row/3)*3;
        for(int i=startRow ; i<startRow+3 ; i++){
            for(int j=startCol ; j<startCol+3 ; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][],int row , int col){
        //base
        if(row==9){
            return true;
        }
        //Recursion
        int nextRow = row ,nextCol = col+1;
        if(col+1==9){
            nextCol = 0 ;
            nextRow = row+1;
        }
        if(sudoku[row][col]!=0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit=1 ; digit<=9 ; digit++){
            if(isSudokuSafe(sudoku , row ,col , digit)){
                sudoku[row][col]=digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){   // solution exits 
                    return true;
                }
                sudoku[row][col]=0;
            }
        }
        return false;
    }
    public static void alphaPAirs(int start , String arr[]){
        String alpha[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
    }
    public static class alpha {
        
    }
    public static boolean isSafe(char[][] board, int r, int c,char digit){
        for(int i=0; i<board.length ; i++){
            if(board[r][i]==digit ){
                return false;
            }
        }
        for(int i=0; i<board.length; i++){
            if(board[i][c]==digit){
                return false;
            }
        }
        int n=(r/3)*3;
        int m=(c/3)*3;
        for(int i=n; i<n+3 ; i++){
            for(int j=m ; j<m+3 ; j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku(char[][] board, int r, int c){
        if(r==9){
            return true;
        }
        int nextRow=r;
        int nextCol=c+1;
        if(c+1==9){
            nextCol=0;
            nextRow=r+1;
        }
        if(board[r][c] != '.'){
            return sudoku(board,nextRow,nextCol);
        }
        for(char i='1' ; i<='9'; i++){
            if(isSafe(board,r,c,i)){
                board[r][c]= i;
                if(sudoku(board,nextRow, nextCol)){
                    return true;
                }
                board[r][c]='.';
            }
            
        }
        return false;
    } 
    public static void solveSudoku(char[][] board) {
        sudoku(board,0,0);
    }
    public static void main(String[] args) {
        //int arr[]=new int[5];
        //changeArr(arr,0);
        //printArr(arr);
        //findSubsets("abc", "", 0);
        //findPermutation("abc","");

        //---------------------nQueens------------------
        // int n = 10;
        // String arr[][]= new String[n][n];
        // for(int i=0 ; i<arr.length ; i++){
        //     for(int j = 0 ; j<arr[0].length ; j++){
        //         arr[i][j]="X";
        //     }
        // }
        // if(isNQueensPossible(arr, 0)){
        //     System.out.println("Solution is possible");
        //     printBoard(arr);
        // }else{
        //     System.out.println("Solution is not possible");
        //     printBoard(arr);
        // }
        //printBoard(arr);
        //nQueens(arr, 0);
        //System.out.println("total ways to solve nQueens : "+count);
        //---------------------------------------------------
        //System.out.println(gridWays(0, 0, 2, 3));
        //optimisedGridWays(0, 0, 2, 3);
        //----------------------------sudoku-------------------------

        int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3}};
        int u[][] = {{0,3,0,4,0,6,0,0,1},
        {1,0,2,0,0,0,4,9,0},{0,0,5,8,1,0,0,0,3},{0,1,0,0,9,4,7,0,0},{2,0,0,0,0,7,0,3,0},
        {0,0,3,5,0,0,1,0,0},{9,0,0,6,0,5,0,1,2},{0,5,0,0,0,0,9,0,0},{3,0,1,0,7,0,0,5,4}};
        //printSudoku(u);
        // if(sudokuSolver(u, 0, 0)){
        //     System.out.println();
        //     System.out.println("Solution exists...");
        //     printSudoku(u);
        // }else{
        //     System.out.println("Solution not exists...");
        //     printSudoku(u);
        // }
        char a[][]={
    {'5','3','.','.','7','.','.','.','.'},
    {'6','.','.','1','9','5','.','.','.'},
    {'.','9','8','.','.','.','.','6','.'},
    {'8','.','.','.','6','.','.','.','3'},
    {'4','.','.','8','.','3','.','.','1'},
    {'7','.','.','.','2','.','.','.','6'},
    {'.','6','.','.','.','.','2','8','.'},
    {'.','.','.','4','1','9','.','.','5'},
    {'.','.','.','.','8','.','.','7','9'}
};
        solveSudoku(a);
        printSudoku(a);
        
        // int r[][]={{1,1,1,1},{0,1,0,1},{1,1,1,1},{1,0,1,1}};
        // printMatrix(r);
        // System.out.println();
        // int out[][] = new int[4][4];
        // ratInMaze(r, out, 0,0);
        // System.out.println("No. of possible ways : "+mazes);
        
    }
}    


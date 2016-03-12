//importing libraries
import java.util.Scanner;
import java.util.Random;
 
//strassen algorithm
public class strassenMultiplier{

    //multiplication method
    public int[][] multiply(int[][] A, int[][] B){        
        
        //getting matrix size
        int n = A.length;

        //declaring result array
        int[][] resultArray = new int[n][n];

        //if order is 1x1
        if (n == 1)
            resultArray[0][0] = A[0][0] * B[0][0];
        
        //if order is other than 1x1
        else{

            //declaring partial array
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            //splitting matrix A in four halves
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);

            //splitting matrix B in four halves
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            //multiplying partial arrays
            int [][] M1 = multiply(add(A11, A22), add(B11, B22));
            int [][] M2 = multiply(add(A21, A22), B11);
            int [][] M3 = multiply(A11, sub(B12, B22));
            int [][] M4 = multiply(A22, sub(B21, B11));
            int [][] M5 = multiply(add(A11, A12), B22);
            int [][] M6 = multiply(sub(A21, A11), add(B11, B12));
            int [][] M7 = multiply(sub(A12, A22), add(B21, B22));
 
            //performing addition/subtraction on partial arrays
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            //joining partial arrays
            join(C11, resultArray, 0 , 0);
            join(C12, resultArray, 0 , n/2);
            join(C21, resultArray, n/2, 0);
            join(C22, resultArray, n/2, n/2);
        }
    
        //returning result
        return resultArray;
    }

    //subtraction method
    public int[][] sub(int[][] A, int[][] B){

        //getting matrix order
        int n = A.length;

        //declaring partial array
        int[][] C = new int[n][n];

        //subtracting splitted array
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];

        //returing partial array 
        return C;
    }

    //addition method
    public int[][] add(int[][] A, int[][] B){

        //getting matrix order
        int n = A.length;

        //declaring partial array
        int[][] C = new int[n][n];

        //adding splitted array
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];

        //returing partial array    
        return C;
    }

    //splitting parent matrix into child matrices
    public void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    
    //joining child matrices into parent matrix
    public void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    

}
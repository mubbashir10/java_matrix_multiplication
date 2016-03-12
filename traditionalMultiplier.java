//importing libraries
import java.util.Scanner;
import java.util.Random;

//traditional algorithm
public class traditionalMultiplier{

    //traditional multiplication     
    public int [][] traditionalMultiply(int A[][], int B[][], int matrixOrder){

        //declaring variables and array
        int sum = 0;
        int[][] result= new int[matrixOrder][matrixOrder];

        for(int i=0; i<matrixOrder; i++){
            for(int j=0; j<matrixOrder; j++){
                for(int k=0; k<matrixOrder; k++){
                    sum = sum + A[i][k]*B[k][j];
                }
                //apending result
                result[i][j]=sum;
                //resetting sum
                sum=0;
            }
        }

        //returning result
        return result;
    }
     
}
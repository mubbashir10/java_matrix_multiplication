//importing libraries
import java.util.Scanner;
import java.util.Random;


//multiplier
public class matrixMultiplier{

	public static void main(String args[]){

        //defining matrix min and max value
        int min = 0;
        int max = 10;

        //making object of scanner class
        Scanner userInput = new Scanner(System.in);

        //making object of random class
        Random randNum = new Random();

        //making object of traditionalMultiplier class 
        traditionalMultiplier tmObj = new traditionalMultiplier();

        //making object of matrixMultiplier class 
        strassenMultiplier smObj = new strassenMultiplier();
        
        //getting matrix order
        System.out.println("Enter the order of matrix (e.g 4 for 4x4):");
        int matrixOrder = userInput.nextInt();

        //declaring arrays
        int[][] A = new int[matrixOrder][matrixOrder]; 
        int[][] B = new int[matrixOrder][matrixOrder]; 
             
        //filling matrix A array
        for (int i = 0; i < matrixOrder; i++)
            for (int j = 0; j < matrixOrder; j++)
                A[i][j] = randNum.nextInt((max - min) + 1) + min;
 
        //filling matrix B array
        for (int i = 0; i < matrixOrder; i++)
            for (int j = 0; j < matrixOrder; j++)
                B[i][j] = randNum.nextInt((max - min) + 1) + min;

        //printing matrix A
        System.out.println("\nMatrix A: ");
        for (int i = 0; i < matrixOrder; i++){
            for (int j = 0; j < matrixOrder; j++)
                System.out.print(A[i][j] +" ");
            //printing new line
            System.out.println();
        }

        //printing matrix B
        System.out.println("\nMatrix B: ");
        for (int i = 0; i < matrixOrder; i++){
            for (int j = 0; j < matrixOrder; j++)
                System.out.print(B[i][j] +" ");
            //printing new line
            System.out.println();
        }

        //calling traditional multiplication method
        int[][] resultA = tmObj.traditionalMultiply(A, B, matrixOrder);

        //calling strassen multiplication method
        int[][] resultB = smObj.multiply(A, B);

        //printing using traditional
        System.out.println("\nProduct of matrices A and  B (using Traditional Algorithm): ");
        for(int i=0; i<matrixOrder; i++){

            for(int j=0; j<matrixOrder; j++){

                System.out.print(resultA[i][j]+"\t");
            }
            System.out.println();
        }

        //printing using strassen
        System.out.println("\nProduct of matrices A and  B (using Strassen Algorithm): ");
        for (int i = 0; i < matrixOrder; i++){

            //printing 2d result array
            for (int j = 0; j < matrixOrder; j++)
                System.out.print(resultB[i][j] +" ");
            
            //printing new line
            System.out.println();
        }
    }    
}
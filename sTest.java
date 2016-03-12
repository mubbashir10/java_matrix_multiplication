//importing libraries
import org.junit.Test;
import static org.junit.Assert.*;

//tTest class
public class sTest {

    @Test
    public void strassenTest() {

        //making object
        strassenMultiplier sm = new strassenMultiplier();

        //input
        int matA[][] = new int[2][2];
        matA[0][0]=4;
        matA[0][1]=4;
        matA[1][0]=6;
        matA[1][1]=4;
        int[][] matB =  new int[2][2];
        matB[0][0]=2;
        matB[0][1]=2;
        matB[1][0]=5;
        matB[1][1]=8;

        //result
        int result[][] = new int[2][2];
        result[0][0]=28;
        result[0][1]=40;
        result[1][0]=32;
        result[1][1]=44;

        //testing
        assertEquals(result, sm.multiply(matA,matB));

    }
}
//DO NOT CHANGE ANY CODE IN THIS FILE
//YOU DO NOT HAVE TO SUBMIT THIS FILE. IT IS MEANT FOR TESTING OF YOUR CODE
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

public class MatrixMultiplicationTest {

    @Test
    public void testMatrixMul1() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,2,3},
					    {3,1,2},
					    {2,3,1}
						};

		int[][] answer = {
					    {559845,559845,559926},
					    {559926,559845,559845},
					    {559845,559926,559845}
						};		
		m.counter=0;
		int power = 8;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertEquals(m.counter,3);
    }

    @Test
    public void testMatrixMul2() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {2,4,3,1},
					    {3,1,4,2},
					    {4,6,5,3},
					    {6,2,4,1}
						};

		int[][] answer = {
					    {74630,75352,86627,40639},
					    {79675,80413,92506,43394},
					    {133992,135322,155513,72949},
					    {95722,96590,111172,52153}
						};		
		m.counter=0;
		int power = 5;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertEquals(m.counter,3);
    }

	@Test
    public void testMatrixMul3() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,2},
					    {2,1}
						};

		int[][] answer = {
					    {29525,29524},
					    {29524,29525}
						};		
		m.counter=0;
		int power = 10;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertEquals(m.counter,4);
    }

    @Test
    public void testMatrixMul4() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,2,1,2,1,2},
					    {2,1,2,1,2,1},
					    {1,2,1,2,1,2},
					    {2,1,2,1,2,1},
					    {1,2,1,2,1,2},
					    {2,1,2,1,2,1}
						};

		int[][] answer = {
					    {1107,1080,1107,1080,1107,1080},
					    {1080,1107,1080,1107,1080,1107},
					    {1107,1080,1107,1080,1107,1080},
					    {1080,1107,1080,1107,1080,1107},
					    {1107,1080,1107,1080,1107,1080},
					    {1080,1107,1080,1107,1080,1107}
						};		
		m.counter=0;
		int power = 4;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertEquals(m.counter,2);
	}

	@Test
    public void testMatrixMul5() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,2,3},
					 	{3,2,1},
					 	{2,1,3}
						};

		int[][] answer = {
					    {90560,74104,115272},
					    {90576,74104,115256},
					    {90568,74096,115272}
						};		
		m.counter=0;
		int power = 7;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertEquals(m.counter,3);
	}	   
}
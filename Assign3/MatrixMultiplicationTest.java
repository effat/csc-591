
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
        assertTrue(m.counter<=6);
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
        assertTrue(m.counter<=6);
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
        assertTrue(m.counter<=8);
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
        assertTrue(m.counter<=4);
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
        assertTrue(m.counter<=6);
	}

	@Test
    public void testMatrixMul6() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,0,0},
					 	{0,-1,0},
					 	{0,0,1}
						};

		int[][] answer = {
					    {1,0,0},
					 	{0,-1,0},
					 	{0,0,1}
						};		
		m.counter=0;
		int power = 85;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=14);
	}

	@Test
    public void testMatrixMul7() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {0,0,0,1},
					 	{0,0,-1,0},
					 	{0,1,0,0},
					 	{-1,0,0,0}
						};

		int[][] answer = {
					    {0,0,0,-1},
					 	{0,0,1,0},
					 	{0,-1,0,0},
					 	{1,0,0,0}
						};		
		m.counter=0;
		int power = 99;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=14);
	}

	@Test
    public void testMatrixMul8() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,0,0},
					 	{0,-1,0},
					 	{0,0,1}
						};

		int[][] answer = {
					    {1,0,0},
					 	{0,1,0},
					 	{0,0,1}
						};		
		m.counter=0;
		int power = 64;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=12);
	}

	@Test
    public void testMatrixMul9() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
					    {1,0,0,0,0,0,0,0},
					 	{0,-1,0,0,0,0,0,0},
					 	{0,0,1,0,0,0,0,0},
					 	{0,0,0,-1,0,0,0,0},
					 	{0,0,0,0,1,0,0,0},
					 	{0,0,0,0,0,-1,0,0},
					 	{0,0,0,0,0,0,1,0},
					 	{0,0,0,0,0,0,0,-1}
						};

		int[][] answer = {
					    {1,0,0,0,0,0,0,0},
					 	{0,1,0,0,0,0,0,0},
					 	{0,0,1,0,0,0,0,0},
					 	{0,0,0,1,0,0,0,0},
					 	{0,0,0,0,1,0,0,0},
					 	{0,0,0,0,0,1,0,0},
					 	{0,0,0,0,0,0,1,0},
					 	{0,0,0,0,0,0,0,1}
						};		
		m.counter=0;
		int power = 48;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=12);
	}	
	
	@Test
    public void testMatrixMul10() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		{1, 3, 5, 6},
			    {9, 3, 5, 7},
			    {8, 7, 9, 11},
			    {2, 3, 6, 0}
						};

		int[][] answer = {
					    {35229, 30095, 46535, 42924},
					 	{49745, 42451, 65518, 61022 },
					 	{77612, 66171, 102160, 94776 },
					 	{31948, 27031, 41515, 39009 }
					 	
						};		
		m.counter=0;
		int power = 4;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=4);
	}
	
	@Test
    public void testMatrixMul11() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
			        		{1, 3, 5},
						    {3, 5, 7},
						    {7, 9, 11}
						};

		int[][] answer = {
					    {102881169, 150716907, 198552645},
					 	{159490607, 233647445, 307804283  },
					 	{272709483, 399508521, 526307559 }
					 	
					 	
						};		
		m.counter=0;
		int power = 7;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=6);
	}		
	
	@Test
    public void testMatrixMul12() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
			        		{1, 1, 2},
						    {2, 5, 1},
						    {0, 1, 1}
						};

		int[][] answer = {
					    {130811, 313870, 119925},
					 	{443080, 1063136, 406200 },
					 	{92330, 221540, 84646 }
					 	
					 	
						};		
		m.counter=0;
		int power = 8;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=6);
	}		
	
	
	@Test
    public void testMatrixMul13() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		{1, 0,0,0,1},
			 	  {0, 0,0,0,3},
			 	  {0, 0,0,3,0},
			 	  {1, 0,0,0,0},
			 	 {0, 1,0,0,0}, 
				};

		int[][] answer = {
				{1, 797161, 0, 0, 797161 },
			 	  {0, 1594323, 0,0, 0 },
			 	  { 3, 797160, 0, 0, 797160 },
			 	  {1, 265720, 0, 0, 797161},
			 	 { 0, 0, 0, 0, 1594323 }, 
					 	
						};		
		m.counter=0;
		int power = 26;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=10);
	}		
	
	@Test
    public void testMatrixMul14() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		     {0,0,0,0,0,0,0,1},
				 	 {0,0,0,0,0,0,-1,0},
				 	 {0,0,0,0,0,1,0,0},
				 	 {0,0,0,0,-1,0,0,0},
				 	 {0,0,0,1,0,0,0,0},
				 	 {0,0,1,0,0,0,0,0},
				 	 {0,-1,0,0,0,0,0,0},
				 	 {1,0,0,0,0,0,0,0}
						};

		int[][] answer = {
				  {0,0,0,0,0,0,0,1},
				 	 {0,0,0,0,0,0,-1,0},
				 	 {0,0,0,0,0,1,0,0},
				 	 {0,0,0,0,-1,0,0,0},
				 	 {0,0,0,1,0,0,0,0},
				 	 {0,0,1,0,0,0,0,0},
				 	 {0,-1,0,0,0,0,0,0},
				 	 {1,0,0,0,0,0,0,0}
					 	
					 	
						};		
		m.counter=0;
		int power = 75;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=14);
	}		
	
	@Test
    public void testMatrixMul15() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		  {0,0,0,1},
				 	 {0,0,1,1},
				 	 {0,1,1,1},
				 	 {1,1,1,1}
				 	 
						};

		int[][] answer = {
				  {2037, 3828, 5157, 5864 },
				 	 {3828, 7194, 9692, 11021},
				 	 {5157, 9692, 13058, 14849},
				 	 {5864, 11021, 14849, 16886 }
				 	 
					 	
					 	
						};		
		m.counter=0;
		int power = 10;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=8);
	}	
	
	@Test
    public void testMatrixMul16() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		 {0,0,0,1},
			 	 {0,0,0,1},
			 	 {9,0,0,1},
			 	 {9,0,0,1}
				 	 
						};

		int[][] answer = {
				  {442431, 0, 0 , 185329},
				 	 { 442431, 0, 0, 185329 },
				 	 {1667961, 0, 0, 627760 },
				 	 {1667961, 0, 0, 627760 }
				 	 
					 	
					 	
						};		
		m.counter=0;
		int power = 11;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=8);
	}	
	
	@Test
    public void testMatrixMul17() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
		        		{0,0,0,0, 1},
					 	  {0,0,0,2, 0},
					 	  {0,0,1,0, 0},
					 	  {1,0,0,1, 0},
					 	 {1,0,1,0, 1} 
				 	 
						};

		int[][] answer = {
				{4181, 0, 10945, 0, 6765 },
			 	  {8362, 0, 21852, 2, 13528 },
			 	  { 0, 0, 1, 0, 0 },
			 	  {6765, 0, 17690, 1, 10945},
			 	 {6765, 0, 17710, 0, 10946} 
					 	
					 	
						};		
		m.counter=0;
		int power = 20;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=10);
	}	
	
	@Test
    public void testMatrixMul18() {
        MatrixMultiplication m = new MatrixMultiplication();
        int[][] matrix = {
        		 {0, 0,0,0,0, 3},
			 	  {0, 0,0,0,3, 0},
			 	  {0, 0,0,3,0, 0},
			 	  {4, 0,0,0,0, 0},
			 	 {0, 4,0,0,0, 0}, 
			 	 {0, 0,4,0,0, 0}
				 	 
						};

		int[][] answer = {
				 {429981696, 0,0,0,0, 0},
			 	  {0, 429981696,0,0,0, 0},
			 	  {0, 0,429981696,0,0, 0},
			 	  {0, 0,0,429981696,0, 0},
			 	 {0, 0,0,0,429981696, 0}, 
			 	 {0, 0,0,0,0, 429981696}
					 	
					 	
						};		
		m.counter=0;
		int power = 16;
        assertTrue(Arrays.deepEquals(m.Call_multiplier(matrix,power),answer));
        assertTrue(m.counter<=8);
	}	
}

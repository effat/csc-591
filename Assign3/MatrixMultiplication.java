//DO NOT CHANGE ANY EXISTING CODE IN THIS FILE
//DO NOT CHANGE THE NAMES OF ANY EXISTING FUNCTIONS
public class MatrixMultiplication{
	public static int counter = 0;

	public static int[][] Call_multiplier(int[][] matrix,int power){
		 //Write your code here to call Multiply_matrices lg(power) times.
		 //This method will have the 2-dimensional array and an int which specifies the power as inputs(Please see testcase file)
		 //This method should return the final matrice
		
		//create temp identity matrix
		int[][] temp = new int[matrix.length][matrix.length];			//given square matrix
		//initialize elements of identity matrix
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(i == j)
					temp[i][j] = 1;
				else
					temp[i][j] = 0;
			}
		}
		
		//implementation for matrix exponentiation
		while (power > 1) {
	        if(power % 2 != 0){
	        	temp = Multiply_matrices(temp, matrix);
	        	power--;
	        }
	        matrix = Multiply_matrices(matrix, matrix);
	        power = power/2;
	    }
		return Multiply_matrices(temp, matrix);
	}

	public static int[][] Multiply_matrices(int[][] a,int[][] b){
		counter+=1;
		 //Write code here to multiply 2 matrices and return the resultant matrice
		int size = a.length;
		
		int[][] result = new int[size][size];
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				for(int k = 0; k < size; k++)
					result[i][j] += a[i][k]*b[k][j];
			}
		}
		
		return result;
	}
}
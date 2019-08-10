package homeWork;

import java.util.Random;

public class Matrix{
	private double[][] matrix;
	
	public Matrix(){
		createMaxrix();
	}
	
	public double[][] getMatrix() {
		return matrix;
	}

	public void createMaxrix(){
		int value;
		matrix=new double[50][50];
		Random randomGenerator=new Random();
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				value=randomGenerator.nextInt(10);
				matrix[i][j]=(double)value;
			}
		}
	}
}

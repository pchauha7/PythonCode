package test.mywork;

public class MatrixMultiplication {
	
	static int MAX = Integer.MAX_VALUE;
	
	public static int matrixMultiplyRecursive(int Arr[], int stIndx, int lstIndx) {
		
		if (stIndx == lstIndx)
			return 0;
		
		int count = MAX;
		
		for (int i=stIndx; i<lstIndx; i++) {
			int res = matrixMultiplyRecursive(Arr, stIndx, i) + matrixMultiplyRecursive(Arr, i+1, lstIndx) + Arr[stIndx-1]*Arr[i]*Arr[lstIndx];
			if (res < count)
				count = res;
		}
		
		return count;
	}
	
	public static int matrixMultiplyDP(int Arr[]) {
		
		int l = Arr.length;
		
		int DPArray[][] = new int[l][l];
		String Pattern[][] = new String[l][l];
		
		//For only one matrix in the input
		for (int i=1; i<l; i++) {
			DPArray[i][i] = 0;
			Pattern[i][i] = Integer.toString(i);
		}
		
		
		
		//For more than one Matrix 
		/*
		 * C= matrix count
		 * i = start matrix index
		 * j = end matrix index
		 */
		for (int C=2; C<l;C++) {
			for (int i=1; i <= l-C; i++) {
				//x=i;
				int j = i+C -1;
					if (j<l) {
						DPArray[i][j] = MAX;
						for (int k = i; k<j; k++) {
							int res = DPArray[i][k] + DPArray[k+1][j] + Arr[i-1]*Arr[k]*Arr[j];
							if (DPArray[i][j] > res) {
								DPArray[i][j] = res;
								Pattern[i][j] = "(";
								if (DPArray[i][k]==0)
									Pattern[i][j] = Pattern[i][j] + i;
								else
									Pattern[i][j] = Pattern[i][j] + Pattern[i][k];
								if (DPArray[k+1][j]==0)
									Pattern[i][j] = Pattern[i][j] + j;
								else
									Pattern[i][j] = Pattern[i][j] + Pattern[k+1][j];
								
								Pattern[i][j] = Pattern[i][j] + ")";		
								
							}
						}
					
					}
			}
		}
		System.out.println(Pattern[1][l-1]);
		return DPArray[1][l-1];
	}

	
	
	

	public static void main(String[] args) {
		
		//Assuming that dimensions are in sequence as per the book
		//Here, there are 6 Matrix :- 5x10 10x3 3x12 12x5 5x50 50x6
		//int matrixDimension[] = {5,10,3,12,5,50,6};
		
		int matrixDimension[] = {3,2,4,7,5,9,6,8,10,12,11};
		
	//	int matrixCount = matrixMultiplyRecursive(matrixDimension, 1, 6);
		int matrixCount=matrixMultiplyDP(matrixDimension);
		System.out.println("Minimum number of calculations: " + matrixCount);
		
			
	}

}

package test.mywork;

import java.util.ArrayList;
import java.util.List;

public class MatchingRegions {
	
	
	private static boolean isSafe(int M[][], int row, int col, 
                   boolean visited[][]) 
    { 
    	int ROW = M.length;
    	int COL = M[0].length;
    	//System.out.println("ROW "+ ROW + "COL " + COL);
        return (row >= 0) && (row < ROW) && 
               (col >= 0) && (col < COL) && 
               (M[row][col]==1 && !visited[row][col]); 
    } 
  
 
    private static void DFS(int M[][], int row, int col, boolean visited[][],boolean visitedM[][]) 
    { 
        int rowNbr[] = new int[] { -1,  0, 0, 1}; 
        int colNbr[] = new int[] {  0, -1, 1, 0}; 
  
        visited[row][col] = true; 
        visitedM[row][col] = true;
        for (int k = 0; k < 4; ++k) 
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visitedM) ) 
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, visitedM); 
    }
    
    public static int countMatches(List<String> grid1, List<String> grid2) {
    	int row = grid1.size();
    	int col = grid1.get(0).length();
    	int count =0;
    	
    	int grd1[][] = new int[row][col];
    	int grd2[][] = new int[row][col];
    	for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
            	if (grid1.get(i).charAt(j)=='1')
            		grd1[i][j]=1;
            	if (grid2.get(i).charAt(j)=='1')
            		grd2[i][j]=1;
            }
    	}
    	boolean visited[][] = new boolean[row][col];
    	boolean visitedgrd1[][] = new boolean[row][col];
    	boolean visitedgrd2[][] = new boolean[row][col];
    	
    	for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
            	if(grd1[i][j]==1 && grd2[i][j]==1 && !visited[i][j]) {
            		DFS(grd1, i, j, visited, visitedgrd1);
            		DFS(grd2, i, j, visited, visitedgrd2);
            		if (sameRegion(visitedgrd1, visitedgrd2))
            			count++;
            		nullifyVisit(visitedgrd1);
            		nullifyVisit(visitedgrd2);
            	}
            }
    	}
    	
    	return count;
    }
  
    private static void nullifyVisit(boolean[][] visitedgrd1) {
    	
    	for(int i=0; i<visitedgrd1.length; i++) {
    		for (int j=0; j<visitedgrd1[0].length;j++) {
    			visitedgrd1[i][j]=false;
    		}
    	}
		
	}


	private static boolean sameRegion(boolean[][] visitedgrd1, boolean[][] visitedgrd2) {
    	
    	for(int i=0; i<visitedgrd1.length; i++) {
    		for (int j=0; j<visitedgrd1[0].length;j++) {
    			if (visitedgrd1[i][j]!=visitedgrd2[i][j])
    				return false;
    		}
    	}
		
		return true;
	}


  
    // Driver method 
    public static void main (String[] args) throws java.lang.Exception 
    { 
    	
    	List<String> grid1 = new ArrayList<String>() { 
            { 
                add("111"); 
                add("100"); 
                add("100"); 
            } 
        };
        List<String> grid2 = new ArrayList<String>() { 
            { 
            	add("111"); 
                add("100"); 
                add("101");  
            } 
        };
        
        int x = countMatches(grid1, grid2);
        
        System.out.println("No. of matching reions = "+x);
    } 
}


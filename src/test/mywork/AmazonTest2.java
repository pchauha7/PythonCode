package test.mywork;
import java.util.*;
public class AmazonTest2 {
	static int distance = 0;
	
	static void updatedMinDistance(int numRows, int numColumns, List<List<Integer>> Area, boolean Visited[][]) {
		
	}
	static int minimumDistance(int numRows, int numColumns, List<List<Integer>> Area) {
		
		
		boolean Visited[][] = new boolean[numRows][numColumns];
		
		Visited[0][0] = true;
		
		updatedMinDistance (numRows,numColumns, Area, Visited);
		
		Area.get(0).get(0);
		
		
		return distance;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

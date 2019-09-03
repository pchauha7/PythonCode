package test.mywork;

import java.util.*; 

class KnightProblem 
{ 

	static int minimumGroups(List<Integer> predators) {
		
		int n = predators.size();
		if (n==0)
			return 0;
		//boolean visit[] = new boolean[n];
		
		int count=0;
		Vector<Integer> q = new Vector<>();
//		for (int i = 0; i < n; i++)  
//			visit[i] = false;
		
		for (int i = 0; i < n; i++) {
			if (predators.get(i)==-1) {
				q.add(i);
				//visit[i]=true;
			}
		}
		
		while(!q.isEmpty()) {
			count++;
			Vector<Integer> children = new Vector<>();
			for (int i=0; i<q.size(); i++) {
				for (int j = 0; j < n; j++) {
					if (predators.get(j)== q.get(i)) {
						children.add(j);
						//visit[j]=true;
					}
			}
				
		}
		System.out.println("Mainq "+ q);
		System.out.println("tmpq "+children);
		q =children;	
		}
		
//		for (int i = 0; i < n; i++)
//			if (visit[i]==false) {
//				count++;
//				break;
//			}
				
		
		
		return count;
	}
	
	
static class cell  
{  
 int x, y;  
 int dis;  

     public cell(int x, int y, int dis) 
     { 
         this.x = x; 
         this.y = y; 
         this.dis = dis; 
     } 
   
} 

 
static boolean isInside(int x, int y, int N)  
{  
 if (x >= 0 && x < N && y >= 0 && y < N)  
     return true;  
 return false;  
}  

static int minMoves(int n, int startX, int startY, int endX, int endY)  
{  
	int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};  
	int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1}; 
	
	Vector<cell> q = new Vector<>();  
	
	q.add(new cell(startX, startY, 0));  
	
	cell t ;  
	int x, y;  
	boolean visit[][] = new boolean[n][n];  
	  
	for (int i = 0; i < n; i++)  
		for (int j = 0; j < n; j++)  
			visit[i][j] = false;  
	  
	visit[startX][startY] = true;  

 
	while (!q.isEmpty())  
	{  
	t = q.firstElement();  
	q.remove(0);  
	
	if (t.x == endX && t.y == endY)  
		return t.dis;  
	
	  
		for (int i = 0; i < 8; i++)  
		{  
		x = t.x + dx[i];  
		y = t.y + dy[i];  
		
		
			if (isInside(x, y, n) && !visit[x][y]) 
			{  
				visit[x][y] = true;  
				q.add(new cell(x, y, t.dis + 1));  
			}  
		}  
	}  
	return Integer.MAX_VALUE; 
}  

public static void main(String[] args)  
{ 
 int N = 30;  
 int knightPos[] = {1, 1};  
 int targetPos[] = {30, 30}; 
     //System.out.println(minStepToReachTarget(knightPos, targetPos, N)); 
// System.out.println(minMoves(10, 0, 0, 0, 2));
 List <Integer> l = new ArrayList<Integer>();
 l.add(-1);
 l.add(8);
 l.add(6);
 l.add(0);
 l.add(7);
 l.add(3);
 l.add(8);
 l.add(9);
 l.add(-1);
 l.add(6);
 System.out.println(minimumGroups(l));
 } 
} 

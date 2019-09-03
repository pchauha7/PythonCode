package test.mywork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DijikstraPathTest {
	
	private static int GRAPHSIZE = 50;
    private static int INFINITY = 999999;
    private static int destn = -1;
    private static int source = -1;
    private static int ArrayListIterator = 0;
    private static ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
    
    public static int Max(int a, int b) {
        return (a > b) ? a : b;
    }
	
    static void printD(long d[], int n, int dest) {
        
            System.out.println( d[dest]);
      
    }
    
 
    static void printPath(int prev[][], int dest, int arr[], int idx) {
    	int i, j;
    	arr[idx] = dest;
    	for (i = 1; i <= prev[dest][0]; ++i) {
    		if(prev[dest][i] == source) {
    			ArrayList<Integer> nextList = new ArrayList<Integer>();
    			listOfList.add(nextList);
        		for(j=0; j <= idx && arr[j] != -1; ++j) {	
        			listOfList.get(ArrayListIterator).add(arr[j]);
        		}
    			listOfList.get(ArrayListIterator).add(source);
    			Collections.reverse(listOfList.get(ArrayListIterator));
//    			for (j=0; j<listOfList.get(ArrayListIterator).size(); j++)
//    				System.out.print(listOfList.get(ArrayListIterator).get(j)+ " ");
//    			System.out.println();
    			ArrayListIterator++;
        	}
    		printPath(prev, prev[dest][i], arr, idx+1);
    	}
    }
	
   static void dijkstra(int prev[][], long dist[][], long d[], int s, int n) {
        int i, k, mini;
        int visited[] = new int [GRAPHSIZE];
    
        for (i = 0; i <= n; ++i) {
            d[i] = INFINITY;
            prev[i][0] = 0; /* no path has yet been found to i */
            visited[i] = 0; /* the i-th element has not yet been visited */
        }
    
        d[s] = 0;
        for (k = 0; k <= n; ++k) {
            mini = -1;
            for (i = 0; i <= n; ++i)
                if (visited[i] == 0 && ((mini == -1) || (d[i] < d[mini])))
                    mini = i;
    
            visited[mini] = 1;
    
            for (i = 0; i <= n; ++i)
                if (dist[mini][i] != 0) {
                    if (d[mini] + dist[mini][i] < d[i]) { /* a shorter path has been found */
                        d[i] = d[mini] + dist[mini][i];
                        prev[i][0] = 1;
                        prev[i][1] = mini;
                    } else if (d[mini] + dist[mini][i] == d[i]) { /* a path of the same length has been found */
                        ++prev[i][0];
                        prev[i][prev[i][0]] = mini;
                    }
                } 
        }
        System.out.print("");
    }

	public static void main(String[] s) {
		
		//int e; /* The number of nonzero edges in the graph */
	    int n; /* The number of nodes in the graph */
	    long dist[][] = new long[GRAPHSIZE][GRAPHSIZE]; /* dist[i][j] is the distance between node i and j; or 0 if there is no direct connection */
	    long d[] = new long[GRAPHSIZE]; /* d[i] is the length of the shortest path between the source (s) and node i */
	    int prev[][] = new int[GRAPHSIZE][GRAPHSIZE + 1]; /* prev[i] holds the nodes that could comes right before i in the shortest path from the source to i;
	                                    prev[i][0] is the number of nodes and prev[i][1..] are the nodes */
	    
	    
		
	    int i, j;
        int u, v, w;
        Scanner in = new Scanner(System.in);
       int ver = in.nextInt();
       int edge = in.nextInt();

        for (i = 0; i < ver; ++i)
		    for (j = 0; j < edge; ++j)
			    dist[i][j] = 0;
	    n = -1;
	    for (i = 0; i < edge; ++i) {
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextInt();
		    dist[u][v] = w;
		    dist[v][u] = w;
		    n = Max(u, Max(v, n));
	    }
	    source = in.nextInt();
	    destn = in.nextInt();
	    int dest = destn;
	    dijkstra(prev, dist, d, source, n);
        printD(d, n, dest);
        int arr[] = new int [13];
        for(int k=0; k< arr.length; k++)
        	arr[k] = -1;
        
        printPath(prev, dest, arr, 0);

        
        Collections.sort(listOfList,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int rtrn =  a.size() - b.size();
				if (rtrn ==0) {
					int s = a.size();
					int i =0;
					while(i<s ) {
						if(a.get(i) == b.get(i)) {
							i++;
							continue;
						}
							
						else {
							rtrn = a.get(i) - b.get(i);
							break;
						}
					}
					
				}
				return rtrn;
			}
			
		});
        
        for (j=0; j<listOfList.get(0).size()-1; j++)
			System.out.print(listOfList.get(0).get(j)+ " ");
		System.out.println(listOfList.get(0).get(j));
        
      in.close();
      
    }
	
	

}

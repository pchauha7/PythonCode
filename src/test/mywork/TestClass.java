package test.mywork;

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


class TestClass {
	
	public static class Node
	{
		public char value;
		public ArrayList<Node> subCategoryNode;
		public Node() {
			subCategoryNode = new ArrayList<Node>();
		}
		public Node(char value) {
			this.value=value;
			this.subCategoryNode = new ArrayList<Node>();
		}
	}

	public static Node createTree(String A, ArrayList<Node> arr, int u[], int v[]) {
		Node root = new Node(A.charAt(0));
		
		arr.add(root);
		
		for (int i=1; i<A.length(); i++) 
			arr.add(new Node(A.charAt(i)));
			
		for (int i=0; i<u.length; i++) 
			arr.get(u[i]-1).subCategoryNode.add(arr.get(v[i]-1));
		
		return root;
	}
	
public static int getCount(Node root, char c) {
	if (root==null)
		return 0;
	int count = 0;
	if (root.value==c)
		count =1;
	for (int i=0; i<root.subCategoryNode.size(); i++)
		count = count + getCount(root.subCategoryNode.get(i), c);
	
	return count;
}
	
 public static void main(String args[] ) throws Exception {
     
     Scanner s = new Scanner(System.in);
     String name[] = s.nextLine().split(" ");
     int N = Integer.parseInt(name[0]);
     int Q = Integer.parseInt(name[1].trim());
     
     String Tree = s.nextLine();
     
     int U[] = new int[N-1];
     int V[] = new int[N-1];
     
     for (int i =0; i<N-1; i++) {
    	 String edge[] = s.nextLine().split(" ");
    	 
    	 U[i] = Integer.parseInt(edge[0]);
    	 V[i] = Integer.parseInt(edge[1].trim());
     }
     ArrayList<Node> arr = new ArrayList<>();
     Node root = createTree(Tree,arr, U, V);
     
     int output[] = new int[Q];
     for (int i=0; i<Q; i++) {
    	 String q[] = s.nextLine().split(" ");
    	 int u = Integer.parseInt(q[0]);
    	 char c = q[1].trim().charAt(0);
    	 output[i]=getCount(arr.get(u-1), c);
     }
     
     for (int i=0; i<Q; i++)
    	 System.out.println(output[i]);

 }
}

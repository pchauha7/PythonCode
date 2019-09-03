package test.mywork;
import java.util.ArrayList;



class AmazonMaximumDepth { 
	
	
	public static class Node
	{
		public int value;
		public ArrayList<Node> subCategoryNode;
		public Node() {
			subCategoryNode = new ArrayList<Node>();
		}
		public Node(int value) {
			this.value=value;
			this.subCategoryNode = new ArrayList<Node>();
		}
	}
	
	
//	static Node mosPop;
//	static float count = 0;
	
	public static Node createTree(int A[], int u[], int v[]) {
		Node root = new Node(A[0]);
		
		ArrayList<Node> arr = new ArrayList<>();
		arr.add(root);
		
		for (int i=1; i<A.length; i++) 
			arr.add(new Node(A[i]));
			
		for (int i=0; i<u.length; i++) 
			arr.get(u[i]-1).subCategoryNode.add(arr.get(v[i]-1));
		
		return root;
	}
	
	public static ArrayList<Integer> depthValues (Node root, int l) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		recurFun(root, arr, l, 0);
		
		return arr;
	}
	
	public static void recurFun(Node root, ArrayList<Integer> arr, int l, int x) {
		if (root!=null) {
			if (x==l)
				arr.add(root.value);
			for (int i=0; i<root.subCategoryNode.size(); i++)
				recurFun(root.subCategoryNode.get(i), arr, l, x+1);
		}
		
	}
	
	
	
	public static int[] GreaterEqual(int A[], int X[], int u[], int L[], int v[]) {
		int sol[] = new int[L.length];
		
		Node root = createTree(A, u, v);
		
		for(int i=0; i<L.length; i++) {
			ArrayList<Integer> depValues = depthValues(root, L[i]);
			int x = X[i];
			int z = Integer.MAX_VALUE;
			
			for (int j=0; j<depValues.size(); j++) {
				
				int m = depValues.get(j);
				if(m>x && m<z)
					z= m;
			}
			if(z<x)
				sol[i] = -1;
			else
				sol[i] = z;
			
		}
		
		return sol;
	}
	
    
    public static void main(String args[]) 
    { 
        
       int k =5;
        
       String str = "MyNameisAbhimanyu";
  
//        ArrayList<String> arr = getSubstring(str, k);
//        
//        for (int i=0; i<arr.size(); i++)
//        	System.out.println(arr.get(i));
//        
        System.out.println((int)'a');
    }

	
} 
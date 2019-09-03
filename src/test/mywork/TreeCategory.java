package test.mywork;
import java.util.ArrayList;



class TreeCategory { 
	
	
	public class CategoryNode
	{
		public int value;
		public ArrayList<CategoryNode> subCategoryNode;
		public CategoryNode() {
			subCategoryNode = new ArrayList<CategoryNode>();
		}
		public CategoryNode(int tenure) {
			this.value=tenure;
			this.subCategoryNode = new ArrayList<CategoryNode>();
		}
	}
	
	public static class Combo{
		private int sum;
		private int count;
		public Combo(int sum, int count) {
			this.sum= sum;
			this.count=count;
		}
	}
	
	static CategoryNode mosPop;
	static float count = 0;
	
	public static Combo mostPopular(CategoryNode root) {
		ArrayList<Combo> sum2 = new ArrayList<>();
		//ArrayList<Float> sum = new ArrayList<Float>();
		if(root.subCategoryNode.size()==0) {
			return new Combo(root.value, 1);
		}
			
		for (int i=0; i<root.subCategoryNode.size(); i++)
			sum2.add(mostPopular(root.subCategoryNode.get(i)));
		
		int suma=root.value;
		int cnt = 1;
		
		for (int i=0; i<sum2.size(); i++) {
			suma = suma+ sum2.get(i).sum;
			cnt = cnt + sum2.get(i).count;
		}
		
		float pop = (float)suma/cnt;
		
		if (count<pop) {
			mosPop= root;
			count = pop;
		}
		return new Combo(suma,cnt);
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
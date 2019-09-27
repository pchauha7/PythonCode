package test.mywork;
import java.util.ArrayList;



class TreeCategory { 
	
	
	public static class CategoryNode
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
	
	static CategoryNode mosPop = null;
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

		CategoryNode root = new CategoryNode(20);

		root.subCategoryNode.add(new CategoryNode(12));
		root.subCategoryNode.add(new CategoryNode(18));
		root.subCategoryNode.get(0).subCategoryNode.add(new CategoryNode(11));
		root.subCategoryNode.get(0).subCategoryNode.add(new CategoryNode(2));
		root.subCategoryNode.get(0).subCategoryNode.add(new CategoryNode(3));
		root.subCategoryNode.get(1).subCategoryNode.add(new CategoryNode(15));
		root.subCategoryNode.get(1).subCategoryNode.add(new CategoryNode(8));

		mostPopular(root);
		System.out.println(mosPop.value + " having average: " + count);
        

  


    }

	
} 
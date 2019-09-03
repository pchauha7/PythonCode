package test.mywork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TestList {

	public static void main(String s[]) {
		ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
		TestList thisObj = new TestList();
		
		for (int i=0; i<10; i++) 
			listOfList.add(thisObj.getRandomSizeList());
		
		Collections.sort(listOfList,new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int rtrn =  a.size() - b.size();
				if (rtrn ==0) {
					int s = a.size();
					int i =0;
					while(i<s ) {
						if(a.get(i) == b.get(i))
							continue;
						else {
							rtrn = a.get(i) - b.get(i);
							break;
						}
					}
					
				}
				return rtrn;
			}
			
		});
		
		for (int i=0; i<listOfList.size(); i++) {
			for (int j=0; j<listOfList.get(i).size(); j++)
				System.out.print(listOfList.get(i).get(j)+ " ");
			System.out.println();
		}
		
	}
	
	private ArrayList<Integer> getRandomSizeList() {
		ArrayList<Integer> list = new ArrayList<>();
		Random rndmObj = new Random();
		int size = rndmObj.nextInt(3);
		for (int i=0; i<size; i++)
			list.add(rndmObj.nextInt(100));
		return list;
	}
	
}

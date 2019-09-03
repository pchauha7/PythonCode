package test.mywork;
import java.util.ArrayList;



class KSubstringProblem { 
	
	private static ArrayList<String> getSubstring(String str, int k) {
		
		ArrayList<String> subStrLst = new ArrayList<String>();
		
		for (int i=0; i<str.length()-k; i++) {
			int count = 0;
			int hashCar[] = new int[256];
			String subStr = str.substring(i, i+k);
			
			for (int j=0; j<k;j++) {
				int x = subStr.charAt(j)-'A';
				if (hashCar[x]==0) {
					count++;
					hashCar[x]=1;
				}
					
			}
			if(count>=k-1)
				subStrLst.add(subStr);
		}
		
		return subStrLst;
	} 
    
    public static void main(String args[]) 
    { 
        
       int k =5;
        
       String str = "MyNameisAbhimanyu";
  
        ArrayList<String> arr = getSubstring(str, k);
        
        for (int i=0; i<arr.size(); i++)
        	System.out.println(arr.get(i));
        
        System.out.println((int)'a');
    }

	
} 
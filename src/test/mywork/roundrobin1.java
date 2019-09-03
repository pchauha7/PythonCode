package test.mywork;

class roundrobin1 { 
    public static float roundRobin(int num, int arrival[], 
                                  int burst[], int q) 
    { 
        
        
        int joblog[] = new int[arrival.length];
        
        int totalwaitTime[]= new int[arrival.length];
        
        int tmpArrival[]= new int[arrival.length];
        
        for (int i = 0; i < arrival.length; i++)
        	tmpArrival[i]=arrival[i];
        
        //System.out.println(Arrays.toString(joblog));
        
        int jobLeft = arrival.length;
        
        int currentTime = arrival[0]; // Or we can provide minimum of the arrival time and if it is given at least one of 
        								// the arrival is 0, then we can set currentTime = 0;
        
        while (jobLeft>0) {
        	
        	for (int i=0; i<arrival.length; i++) {
        		int indburst = burst[i] - joblog[i];
        		if (currentTime >= arrival[i] && indburst > 0) {
        			if (indburst<=q) {
        				int tempburst = q;
        				if (indburst < q)
        					tempburst = indburst;
        				joblog[i] = joblog[i] + tempburst;
        				totalwaitTime[i] = totalwaitTime[i] + currentTime - tmpArrival[i];
        				currentTime = currentTime + tempburst;
        				tmpArrival[i] = currentTime;
        				jobLeft--;
        			}
        			else {
        				joblog[i] = joblog[i] + q;
        				totalwaitTime[i] = totalwaitTime[i] + currentTime - tmpArrival[i];
        				currentTime = currentTime + q;
        				tmpArrival[i] = currentTime;
        			}
        		}
        	}
        }
        
        int totalWt= 0;
        
        for (int i = 0; i < num; i++) { 
        	  
        	totalWt = totalWt + totalwaitTime[i]; 
        }
              
       return (float)totalWt/num; 
    } 
  
    // Driver Code 
    public static void main(String args[]) 
    { 
        // name of the process 
       int num = 4;
        // arrival for every process 
        //int arrivaltime[] = { 0, 1, 3, 9 };
        // burst time for every process 
  
        // quantum time of each process 
    // arrival for every process 
       int arrivaltime[] = { 0, 1, 2, 3 }; 
 
       // burst time for every process 
       int bursttime[] = { 10, 4, 5, 3 }; 
 
       // quantum time of each process 
       int q = 3; 
  
        // cal the function for output 
        float a=roundRobin(num, arrivaltime, bursttime, q); 
        System.out.println(a);
    } 
} 
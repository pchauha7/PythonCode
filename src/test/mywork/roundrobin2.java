package test.mywork;

class roundrobin2 { 
    public static float roundRobin(int p, int a[], 
                                  int b[], int n) 
    { 
        int res = 0; 
  
        int res_b[] = new int[b.length]; 
        int res_a[] = new int[a.length]; 
  
        for (int i = 0; i < res_b.length; i++) { 
            res_b[i] = b[i]; 
            res_a[i] = a[i]; 
        } 
  
        int t = 0; 
  
        int w[] = new int[p]; 
  
        int comp[] = new int[p]; 
  
        while (true) { 
            boolean flag = true; 
            for (int i = 0; i < p; i++) { 
  
                if (res_a[i] <= t) { 
                    if (res_a[i] <= n) { 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > n) { 
  
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                            } 
                            else { 
  
                                t = t + res_b[i]; 
  
                                comp[i] = t - a[i]; 
  
                                // store wait time 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
  
                            } 
                        } 
                    } 
                    else if (res_a[i] > n) { 
  
                        for (int j = 0; j < p; j++) { 
  
                            if (res_a[j] < res_a[i]) { 
                                if (res_b[j] > 0) { 
                                    flag = false; 
                                    if (res_b[j] > n) { 
                                        t = t + n; 
                                        res_b[j] = res_b[j] - n; 
                                        res_a[j] = res_a[j] + n; 
                                    } 
                                    else { 
                                        t = t + res_b[j]; 
                                        comp[j] = t - a[j]; 
                                        w[j] = t - b[j] - a[j]; 
                                        res_b[j] = 0; 
                                    } 
                                } 
                            } 
                        } 
  
                        if (res_b[i] > 0) { 
                            flag = false; 
  
                            if (res_b[i] > n) { 
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                            } 
                            else { 
                                t = t + res_b[i]; 
                                comp[i] = t - a[i]; 
                                w[i] = t - b[i] - a[i]; 
                                res_b[i] = 0; 
                            } 
                        } 
                    } 
                } 
  
                else if (res_a[i] > t) { 
                    t++; 
                    i--; 
                } 
            } 
            if (flag) { 
                break; 
            } 
        } 
  
        for (int i = 0; i < p; i++) { 
  
            res = res + w[i]; 
        } 
        	System.out.println(res);
        
            return (float)res / p;
        
    } 
  
    // Driver Code 
    public static void main(String args[]) 
    { 
        // name of the process 
       int name = 4;
        // arrival for every process 
        int arrivaltime[] = { 0, 1, 3, 9 }; 
  
        // burst time for every process 
        int bursttime[] = { 2, 1, 7, 5 }; 
  
        // quantum time of each process 
        int q = 2; 
  
        // cal the function for output 
        float a=roundRobin(name, arrivaltime, bursttime, q); 
        System.out.println(a);
    } 
} 
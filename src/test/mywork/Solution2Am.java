package test.mywork;

import java.util.*;

public class Solution2Am {
    List<List<Integer>> ClosestLocations (int totalCrates, List<List<Integer>> allLocations, int truckCapacity){

        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        List<List<Integer>> results = new ArrayList<>();
        for (int i =0; i< allLocations.size(); i++){
                int x = allLocations.get(i).get(0);
                int y = allLocations.get(i).get(1);
                int d = x*x + y*y;
                int z[] = {x,y,d};
                q.add(z);

        }

        while(truckCapacity-- >0){
            List<Integer> z = new ArrayList<>();
            int arr[] = q.poll();
            z.add(arr[0]);
            z.add(arr[1]);
            results.add(z);
        }

        return results;
    }
}

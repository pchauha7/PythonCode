package test.mywork;

import java.util.*;

public class ConnectRopes {
    private static int mergeFiles(int[] files) {
        Queue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int i=0; i< files.length; i++)
            pq.add(files[i]);
        while (pq.size()>1){

            int x = pq.remove();
            int y = pq.remove();
            count+= x + y;
            pq.add(x+y);

        }

        return count;
    }

    public static void main(String[] args) {
        int[] files1 = {8, 4, 6, 12};
        int[] files2 = {20, 4, 8, 2};
        int[] files3 = {1, 2, 5, 10, 35, 89};
        int[] files4 = {2, 2, 3, 3};
        System.out.println(mergeFiles(files1));
        System.out.println(mergeFiles(files2));
        System.out.println(mergeFiles(files3));
        System.out.println(mergeFiles(files4));
    }
}

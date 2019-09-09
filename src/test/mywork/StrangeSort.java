package test.mywork;

import java.util.Arrays;
import java.util.Comparator;

public class StrangeSort {

    public static void sortStrangeArray(int mapping[], String arr[]){
        int mapping2[] = new int[mapping.length];

        for (int i =0; i< mapping.length; i++)
            mapping2[mapping[i]] = i;

        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String s, String t1) {
                int i =0;
                int a =0;
                int b =0;
                while (i<s.length() || i<t1.length()){
                    if (i<s.length()){
                        int x = mapping2[Integer.parseInt(s.substring(i,i+1))];
                        a = a*10 + x;
                    }
                    if (i<t1.length()){
                        int x = mapping2[Integer.parseInt(t1.substring(i,i+1))];
                        b = b*10 + x;
                    }
                    i++;
                }
                return a-b;
            }
        });
    }

    public static void main(String args[]){
        int map[] = {2,1,4,8,6,3,0,9,7,5};

        String strgArr[] = {"12", "02", "4", "023", "65", "83", "224", "50"};

        sortStrangeArray(map, strgArr);

        System.out.println(Arrays.toString(strgArr));

    }

}

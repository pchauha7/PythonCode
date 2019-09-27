package test.mywork;

import java.util.HashMap;

public class PrintReciprocal {
    public static void reciprocal (int N){


        if (N<=1){
            System.out.println("0.0 0");
            return;
        }

        String res = "0.";
        HashMap<Integer, Integer> mp = new HashMap<>();

        int rem = 1;

        while (rem!=0 && !mp.containsKey(rem) )
        {
            mp.put(rem, res.length());
            rem = rem*10;
            int res_part = rem / N;
            res += Integer.toString(res_part);
            rem = rem % N;
        }
        if (rem ==0)
            System.out.println(res + "0 0");
        else{
            rem = rem*10;
            int res_part = rem / N;
            String str = "";
            for (int i=2; i<res.length(); i++){
                if (res_part == Integer.parseInt(res.substring(i,i+1))){
                    str = res.substring(i);
                    break;
                }

            }
            System.out.println(res + " " + str);
        }

    }


    public static void main(String args[]){
        reciprocal(7);
    }
}

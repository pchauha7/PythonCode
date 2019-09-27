package test.mywork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class TwoSumAm {
    public List<Integer> twoSum(List<Integer> nums, int target) {
        List<Integer> a = new ArrayList<>();
        List<List<Integer>> comp = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i=0; i<nums.size(); i++){
            if (mp.containsKey(target-nums.get(i))){
                a.add(mp.get(target-nums.get(i)));
                a.add(i);
                comp.add(new ArrayList<>(a));
                a.clear();
            }
            else
                mp.put(nums.get(i), i);
        }

        if (comp.size()==1)
            return comp.get(0);

        int t = 0;
        int ind = 0;
        for (int i = 0; i< comp.size(); i++){
            int x = Math.max(nums.get(comp.get(i).get(0)), nums.get(comp.get(i).get(0)));
            if (x>t){
                t = x;
                ind = i;
            }
        }
        return comp.get(ind);
    }

    public static void main(String args[]){
        TwoSumAm x = new TwoSumAm();

        List<Integer> gfg = new ArrayList<Integer>(
                Arrays.asList(10, 40, 60, 20, 100, 30, 60, 80, 90));

        System.out.println(x.twoSum(gfg, 120));
    }
}

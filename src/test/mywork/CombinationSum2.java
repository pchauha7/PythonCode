package test.mywork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class CombinationSum2 {
    private static void createSum(int[] candidates, List<List<Integer>> l1,  List<Integer> l2, int target, int idx){
        if (target<0)
            return;
        if (target==0){
            l1.add(new ArrayList<>(l2));
            System.out.println(l2.toString());
            return;
        }
        for (int i=idx; i<candidates.length; i++){
            if (i>idx && candidates[i]==candidates[i-1]) continue;
            l2.add(candidates[i]);
            createSum(candidates, l1, l2, target-candidates[i], i+1);
            l2.remove(l2.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l1 = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i=0; i<candidates.length; i++){
            if (i>0 && candidates[i]==candidates[i-1]) continue;
            List<Integer> l2 = new ArrayList<>();
            l2.add(candidates[i]);
            createSum(candidates, l1, l2, target-candidates[i], i+1);
        }
        return l1;
    }

    public static void main (String args[]){
        int [] cand = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(cand,8));
    }
}

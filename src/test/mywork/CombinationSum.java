package test.mywork;
import java.util.*;


public class CombinationSum {
    private static void createSum(int[] candidates, List<List<Integer>> l1, List<Integer> l2, int target, int idx){
        if (target<0)
            return;
        if (target==0){
            l1.add(new ArrayList<>(l2));
            System.out.println(l2.toString());
            return;
        }
        for (int i=idx; i<candidates.length; i++){
            l2.add(candidates[i]);
            createSum(candidates, l1, l2, target-candidates[i], i);
            l2.remove(l2.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l1 = new ArrayList<>();
        for (int i=0; i<candidates.length; i++){
            List<Integer> l2 = new ArrayList<>();
            l2.add(candidates[i]);
            createSum(candidates, l1, l2, target-candidates[i], i);
        }
        return l1;
    }

    public static void main (String args[]){
        int [] cand = {2,3,6,7};
        System.out.println(combinationSum(cand,7));
    }
}

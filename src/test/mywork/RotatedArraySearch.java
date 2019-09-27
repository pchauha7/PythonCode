package test.mywork;

public class RotatedArraySearch {
    public int searchRec(int[] nums, int i, int l, int target) {
        if (i>l)
            return -1;
        if (i==l && nums[i]!=target)
            return -1;
        int m = (i+l)/2;
        if (nums[m] == target)
            return m;
        if (nums[i] <= nums[m]){
            if (target <= nums[m] && target >= nums[i])
                return searchRec(nums, i, m-1, target);
            else
                return searchRec(nums, m+1, l, target);
        }
        else{
            if (target >= nums[m+1] && target <= nums[l])
                return searchRec(nums, m+1, l, target);
            else
                return searchRec(nums, i, m-1, target);
        }

    }

    public int search(int[] nums, int target) {
        return searchRec(nums, 0, nums.length-1, target);
    }
}

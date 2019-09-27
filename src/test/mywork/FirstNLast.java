package test.mywork;

public class FirstNLast {
    public void searchRangeRec(int[] nums, int[] res, int target, int l, int h){
        if (h<l)
            return;
        int m = (h+l)/2;
        if (nums[m] == target){
            if (res[0]==-1)
                res[0] = res[1] = m;
            else if (res[0]>m)
                res[0] = m;
            else if (res[1]<m)
                res[1] =m;

            if (m>0 && nums[m-1] == target)
                searchRangeRec(nums,res,target,l,m-1);

            if (m<nums.length-1 && nums[m+1] == target)
                searchRangeRec(nums,res,target,m+1,h);
        }

        else{
            if (target < nums[m])
                searchRangeRec(nums,res,target,l,m-1);
            else
                searchRangeRec(nums,res,target,m+1,h);
        }



    }
    public int[] searchRange(int[] nums, int target) {
        int res[] = {-1, -1};

        this.searchRangeRec(nums, res, target,0, nums.length-1);
        return res;
    }
}

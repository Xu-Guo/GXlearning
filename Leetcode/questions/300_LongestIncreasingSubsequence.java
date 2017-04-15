public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int [] lis = new int[nums.length];
        for(int i=0; i<lis.length; i++){
            lis[i] = 1;
        }
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        int res = 1;
        for(int i=0; i<lis.length; i++){
            if(lis[i] > res){
                res = lis[i];
            }
        }
        return res;
    }
}
public class 287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length-1;
        while(l < r){
            int mid = l + (r - l)/2;
            int count = 0;
            for(int i=0; i<nums.length; i++){
                if(nums[i]<=mid){
                    count++;
                }
            }
            if(count > mid){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
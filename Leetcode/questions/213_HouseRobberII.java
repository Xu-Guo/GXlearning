//can only rob one of the first house and the last one, so we have two plan, get the max we can have from both and choose the larger  
public class 213_HouseRobberII {
    public int rob(int[] nums) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int planA = getMax(nums, 1, nums.length);
        int planB = getMax(nums, 0, nums.length-1);
        return Math.max(planA, planB);
    }
    
    private int getMax(int[] nums, int start, int end){
        int a = 0;
        int b = 0;
        for(int i=start; i<end; i++){
            if(i%2==0){
                a += nums[i];
                a = Math.max(a,b);
            }else{
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a, b);
    }
}
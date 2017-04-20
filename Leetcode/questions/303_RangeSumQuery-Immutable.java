//建立presum数组，并用nums指针指向presum数组，如果range从0开始，返回presum[j] 否则返回presum[j] - presum[i-1]
public class NumArray {
    int[] nums;
    
    public NumArray(int[] nums) {
        for(int i=1; i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }
    
    public int sumRange(int i, int j) {
        if(i == 0){
            return nums[j];
        }
        return nums[j] - nums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
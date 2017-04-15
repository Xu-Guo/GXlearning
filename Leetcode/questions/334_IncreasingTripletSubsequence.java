//从左到右遍历数组，维护最小和第二小元素，如果找到一个数字大于both，返回true
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min){//这里注意如果写 num<min,之后的else里second会被复制和min相同的数
                min = num;
            }else if(num < secondMin){
                secondMin = num;
            }else if(num > secondMin){
                return true;
            }
        }
        return false;
    }
}
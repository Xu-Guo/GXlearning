public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1){
            return;
        }
        
        int len = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, len - 1);
        reverse(nums, len, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}


public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1){
            return;
        }
        int len = k % nums.length;
        int[] temp = new int[nums.length - len];
        for (int i = 0; i < nums.length - len; i++){
            temp[i] = nums[i];
        }
        int j = 0;
        for (int i = nums.length - len; i < nums.length; i++){
            nums[j++] = nums[i];
        }
        int i = 0;
        while (j < nums.length){
            nums[j++] = temp[i++];
        }
    }
}
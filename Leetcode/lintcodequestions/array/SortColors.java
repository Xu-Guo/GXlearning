class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1){
            return;
        }
        
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        /*
        从左到右遍历数组，使用3个指针
        每找到一个0，和当前左指针交换，l++，i++；
        找到2，和当前右指针交换，r--，如果交换过来的是1，重复上一步，
        如碰到1，i++;
        知道循环结束
        */
        while(i <= r){
            if(nums[i] == 0){
                swap(nums, l, i);
                l++;
                i++;
            } else if(nums[i] == 1){
                i++;
            } else {
                swap(nums, r, i);
                r--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
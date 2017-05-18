public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    
	    int l = 0;
	    int r = nums.length - 1;
	    while(l <= r){
	        while(l <= r && nums[l] < k){//here no =
	            l++;
	        }
	        while(l <= r && nums[r] >= k){//here do >=
	            r--;
	        }
	        if(l <= r){
	            swap(nums, l, r);
	            l++;
	            r--;
	        }
	    }
	    return l;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
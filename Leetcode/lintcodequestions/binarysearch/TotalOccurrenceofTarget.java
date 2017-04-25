public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int firstIndex = findFirst(nums, target);
        if  (firstIndex == -1){
            return 0;
        }
        int lastIndex = findLast(nums, target);

        return lastIndex - firstIndex + 1;
    }
    
    private int findFirst(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target){
                end = mid; 
            } else {
                start = mid;
            }
        }
        if (nums[start] == target){
            return start;
        }
        if (nums[end] == target){
            return end;
        }
        return -1;
    }
    
    private int findLast(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target){
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target){
            return end;
        }
        if (nums[start] == target){
            return start;
        }
        return -1;
    }
}
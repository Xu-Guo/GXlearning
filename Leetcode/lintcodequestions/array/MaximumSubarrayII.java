public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        //从后向前使用一样的算法计算right sum数组
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }
        
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            result = Math.max(result, left[i] + right[i + 1]);
        }
        return result;
    }
}

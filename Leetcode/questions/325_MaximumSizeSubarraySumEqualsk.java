//calculate the sum at each index and store the index in a hashmap
// if sum at current index == k: max = i+1;
// if map contains sum - k: max = Math.max(max, map.get(sum - k)) 
public class 325_MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null || nums.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum == k){
                maxLen = i+1;
            }else if(map.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
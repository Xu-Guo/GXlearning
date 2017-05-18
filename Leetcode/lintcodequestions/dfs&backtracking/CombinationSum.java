public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    //可以重复使用数字
    //需要避免以重复数字开头
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, 
                        List<Integer> list, 
                        int[] nums, 
                        int remain, 
                        int start){
        if(remain < 0){
            return;
        }
        
        if(remain == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, remain - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
    
}
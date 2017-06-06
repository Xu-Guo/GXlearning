public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int remain, int start){
        if (remain < 0){
            return;
        }
        if (remain == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, remain - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
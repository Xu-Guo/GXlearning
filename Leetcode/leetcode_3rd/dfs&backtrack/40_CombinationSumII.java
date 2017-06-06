public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length], 0, target);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited, int start, int remain){
        if (remain < 0){
            return;
        }
        if (remain == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++){
            if (i != start && nums[i] == nums[i - 1] && !visited[i]){
                continue;
            }
            
            list.add(nums[i]);
            helper(res, list, nums, visited, i + 1, remain - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
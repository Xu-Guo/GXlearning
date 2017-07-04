/*
递归开始先将传入的list加入res，每一次循环会把所有以nums[start]开头的subset加入res
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int start){
        res.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
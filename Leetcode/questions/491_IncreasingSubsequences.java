public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        
        helper(res, new ArrayList<>(), nums, 0);
        return new ArrayList<List<Integer>>(res);
    }
    
    private void helper(Set<List<Integer>> res, List<Integer> list, int[] nums, int start){
        if(list.size() >= 2){
            res.add(new ArrayList<Integer>(list));
        }
        
        for(int i= start; i<nums.length; i++){
            if(list.size() == 0 || list.get(list.size() - 1) <= nums[i]){
                list.add(nums[i]);
                helper(res, list, nums, i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}
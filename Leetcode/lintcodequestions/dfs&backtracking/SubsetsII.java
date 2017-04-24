class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int start){
        result.add(new ArrayList<>(list));
        
        if(start == nums.length){
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
}

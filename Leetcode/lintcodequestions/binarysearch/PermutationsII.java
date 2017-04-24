class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if(nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return result;
    } 
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited){
        if(list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            /*规定在排列中出现的重复数字的顺序要和在排序后数组中的顺序一致
            1.使用过的数字自然不能再使用
            2.如果2个数字相同，数组中前一个没有使用那后一个也不能作为开头的数字先被使用
            */
            if(visited[i] || (i != 0 && nums[i] == nums[i - 1]) && !visited[i - 1]){
                continue;
            }
            
            list.add(nums[i]);
            visited[i] = true;
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
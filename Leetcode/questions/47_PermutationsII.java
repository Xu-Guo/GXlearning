public class 47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used){
        if(list.size()>nums.length){
            return;
        }
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
        }else{
            for(int i=0; i<nums.length; i++){
                if(used[i] || i>0 && nums[i] == nums[i-1] && !used[i-1] ){
                    continue;
                }
                list.add(nums[i]);
                used[i] = true;
                backtrack(result, list, nums, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
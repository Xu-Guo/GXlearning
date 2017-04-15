//everytime calling the backtrack() result.add(new ArrayList<>(list))
public class 90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), 0, nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> list, int start, int[] nums){
        result.add(new ArrayList<>(list));
        for(int i=start; i<nums.length; i++){
            if(i!=start && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            backtrack(result, list, i+1, nums);
            list.remove(list.size()-1);
        }
    }
}
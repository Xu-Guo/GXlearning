public class 46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++){//有n个分支可以选择，但要去掉已经使用过的数字
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(result, list, nums);
            list.remove(list.size()-1);
        }
    }
}
public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */


    /*
        不能重复使用数字
    */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(num == null || num.length == 0){
            return result;
        }
        
        Arrays.sort(num);
        helper(result, new ArrayList<Integer>(), num, target, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, 
                        List<Integer> list,
                        int[] num,
                        int remain,
                        int start){
        if(remain < 0){
            return;
        }
        
        if(remain == 0){
            result.add(new ArrayList<>(list));
            return; 
        }
        
        for(int i = start; i < num.length; i++){
            if(i != start && num[i] == num[i - 1]){
                continue;
            }
            list.add(num[i]);
            helper(result, list, num, remain - num[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
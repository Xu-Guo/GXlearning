public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0){
            return res;
        }
        
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int k, int remain){
        if (remain < 0){
            return;
        }
        if (remain == 0 && list.size() == k){
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i <= 9; i++){
            list.add(i);
            helper(res, list, i + 1, k, remain - i);
            list.remove(list.size() - 1);
        }
    }
}
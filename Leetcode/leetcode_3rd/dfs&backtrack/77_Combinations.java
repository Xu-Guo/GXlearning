public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0){
            return res;
        }
        
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int start, int k, int n){
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;    
        }
        
        for (int i = start; i <= n; i++){
            list.add(i);
            helper(res, list, i + 1, k, n);
            list.remove(list.size() - 1);
        }
    }
}
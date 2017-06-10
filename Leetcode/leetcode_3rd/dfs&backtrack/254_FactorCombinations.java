public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> list, int remain, int start){
        if (remain <= 1){
            if (list.size() > 1){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        for (int i = start; i <= remain; i++){
            if (remain % i == 0){
                list.add(i);
                helper(res, list, remain / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
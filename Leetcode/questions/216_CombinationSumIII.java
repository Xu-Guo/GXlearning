public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(k < 1){//sum at least is 1
            return res;
        }
        
        dfs(res, new ArrayList<>(), n, 1, k);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int remain, int start, int k){
        if(remain < 0){
            return;
        }
        
        if(remain == 0 && list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<=9; i++){
            list.add(i);
            dfs(res, list, remain-i, i+1, k);
            list.remove(list.size()-1);
        }
    }
}
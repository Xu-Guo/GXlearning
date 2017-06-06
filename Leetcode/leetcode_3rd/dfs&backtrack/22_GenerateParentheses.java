/*
DFS solution：
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, "", n, n);
        return res;
    }
    
    private void helper(List<String> res, String path, int open, int close){
        //everything has been used, add path to res
        if (open == 0 && close == 0){
            res.add(path);
            return;
        }

        //remain open > close, means we added invalid close, then return 
        if (open > close){
            return;
        }
        //if there is open left, add an open
        if (open > 0){
            helper(res, path + "(", open - 1, close);
        }

        //if there is close left, add an close
        if (close > 0){
            helper(res, path + ")", open, close - 1);
        }
        
    }
}
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0){
            return list;
        }
        helper(list, "", 0, 0, n);
        return list;
    }
    
    private void helper(List<String> list, String s, int open, int close, int max){
        if(s.length() == max * 2){//长度满足，返回
            list.add(s);
            return;
        }
        
        if(open > close){//open > close，可以进入+")"的分支，
            helper(list, s+")", open, close+1, max);
        }
        //这里不可以用else，否则只有1条分支可走，但实际上上面递归调用返回后，如条件满足，应进入下面分支
        if(open < max){//open < max, 可以进入"("的分支
            helper(list, s+"(", open+1, close, max);
        }
    }
}
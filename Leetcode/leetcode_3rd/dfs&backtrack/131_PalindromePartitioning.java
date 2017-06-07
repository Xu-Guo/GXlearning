/*
for 循环字符串拆分结束的位置， 如果切下的字符串is valid 则加入list，
继续dfs剩下的字符串，如果便利到最后一个字符

*/
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            return res;
        }
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list, String s, int index){
        if (index == s.length()){//向下递归会传入index+i
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 1; i < s.length(); i++){
            if (index + i > s.length()){
                break;
            }
            String str = s.substring(index, index + i);
            if (isValid(str)){
                list.add(str);
                helper(res, list, s, index + i);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String string){
        if (string == null || string.length() == 0){
            return true;
        }
        int left = 0;
        int right = string.length() - 1;
        while (left <= right){
            if (string.charAt(left++) != string.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
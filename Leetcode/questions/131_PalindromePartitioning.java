public class 131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length()==0){
            return res;
        }
        
        helper(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> list, String s, int start){
        if(start==s.length()){
            res.add(new ArrayList<>(list));
        }else{
            for(int i=start; i<s.length(); i++){
                if(isValid(s, start, i)){
                    list.add(s.substring(start, i+1));
                    helper(res, list, s, i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    
    private boolean isValid(String s, int i, int j){
        while(i<j){
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
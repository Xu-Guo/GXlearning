//dfs
public class Solution {
    
    private String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       if (digits == null || digits.length() == 0){
           return res;
       }
       helper(res, digits, "", 0);
       return res;
    }
    
    private void helper(List<String> res, String digits, String path, int start){
        if (start >= digits.length()){
            res.add(path);
            return;
        }
        //get next possible input letters set from current input digit
        String letters = KEYS[digits.charAt(start) - '0'];
        for (int i = 0; i < letters.length(); i++){
            helper(res, digits, path + letters.charAt(i), start + 1);//go to next digit
        }
    }
}

//bfs
public class Solution {
    
    private String[] keys = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new LinkedList<>();
        }
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++){
            int number = digits.charAt(i) - '0';
            
            while (list.peek().length() == i){
                String s = list.poll();
                for(char c : keys[number].toCharArray()){
                    list.add(s + c);
                }
            }
        }
        return list;
    }
}

//new dfs
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0){
            return res;    
        }
        helper(res, "", digits, 0, dict);
        return res;
    }
    
    private void helper(List<String> res, String prefix, String digits, int start, String[] dict){
        if (prefix.length() == digits.length()){
            res.add(prefix);
            return;
        }
        int digit = digits.charAt(start) - '0';
        String letters = dict[digit];
        for (int i = 0; i < letters.length(); i++){
            helper(res, prefix + letters.charAt(i), digits, start + 1, dict);
        }
    }
}

//new bfs
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        res.add("");
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            String letters = dict[digit];
            int size = res.size();
            for (int j = 0; j < size; j++){
                String prefix = res.poll();
                for (char c : letters.toCharArray()){
                    res.add(prefix + c);
                }
            }
        }
        return res;
    }
}
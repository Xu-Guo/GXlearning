public class Solution {
    public int longestPalindromeSubseq(String s) {
        return helper(s, new HashMap<String, Integer>());
    }
    
    private int helper(String s, Map<String, Integer> map){
        if (s == null || s.length() == 0){
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        if (s.length() == 2){
            if (s.charAt(0) == s.charAt(1)){
                return 2;
            }
            return 1;
        }
        
        if (map.containsKey(s)){
            return map.get(s);
        }
        
        
        int len;
        if (s.charAt(0) == s.charAt(s.length() - 1)){
            len = 2 + helper(s.substring(1, s.length() - 1), map);
        } else {
            int left = helper(s.substring(0, s.length() - 1), map);
            int right = helper(s.substring(1), map);
            len = Math.max(left, right);
        }
        map.put(s, len);
        return len;
    }
}



public class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null){
            return 0;
        }
        int len = s.length();
        return helper(s.toCharArray(), 0, s.length() - 1, new int[len][len]);
    }
    
    private int helper(char[] chars, int start, int end, int[][] map){
        if (start > end){
            return 0;
        }
        if (start == end){
            return 1;
        }
        if (start + 1 == end){
            if (chars[start] == chars[end]){
                return 2;
            }
            return 1;
        }
        
        if (map[start][end] != 0){
            return map[start][end];
        }
        
        int len = 0;
        if (chars[start] == chars[end]){
            len = 2 + helper(chars, start + 1, end - 1, map);
        } else {
            int left = helper(chars, start, end - 1, map);
            int right = helper(chars, start + 1, end, map);
            len = Math.max(left, right);
        }
        
        map[start][end] = len;
        return len;
    }
}
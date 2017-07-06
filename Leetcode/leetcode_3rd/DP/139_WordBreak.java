public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[k] 表示从0~k位置的子串是可以break的，dp[0]初始化为true
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //用end遍历所有结束位置，start遍历所有开始位置
        //，如果start之前可以break，且字典包含start~end的字串，则end位置可以break
        for (int end = 1; end <= s.length(); end++){
            for (int start = 0; start < end; start++){
                if (dp[start] == true && wordDict.contains(s.substring(start, end))){
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}


public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict.size());
        set.addAll(wordDict);
        return helper(s, set, new HashMap<String, Boolean>());
        
    }
    
    private boolean helper(String s, Set<String> set, Map<String, Boolean> map){
        if (set.contains(s)){
            return true;
        }
        
        if (map.containsKey(s)){
            return map.get(s);
        }
        
        for (String word : set){
            if (s.startsWith(word) && helper(s.substring(word.length()), set, map)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
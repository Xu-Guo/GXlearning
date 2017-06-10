public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null){
            return true;
        }
        
        if (s.length() == 0 && t.length() == 0){
            return true;
        }
        if (s == null || t == null){
            return false;
        }
        
        if (s.length() != t.length()){
            return false;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            if (!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char ch : t.toCharArray()){
            if (!map.containsKey(ch)){
                return false;
            }
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0){
                map.remove(ch);
            }
        }
        return map.size() == 0;
        
    }
}
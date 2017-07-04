public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p == null || s == null || s.length() < p.length()){
            return res;
        }
        int m = s.length();
        int n = p.length();
        for (int i = 0; i < m - n + 1; i++){
            String cur = s.substring(i, i + n);
            if (isAnagram(cur, p)){
                res.add(i);
            }
        }
        return res;
    }
    
    private boolean isAnagram(String a, String b){
        if (a == null || b == null || a.length() != b.length()){
            return false;
        }
        
        int[] dict = new int[26];
        for (int i = 0; i < a.length(); i++){
            dict[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++){
            dict[b.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < 26; i++){
            if (dict[i] != 0){
                return false;
            }
        }
        return true;
    }
}
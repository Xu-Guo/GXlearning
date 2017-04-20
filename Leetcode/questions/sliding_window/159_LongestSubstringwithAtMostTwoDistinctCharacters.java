public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0;
        int j = 0;
        for(int i=0; i<c.length; i++){
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            while(map.size() > 2){
                map.put(c[j], map.get(c[j]) - 1);
                if(map.get(c[j]) == 0){
                    map.remove(c[j]);
                }
                j++;
            }
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
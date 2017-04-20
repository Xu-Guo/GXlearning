/*右指针 左->右遍历数组，用map记录字符出现的次数，map的size记录出现过多找种字符，
如果map的size大于k，删除左指针的字符，左指针左->右 ++， 直到map的size==k

*/

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k==0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int max = 0;
        int j = 0;
        for(int i=0; i<c.length; i++){
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
            while(map.size() > k){
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
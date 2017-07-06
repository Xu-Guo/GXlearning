/*
Start from 0, we keey moving j forword if there is no repeating character found 
and we use a Set to track the those characters we have seen, and update the max length of 
the substring until we find one repeated character, then we move i forward 
and remove characters at index if i until the repeated character is removed 
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 1;
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}


/*
HashMap solution 

*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        int i = 0;
        int j = 0;
        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                /*
                If index of the repeating character less than current i value, we will not update i,
                otherwise the new valid substring should start from the last index of the repeating
                character plus 1.
                */
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            //update the most recent index of the character.
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int end = 0;
        int len = 1;
        for (int start = 0; start < s.length(); start++){
            while (end < s.length()){
                if (set.contains(s.charAt(end))){
                    break;
                }
                set.add(s.charAt(end));
                len = Math.max(len, end - start + 1);
                end++;
            }
            set.remove(s.charAt(start));
        }
        return len;
    }
}
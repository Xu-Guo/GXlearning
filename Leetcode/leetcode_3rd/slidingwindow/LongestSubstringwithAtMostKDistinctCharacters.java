public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() == 0 || k == 0){
            return 0;
        }
        
        int end = 0;
        int len = 0;
        //用map记录出现过的字符已经出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (int start = 0; start < s.length(); start++){
            while (end < s.length()){
                //拿到结尾的char
                char c = s.charAt(end);
                if (map.containsKey(c)){ //如果map已经有了，计数+1
                    map.put(c, map.get(c) + 1);
                } else {//如果没有
                    //首先判断map是否已经出现过K个不同char
                    if (map.size() == k){
                        break;
                    }
                    //保存当前char
                    map.put(c, 1);
                }
                end++;
            }
            //推出上面循环先更新最长长度，以为while结尾end++，len = end - start(not end - start + 1)
            len = Math.max(len, end - start);
            //更新i使条件满足
            
            char head = s.charAt(start);
            if (map.get(head) > 1){
                map.put(head, map.get(head) - 1);
            } else {
                map.remove(head);
            }
        }
        return len;
    }
}
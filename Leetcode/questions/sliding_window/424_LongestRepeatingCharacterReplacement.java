public class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] map = new int[26];
        char[] c = s.toCharArray();
        int max = 0;
        int j=0;
        for(int i=0; i<c.length; i++){
            while(j < c.length){
                map[c[j] - 'A']++;
                /*这里需要找到第k+1个不同于出现次数最多字符的字符，如果在k个时候break，得到的长度不是最长，
                因为找到k个后，下一个出现的字符可能是之前出现次数最多的那个，那么长度可以继续增加    */
                if(countDiff(map) > k){//find k+1 different chars other than the most frequently char
                    map[c[j] - 'A']--;//remove it from map and break
                    break;
                }
                j++;
            }
            max = Math.max(max, j-i);//not j-i+1
            map[c[i] - 'A']--;
        }
        return max;
    }
    
    private int countDiff(int[] map){
        int max = 0;
        int sum = 0;
        for(int num : map){
            sum += num;
            max = Math.max(max, num);
        }
        return sum - max;
        
    }
}
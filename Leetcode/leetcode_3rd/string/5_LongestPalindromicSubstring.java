/*
以每个index上character为middle或与他右边的字符组成的2个字符为middle，向两边
延长字符串，查找最长的回文，并更新max长度以及substring的开始字符位置
最后返回最长字串
*/
public class Solution {
    int start;
    int max;
    String result = null;
    public String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        if(s.length() < 2){
            return s;
        }
        
        for (int i = 0; i < s.length(); i++){
            findLongest(s, i, i);//palindrom length is odd
            findLongest(s, i, i + 1);//palindrom length is even
        }
        return s.substring(start, start + max);
    }
    
    private void findLongest (String s, int i, int j){
        while(i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        //循环结束后i，j停留在回文串头-1位置和尾+1位置，length为j - i + 1, 头在i + 1位置
        if(max < j - i - 1){
            max = j - i - 1;
            start = i + 1;
        }
    }
}
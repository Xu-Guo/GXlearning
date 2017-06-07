public class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2){
            return true;
        }
        int odd = 0;
        char[] chars = new char[256];
        for (char c : s.toCharArray()){
            chars[c]++;
            if ((chars[c] & 1) == 1){
                odd++;
            } else {
                odd--;
            }
        }
        if (odd > 1){
            return false;
        }
        return true;
    }
}
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        int[] map = new int[256];
        int countOdd = 0;
        for(char c : s.toCharArray()){
            map[c]++;
            if((map[c] & 1)== 1){
                countOdd++;
            }else{
                countOdd--;
            }
        }
        if(countOdd > 1){
            return false;
        }
        return true;
    }
}
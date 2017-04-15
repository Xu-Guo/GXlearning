public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        int[] map = new int[256];
        int countOdd = 0;
        for(char c : s.toCharArray()){
            map[c]++;
            if(map[c] % 2 == 1){
                countOdd++;
            }else{
                countOdd--;
            }
        }
        if(countOdd > 1){
            return res;
        }
        
        int length = 0;
        String mid = "";
        for(int i=0; i<256; i++){
            if(map[i] != 0){
                if(map[i] % 2 == 1){
                    mid += (char)i;
                    map[i]--;
                }
                map[i] /= 2;
                length += map[i];
            }
        }
        getPermutations(res, map, length, mid, "");
        return res;
    }
    
    private void getPermutations(List<String> res, int[] map, int length, String mid, String temp){
        if(temp.length() == length){
            StringBuilder sb = new StringBuilder(temp);
            res.add(temp + mid + sb.reverse().toString());
        }
        for(int i=0; i<256; i++){
            if(map[i] != 0){
                map[i]--;
                getPermutations(res, map, length, mid, temp+(char)i);
                map[i]++;
            }
        }
    }
}
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0){
            return res;
        }
        
        int[] map = new int[256];
        int odd = 0;
        for (char c : s.toCharArray()){
            map[c]++;
            if ((map[c] & 1) == 1){
                odd++;
            } else {
                odd--;
            }
        }
        if (odd > 1) {
            return res;
        }
        
        int len = 0;
        String mid = "";
        for (int i = 0; i < 256; i++){
            if ((map[i] & 1) == 1){
                mid += (char)i;
            }
            map[i] >>= 1;
            len += map[i];
        }
        
        helper(res, "", map, len, mid);
        return res;
    }
    
    private void helper(List<String> res, String path, int[] map, int length, String mid){
        if (path.length() == length){
            String r = new StringBuilder(path).reverse().toString();
            res.add(path + mid + r);
            return;
        }
        
        for (int i = 0; i < 256; i++){
            if (map[i] > 0){
                map[i]--;
                helper(res, path + (char)i, map, length, mid);
                map[i]++;
            }
        }
    }
}
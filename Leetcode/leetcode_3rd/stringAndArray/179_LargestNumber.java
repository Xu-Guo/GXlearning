public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String s1, String s2){
                String r1 = s1 + s2;
                String r2 = s2 + s1;
                return r1.compareTo(r2);
            }
        });
        
        if (strs[strs.length - 1].charAt(0) == '0'){
            return "0";
        }
        String res = "";
        for (int i = 0; i < strs.length; i++){
            res = strs[i] + res;
        }
        return res;
    }
}
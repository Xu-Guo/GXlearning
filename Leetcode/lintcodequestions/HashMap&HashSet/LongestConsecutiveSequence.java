public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int n : num){
            set.add(n);
        }
        
        for(int i = 0; i < num.length; i++){
            int cur = num[i];
            int small = 0;
            while(set.contains(cur - 1)){
                small++;
                cur = cur - 1;
            }
            cur = num[i];
            int large = 0;
            while(set.contains(cur + 1)){
                large++;
                cur = cur + 1;
            }
            int len = small + large + 1;
            if(len > max){
                max = len;
            }
        }   
        return max;       
    }
}
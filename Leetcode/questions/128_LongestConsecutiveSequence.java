public class 128_LongestConsecutiveSequence {
    
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = 1;
        
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int n : nums){
            int temp = n;
            int count = 1;
            while(set.contains(temp-1)){
                count++;
                set.remove(temp);
                temp--;
            }
            temp = n;
            while(set.contains(temp+1)){
                count++;
                set.remove(temp);
                temp++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for(int n : nums){
            if(set.contains(n)){
                continue;
            }
            nums[index++] = n;
            set.add(n);
        }
        return index;
    }
}
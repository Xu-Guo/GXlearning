//
public class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // Needs to be initialized to index -1 for correct calculations of the countDiff being 0.
        // Either initialize it to 0, -1 or if you initialize it to 0, 0 then you need to handle the case when countDiff == 0 then max will be simply i+1.
        map.put(0, -1);
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                count--;
            }else{
                count++;
            }
            if(!map.containsKey(count)){
                map.put(count, i);
            }else{
                len = Math.max(len, i-map.get(count));
            }
        }
        return len;
    }
}
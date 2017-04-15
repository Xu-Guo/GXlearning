//initO(n) time, O(n)space, pick O(1).
public class Solution {
    Map<Integer, List<Integer>> map;
    java.util.Random random = new java.util.Random();
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }    
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        if(list.size() == 1){
            return list.get(0);
        }else{
            return list.get(random.nextInt(list.size()));
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
		return helper(coins, amount, new HashMap<Integer, Integer>());
    }
    
    private int helper(int[] coins, int amount, Map<Integer, Integer> map){
        if (amount == 0){
            return 0;
        }
        
        if (map.containsKey(amount)){
            return map.get(amount);
        }
        
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int cur = 0;
            if (amount >= coin){
                int next = helper(coins, amount - coin, map);
                if (next >= 0){// next == -1 if amount can not be changed 
                    cur = next + 1;
                }
            }
            if (cur > 0){//if there is a solution, cur will le larger than 0
                res = Math.min(res, cur);
            }
        }
        if (res == Integer.MAX_VALUE){
            res = -1;
        }
        map.put(amount, res);
        return res;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        
        Integer max = 0;
        for (Integer n : map.values()){
            if (n > max) {
                max = n;
            }
        }
        List<Integer> sumList = new LinkedList<>();
        for (Map.Entry entry : map.entrySet()){
            if (entry.getValue() == max){
                Integer s = (Integer)entry.getKey();
                sumList.add(s);
            }
        }
        int[] res = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++){
            res[i] = sumList.get(i);
        }
        return res;
    }
    
    private int helper(TreeNode root, Map<Integer,Integer> map){
        if (root == null){
            return 0;
        }
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        
        int sum = left + right + root.val;
        if (!map.containsKey(sum)){
            map.put(sum, 1);
        } else {
            map.put(sum, map.get(sum) + 1);
        } 
        return sum;
    }
}
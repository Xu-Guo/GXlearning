/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size()==0){
            return 0;
        }
        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        int total = 0;
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i=0; i<size; i++){
                NestedInteger ni = q.poll();
                if(ni.isInteger()){
                    total += ni.getInteger() * level;
                }else{
                    q.addAll(ni.getList());
                }
            }
        }
        return total;
        
    }
}
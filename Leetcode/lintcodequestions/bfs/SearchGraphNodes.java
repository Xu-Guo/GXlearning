/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if(graph == null || graph.size() == 0 || !graph.contains(node)){
            return null;
        }
        int targetValue = values.get(node);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode curNode = q.poll();
            if(values.get(curNode) == target){
                return curNode;
            }
            if(curNode.neighbors != null && curNode.neighbors.size() != 0){
                for(UndirectedGraphNode child : curNode.neighbors){
                    if(values.get(child) == target){
                        return child;
                    }
                    q.offer(child);
                }
            }
        }
        return null;
    }
}
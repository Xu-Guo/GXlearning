public class 133_CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        //copy nodes
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            UndirectedGraphNode curNode = q.poll();
            if(!map.containsKey(curNode)){
                map.put(curNode, new UndirectedGraphNode(curNode.label));
            }
            for(UndirectedGraphNode neighbor : curNode.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    q.offer(neighbor);
                }
            }
        }

        //copy edges
        for(UndirectedGraphNode originalNode : map.keySet()){
            for(UndirectedGraphNode neighbor : originalNode.neighbors){
                map.get(originalNode).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
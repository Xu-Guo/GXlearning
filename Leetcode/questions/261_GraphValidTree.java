public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        q.offer(0);
        visited[0] = 1;
        while(!q.isEmpty()){
            Integer node = q.poll();
            for(Integer nei : adj.get(node)){
                if(visited[nei] == 1){
                    return false;//has loop, return false
                }
                if(visited[nei] == 0){
                    q.offer(nei);
                    visited[nei] = 1;
                }
            }
            visited[node] = 2;//done
        }
        for(int v : visited){
            if(v == 0){
                return false;//has unvisited node
            }
        }
        return true;
    }
}
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer> list = new ArrayList<>();
        int[] res = new int[numCourses];
        
        int[] degree = new int[numCourses];
        for(int[] pre : prerequisites){
            degree[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i] == 0){
                q.offer(i);
                list.add(i);
            }
        }
        
        while(!q.isEmpty()){
            numCourses--;
            int course = q.poll();
            for(int[] pre : prerequisites){
                if(pre[1] == course){
                    degree[pre[0]]--;
                    if(degree[pre[0]] == 0){
                        list.add(pre[0]);
                        q.offer(pre[0]);
                    }
                }
            }
        }
        
        if(numCourses == 0){
            for(int i=0; i<list.size(); i++){
                res[i] = (int)list.get(i);
            }
            return res;
        }
        return new int[0];
    }
}
public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        if(numCourses == 0){
            return new int[0];
        }
    
        List<List<Integer>> adjList = new ArrayList<>();
        
        int [] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int[] pre : prerequisites){
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        int[] schedule = new int[numCourses];
        int index = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            Integer cur = (int)q.poll();
            schedule[index++] = cur;
            for(Integer course : adjList.get(cur)){
                indegree[course]--;
                if(indegree[course] == 0){
                    q.offer(course);
                }
            }
        }
        
        if(index == numCourses){
            return schedule;
        }
        return new int[0];
    }
}
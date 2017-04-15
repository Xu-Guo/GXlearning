public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
         * BFS with list
         */
        int[] degree = new int[numCourses];

        for(int[] pres : prerequisites){//[course, pre], course的先修课数量+1
            degree[pres[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(degree[i] == 0){
                q.offer(i);//将没有先修课的course加入队列
            }
        }
        while(!q.isEmpty()){
            numCourses--;
            int course = q.poll();//修完一门课（访问了一个节点）
            for(int[] pres : prerequisites){//所有要求此先修课的课程，要修的先修课数量-1
                if(pres[1] == course){
                    degree[pres[0]]--;
                    if(degree[pres[0]] == 0){//此课的所有先修课都修完
                        q.offer(pres[0]);
                    }
                }
            }
        }
        return numCourses == 0;
    }
}
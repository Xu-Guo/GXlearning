/*
    multy-end bfs 
*/
public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int human = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Integer[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    q.offer(new Integer[]{i, j});
                }
                if(grid[i][j] == 0){
                    human++;
                }
            }
        }
        
        //no human
        if(human == 0){
            return 0;
        }
        
        int days = 0;
        while(!q.isEmpty()){
            days++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Integer[] z = q.poll();
                int x = z[0];
                int y = z[1];
                if(isHuman(grid, x + 1, y)){
                    grid[x + 1][y] = 1;
                    human--;
                    if(human == 0){
                        return days;
                    }
                    q.offer(new Integer[]{x + 1, y});
                }
                if(isHuman(grid, x - 1, y)){
                    grid[x - 1][y] = 1;
                    human--;
                    if(human == 0){
                        return days;
                    }
                    q.offer(new Integer[]{x - 1, y});
                }
                if(isHuman(grid, x, y + 1)){
                    grid[x][y + 1] = 1;
                    human--;
                    if(human == 0){
                        return days;
                    }
                    q.offer(new Integer[]{x, y + 1});
                }
                if(isHuman(grid, x, y - 1)){
                    grid[x][y - 1] = 1;
                    human--;
                    if(human == 0){
                        return days;
                    }
                    q.offer(new Integer[]{x, y - 1});
                }
            }
        }
        return -1;
    }
    
    private boolean isHuman(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1){
            return false;
        }
        return grid[i][j] == 0;
    }
}
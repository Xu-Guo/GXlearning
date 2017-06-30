public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    visited[i][j] = true;
                    dfs(grid, i + 1, j, m, n, visited);
                    dfs(grid, i - 1, j, m, n, visited);
                    dfs(grid, i, j + 1, m, n, visited);
                    dfs(grid, i, j - 1, m, n, visited);
                }        
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited){
        if (i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] != '1' || visited[i][j]){
            return;
        }
        grid[i][j] ='0';
        visited[i][j] = true;
        dfs(grid, i + 1, j, m, n, visited);
        dfs(grid, i - 1, j, m, n, visited);
        dfs(grid, i, j + 1, m, n, visited);
        dfs(grid, i, j - 1, m, n, visited);
        visited[i][j] = false;
    }
}
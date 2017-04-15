public class 200_NumberofIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0|| grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    search(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    private void search(char[][] grid, int i, int j, int m, int n){
        if(i<0 || j<0 || i>m-1 || j>n-1 || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '0';
        search(grid, i+1, j, m, n);
        search(grid, i-1, j, m, n);
        search(grid, i, j+1, m, n);
        search(grid, i, j-1, m, n);
    }
}
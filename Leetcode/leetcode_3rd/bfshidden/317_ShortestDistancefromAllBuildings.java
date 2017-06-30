public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        int[][] distance = new int[m][n];
        
        int buildings = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 1){
                    buildings++;
                    bfs(grid, i, j, m, n, distance, visited, new boolean[m][n]);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (visited[i][j] == buildings && distance[i][j] < res){
                    res = distance[i][j];
                }
            }
        }
        
        if (res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    
    private void bfs(int[][] grid, int i, int j, int m, int n, int[][] distance, int[][] visited, boolean[][] reached){
        Queue<Integer> queue = new LinkedList<>();
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        
        queue.offer(i * n + j);
        int steps = 0;
        while(!queue.isEmpty()){
            steps++;
            int size = queue.size();
            for (int a = 0; a < size; a++){
                int point = queue.poll();
                int p = point / n;
                int q = point % n;
                for (int k = 0; k < dx.length; k++){
                    int x = p + dx[k];
                    int y = q + dy[k];
                    if (x >= 0 && y >= 0 && x <= m - 1 && y <= n - 1 && grid[x][y] == 0 && !reached[x][y]){
                        reached[x][y] = true;
                        visited[x][y]++;
                        distance[x][y] += steps;
                        queue.offer(x * n + y);
                    }
                }
            }
        }
    }
}
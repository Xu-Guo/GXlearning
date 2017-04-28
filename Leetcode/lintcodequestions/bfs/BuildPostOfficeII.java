class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    int EMPTY = 0;
    int HOUSE = 1;
    int WALL = 2;
    int[][] grid;
    int m;
    int n;
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        
        //init m, n, local grid
        setGrid(grid);
        
        List<Position> houses = getPositions(HOUSE);
        int[][] distances = new int[m][n];
        int[][] visited = new int[m][n];
        
        for(Position house : houses){
            bfs(house, distances, visited);
        }
        
        int shortest = Integer.MAX_VALUE;
        List<Position> empties = getPositions(EMPTY);
        for(Position empty : empties){
            if(visited[empty.x][empty.y] != houses.size()){
                continue;
            }
            shortest = Math.min(shortest, distances[empty.x][empty.y]);
        }
        if(shortest == Integer.MAX_VALUE){
            return -1;
        }
        return shortest;
    }
    
    private void bfs(Position start, int[][] distances, int[][] visited){
        Queue<Position> q = new LinkedList<>();
        boolean[][] hasVisited = new boolean[m][n];
        q.offer(start);
        
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                Position cur = q.poll();
                for(int j = 0; j < 4; j++){
                    Position adj = new Position(cur.x + dx[j], cur.y + dy[j]);
                    if (!isValid(adj) || hasVisited[adj.x][adj.y]){
                        continue;
                    }
                    q.offer(adj);
                    hasVisited[adj.x][adj.y] = true;
                    distances[adj.x][adj.y] += step;
                    visited[adj.x][adj.y]++;
                }
            }
        }
    }
    
    private List<Position> getPositions(int type){
        List<Position> list = new ArrayList<>(); 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == type){
                    list.add(new Position(i, j));
                }
            }
        }
        return list;
    }
    
    private void setGrid(int[][] grid){
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
    }
    
    private boolean isValid(Position position){
        if(position.x < 0 || position.x > m - 1 || position.y < 0 || position.y > n - 1){
            return false;
        }
        return grid[position.x][position.y] == EMPTY;
    }
    
}
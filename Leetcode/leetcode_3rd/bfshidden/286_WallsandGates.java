public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (rooms[i][j] == 0){
                    queue.offer(i * n + j);
                }
            }
        }
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, -1, 1, 0};
        
        while (!queue.isEmpty()){
            int point = queue.poll();
            int p = point / n;
            int q = point % n;
            for (int k = 0; k < dx.length; k++){
                int x = p + dx[k];
                int y = q + dy[k];
                if (x >= 0 && y >= 0 && x <= m - 1 && y <= n - 1 && rooms[x][y] == Integer.MAX_VALUE){
                    rooms[x][y] = rooms[p][q] + 1;
                    queue.offer(x * n + y);
                }
            }
        }
    }
}
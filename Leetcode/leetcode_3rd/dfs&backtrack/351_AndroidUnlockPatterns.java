public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[4][6] = skip[6][4] = 5;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[2][8] = skip[8][2] = 5;
        skip[3][9] = skip[9][3] = 6;
        skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = 5;
        boolean[] visited = new boolean[10];//0~9
        int count = 0;
        for (int i = m; i <= n; i++){
            count += dfs(visited, skip, 1, i - 1) * 4;
            count += dfs(visited, skip, 2, i - 1) * 4;
            count += dfs(visited, skip, 5, i - 1);
        }
        return count;
    }
    
    private int dfs(boolean[] visited, int[][] skip, int cur, int remain){
        if (remain < 0){
            return 0;
        }
        if (remain == 0){
            return 1;
        }
        int count = 0;
        visited[cur] = true;
        for (int i = 1; i <= 9; i++){
            int s = skip[cur][i];
            if (!visited[i] && (s == 0 || visited[s])){
                count += dfs(visited, skip, i, remain - 1);
            }
        }
        visited[cur] = false;
        return count;
    }
}
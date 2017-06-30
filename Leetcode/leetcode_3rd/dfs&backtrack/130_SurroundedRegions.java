public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }   
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O'){
                    dfs(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == '*'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j){
        int[] dx = new int[]{-1, 0, 0, 1};
        int[] dy = new int[]{0, 1, -1, 0};
        
        board[i][j] = '*';
        
        for (int k = 0; k < dx.length; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if (x > 0 && x < board.length - 1 && y > 0 && y < board[0].length - 1 && board[x][y] == 'O') {
                dfs(board, x, y);
            }
        }
    }
}
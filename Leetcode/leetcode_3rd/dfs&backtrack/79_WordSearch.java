public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0){
            return false;
        }
        if (word == null || word.length() == 0){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n]; 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int start, boolean[][] visited){
        if (start == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if (dfs(board, word, i + 1, j, start + 1, visited) ||
            dfs(board, word, i, j + 1, start + 1, visited) ||
            dfs(board, word, i - 1, j, start + 1, visited) ||
            dfs(board, word, i, j - 1, start + 1, visited)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
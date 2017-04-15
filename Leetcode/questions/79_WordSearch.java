public class 79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length == 0 || board[0].length == 0){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0) && search(board, i, j, new boolean[m][n], word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, boolean[][] visited, String word, int index){
        if(index == word.length()){//find the whole string matching
            return true;
        }
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || visited[i][j] || board[i][j] != word.charAt(index)){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, i+1, j, visited, word, index+1) ||
            search(board, i-1, j, visited, word, index+1) ||
            search(board, i, j+1, visited, word, index+1) ||
            search(board, i, j-1, visited, word, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
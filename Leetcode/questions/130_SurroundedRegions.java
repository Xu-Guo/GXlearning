public class 130_SurroundedRegions {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        // i=0, j->0~n-1
        // i=m-1, j->0~n-1
        // i->0~m-1, j=0
        // i->0~m-1, j=n-1
        

        for(int i=0; i<m; i++){
            if(board[i][0] == 'O') search(board, i, 0, m, n);
            if(board[i][n-1] == 'O') search(board, i, n-1, m, n);
        }
        
        for(int j=0; j<n; j++){
            if(board[0][j] == 'O') search(board, 0, j, m, n);
            if(board[m-1][j] == 'O')search(board, m-1, j, m, n);
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '*'){ 
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void search(char[][] board, int i, int j, int m, int n){
        if(i<0 || j<0 || i>m-1 || j>n-1 || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '*';
        if(i==0){
            search(board, i+1, j, m, n);
        }else if(i==m-1){
            search(board, i-1, j, m, n);
        }else if(j==0){
            search(board, i, j+1, m, n);
        }else if(j==n-1){
            search(board, i, j-1, m, n);
        }else{
            search(board, i+1, j, m, n);
            search(board, i-1, j, m, n);
            search(board, i, j+1, m, n);
            search(board, i, j-1, m, n);
        }
    }
}
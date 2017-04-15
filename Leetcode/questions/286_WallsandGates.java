
public class 286_WallsandGates {
    //dfs
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int m = rooms.length;
        int n = rooms[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int d){
        if(i < 0 || j < 0 || i > rooms.length-1 || j > rooms[0].length-1 || rooms[i][j] < d){
            return;
        }
        rooms[i][j] = d;
        dfs(rooms, i+1, j, d+1);
        dfs(rooms, i-1, j, d+1);
        dfs(rooms, i, j+1, d+1);
        dfs(rooms, i, j-1, d+1);
        
    }


    
}
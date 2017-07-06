class UF {
    int count;
    int[] id;
    
    public UF(char[][] grid){
        count = 0;
        int m = grid.length;
        int n = grid[0].length;
        id = new int[m * n];
        
        //初始化默认所有点不相连
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '1'){
                    count++;
                }
            }
        }
        //初始化所有点的id为自己
        for (int i = 0; i < m * n; i++){
            id[i] = i;
        }
    }
    
    public int find(int p){
        while (p != id[p]){//如果p不是自己老板
            id[p] = id[id[p]];//更新p的老板为p现在老板的老板
            p = id[p];//更新p为自己老板
        }
        //就是将p到其最终老板的路径上所有点都更新成最终老板
        return p;//返回最终老板
    }
    
    public boolean isConnected(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot){
            return false;
        }
        return true;
    }
    
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        id[pRoot] = qRoot;//讲其中一个元素的老板设置成另一个元素就完成connect/union
        count--;
    }
}

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        UF uf = new UF(grid);
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == '0'){
                    continue;
                }
                int p = i * n + j;
                int q;
                //判断边界，如果相邻位置为'1',do union
                if(i > 0 && grid[i - 1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                }
                if(i < m - 1 && grid[i + 1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }
                if(j > 0 && grid[i][j - 1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                }
                if(j < n - 1 && grid[i][j + 1] == '1') {
                    q = p + 1;
                    uf.union(p, q);
                }
            }
        }
        return uf.count;
    }
}
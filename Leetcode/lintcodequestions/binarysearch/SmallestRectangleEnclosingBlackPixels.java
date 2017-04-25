public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
     //StackOverFlow DFS solution
    int up;
    int down;
    int left;
    int right;
    
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        up = x;
        down = x;
        left = y;
        right = y;
        
        int m = image.length;
        int n = image[0].length;
        
        dfs(image, x, y, new boolean[m][n]);
        return (right - left + 1) * (down - up + 1);
    }
    
    private void dfs(char[][] image, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || x > image.length - 1 || y > image[0].length - 1 || image[x][y] != '1' || visited[x][y] ){
            return;
        }
        visited[x][y] = true;
        up = Math.min(up, x);
        down = Math.max(down, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
        dfs(image, x + 1, y, visited);
        dfs(image, x - 1, y, visited);
        dfs(image, x, y + 1, visited);
        dfs(image, x, y - 1, visited);
    }
}


public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    //O(M*N) TLE solution
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        int up = x;
        int down = x;
        int left = y;
        int right = y;
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (image[i][j] != '1'){
                    continue;
                }
                up = Math.min(up, i);
                down = Math.max(down, i);
                left = Math.min(left, j);
                right = Math.max(right, j);
            }
        }
        return (down - up + 1) * (right - left + 1);
    }
}


//accepted binary search solution
public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }
        int m = image.length;
        int n = image[0].length;
        int left = findLeft(image, 0, y);
        int right = findRight(image, y, n - 1);
        int up = findUp(image, 0, x);
        int down = findDown(image, x, m - 1);
        
        return (right - left + 1) * (down - up + 1);
    }
    
    private int findLeft(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(isEmptyColumn(image, start)){
            return end;
        }
        return start;
    }
    
    private int findRight(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (isEmptyColumn(image, mid)){
                end = mid;
            } else {
                start = mid; 
            }
        }
        if (isEmptyColumn(image, end)){
            return start;
        }
        return end;
    }
    
    private int findUp(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)){
                start = mid;
            } else {
                end = mid;
            }
        }
        if(isEmptyRow(image, start)){
            return end;
        }
        return start;
    }
    
    private int findDown(char[][] image, int start, int end){
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (isEmptyRow(image, mid)){
                end = mid;
            } else {
                start = mid;   
            }
        }
        if (isEmptyRow(image, end)){
            return start;
        }
        return end;
    }
    
    private boolean isEmptyColumn(char[][] image, int col){
        for (int i = 0; i < image.length; i++){
            if (image[i][col] == '1'){
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int row){
        for (int i = 0; i < image[0].length; i++){
            if (image[row][i] == '1'){
                return false;
            }
        }
        return true;
    } 
}
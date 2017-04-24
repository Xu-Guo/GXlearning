public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
     //StackOverFlow solution
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
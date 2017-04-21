public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] max = new int[m][n];
        int res = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int len = helper(matrix, max, m, n, i, j, Integer.MAX_VALUE);
                if(len > res){
                    res = len;
                }
            }
        }
        return res;
    }
    
    private int helper(int[][] matrix, int[][] max, int m, int n, int i, int j, int pre){
        if(i < 0|| j < 0 || i > m-1 || j > n-1 || matrix[i][j] >= pre){
            return 0;
        }
        if(max[i][j] > 0){
            return max[i][j];
        }
        int cur = matrix[i][j];
        int maxLen = 0;
        maxLen = Math.max(maxLen, helper(matrix, max, m, n, i+1, j, cur));
        maxLen = Math.max(maxLen, helper(matrix, max, m, n, i-1, j, cur));
        maxLen = Math.max(maxLen, helper(matrix, max, m, n, i, j+1, cur));
        maxLen = Math.max(maxLen, helper(matrix, max, m, n, i, j-1, cur));
        max[i][j] = ++maxLen;
        return maxLen;
    }
}
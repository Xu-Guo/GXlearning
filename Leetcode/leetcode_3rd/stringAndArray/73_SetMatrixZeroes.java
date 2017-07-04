public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false;
        boolean fc = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (matrix[row][col] == 0){
                    if (row == 0){
                        fr = true;
                    }
                    if (col == 0){
                        fc = true;
                    }
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < m; row++){
            for (int col = 1; col < n; col++){
                if (matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }
        if (fr){
            for (int col = 0; col < n; col++){
                matrix[0][col] = 0;
            }
        }
        if (fc){
            for (int row = 0; row < m; row++){
                matrix[row][0] = 0;
            }
        }
        
    }
}
public class 74_Searcha2DMatrix {
    //flatten matrix (x, y)->mid/n , mid%n
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while(l <= r){
            int mid = (l+r) / 2;
            if(matrix[mid/n][mid%n] == target){
                return true;
            }else if(matrix[mid/n][mid%n]<target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return false;
    }
    
    //O(m+n), each time eleminate one row or one col
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row<matrix.length && col>=0){ //start from up right element
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){//must be on the left, col--
                col--;
            }else{//must be underneath
                row++;
            }
        }
        return false;
    }
}
public class 311_SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        
        int[][] res = new int[m][nB];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(A[i][j] != 0){//i行，j列
                    for(int k=0; k<nB; k++){
                        if(B[j][k] != 0){//j行，k列
                            res[i][k] += A[i][j] * B[j][k];//res的i行，k列
                        }
                    }
                }   
            }
        }
        return res;
    }
}
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        int dif = Integer.MAX_VALUE;
        int l = 0;
        int r = A.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] > target){
                r = mid;
            }else{
                l = mid;
            }
        }
        if(A[l] == target){
            return l;
        }
        if(A[r] == target){
            return r;
        }
        if(Math.abs(A[l] - target) > Math.abs(A[r] - target)){
            return r;
        }else{
            return l;
        }
    }    
}
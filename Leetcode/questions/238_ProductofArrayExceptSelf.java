public class 238_ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){//计算preproduct，left->right
            res[i] = res[i-1] * nums[i-1];
        }
        int right = 1;
        for(int i=n-1; i>=0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
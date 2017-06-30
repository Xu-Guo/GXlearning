public class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++){
            if (i % 2 == 0){
                a += nums[i];
                a = Math.max(a, b);
            } else {
                b += nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a,b);
    }
}

public class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] res = new int[n + 1];//res[0] 代表前0个房子， res[n]代表前n个房子

        //初始化无法推出的状态
        res[0] = 0;
        res[1] = nums[0];//nums[0]为第一个房子的价值，nums[n - 1]为最后一个房子的价值

        for (int i = 2; i <= n; i++){
            res[i] = Math.max(res[i - 1], res[i - 2] + nums[i - 1]);
        }
        return res[n];
    }
}
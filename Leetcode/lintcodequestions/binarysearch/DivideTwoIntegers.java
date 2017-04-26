public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
        
        int result = 0;
        
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        //二分solution
        // while(a >= b){
        //     int shift = 0;
        //     while(a >= (b << shift)){
        //         shift++;
        //     }
        //     a -= b << (shift - 1);
        //     result += 1 << (shift - 1);
        // }

        
        //simple 减法。。accepted
        while(a >= b){
            a -= b;
            result++;
        }
        return isNegative? -result: result;
    }
}
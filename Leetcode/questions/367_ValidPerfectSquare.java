public class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        long numl = num;
        while(left + 1 < right){
            long mid = left + (right - left) / 2;
            if(mid * mid == num){//不可以使用除操作，而且注意mid*mid可能会溢出int
                return true;
            }else if(mid * mid > num){
                right = (int)mid;
            }else{
                left = (int)mid;
            }
        }
        if(left * left == num){
            return true;
        }
        if(right * right == num){
            return true;
        }
        return false;
    }
}
public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int left = 1;
        int right = Integer.MAX_VALUE;
        while(true){
            int mid = left+(right-left)/2;
            if(mid > (x / mid)){//need to looking for a smaller number, 这里可以使用除操作，只看结果的整数部分
                right = mid;
            }else{
                if(mid+1 >= x/(mid+1)){
                    return mid;
                }
                left = mid;
            }
        }
    }
}
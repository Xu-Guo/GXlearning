class Pair{
    int sum;
    int index;
    public Pair(int s, int i){
        sum = s;
        index = i;
    }
}

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        
        int len = nums.length;
        if(len == 1){
            res[0] = res[1] = 0;
            return res;
        }
        //构建preSum数组
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);
        for(int i = 1; i <= len; i++){
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        //排序preSum数组，easier to find to sum with min difference
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        
        //找到difference最小的两个sum
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++){
            if(ans > sums[i].sum - sums[i-1].sum){
                ans = sums[i].sum - sums[i-1].sum;
                //注意index要-1，因为preSum数组比原数组多1个元素（0，0）表示前0个数字的和
                int[] temp = new int[]{sums[i].index - 1, sums[i-1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] + 1;//起始位置要+1
                res[1] = temp[1];
            }
        }
        return res;
    }
}

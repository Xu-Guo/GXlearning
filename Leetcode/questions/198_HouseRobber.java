//find a subarray has themax summay without two elements that adjcent to each other 
public class 198_HouseRobber {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for(int i=0; i<nums.length; i++){
            if(i%2 == 0){
                a+=nums[i];
                a = Math.max(a, b);
            }else{
                b+=nums[i];
                b = Math.max(a, b);
            }
        }
        return Math.max(a,b);
    }
}
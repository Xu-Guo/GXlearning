public class 283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length == 0){
            return;
        }
        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[index++] = nums[i];
            }
        }
        for(int i=index; i<nums.length; i++){
            nums[index++] = 0;
        }
    }
}
public class 75_SortColors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int i=0; i<=end; i++){
            if(nums[i] == 0){
                swap(nums, i, start++);
            }else if(nums[i] == 2){
                swap(nums, i--, end--);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
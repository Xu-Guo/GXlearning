public void bubbleSort(int[] nums){
    if(nums == null || nums.length < 2){
        return;
    }
    for(int i=0; i<nums.length; i++){
        for(int j=1; j<nums.length-i; j++){
            if(nums[j-1] > nums[j]){
                swap(nums, j-1, j);
            }
        }
    }
}

private void swap(int[] nums, int i, int j){
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
}
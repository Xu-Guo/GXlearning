public void selectionSort(int[] nums){
    if(nums == null || nums.length < 2){
        return;
    }
    
    for(int i=0; i<nums.length; i++){
        int minIndex = i;
        for(int j = i; j<nums.length; j++){
            if(nums[j] < nums[i]){
                minIndex = j;
            }
        }
        swap(nums, minIndex, i);
    }
}
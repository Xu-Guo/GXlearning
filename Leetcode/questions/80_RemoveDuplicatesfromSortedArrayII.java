public class 80_RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        return removeDuplicatesHelper(nums, 2);
    }
    
    private int removeDuplicatesHelper(int[] nums, int k){//general algrithm to solve the question alow k duplicates
        if(nums == null || nums.length < k){
            return nums.length;
        }
        int i = 1;
        int j = 1;
        int count = 1;
        while(j<nums.length){
            if(nums[j] != nums[j-1]){//不重复，reset count
                count = 1;
                nums[i++] = nums[j];//放
            }else{
                if(count < k){//重复，并且数目不足k，
                    nums[i++] = nums[j];//放
                    count++;//累计数量
                }
            }
            j++;//下一个
        }
        return i;//返回放了多少个
    }
}
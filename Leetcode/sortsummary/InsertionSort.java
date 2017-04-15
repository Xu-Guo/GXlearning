class Solution {
    public static void main(String[] argus){
        int[] numbers = new int[]{9,6,7,8,0,5,2,3,4,1,};
        Solution s = new Solution();
        //s.mergeSort(numbers);
        //s.quickSort(numbers);
        //s.insertionSort(numbers);
        s.bubbleSort(numbers);
        for(int n : numbers){
            System.out.print(n + ",");
        }
    }

     
    public void insertionSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        for(int i=0; i<nums.length; i++){
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]){
                swap(nums, j, j-1);
                j--;
            }
        }
    }


    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
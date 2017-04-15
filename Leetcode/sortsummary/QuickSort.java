class Solution {
    public static void main(String[] argus){
        int[] numbers = new int[]{2,1};
        Solution s = new Solution();
        s.quickSort(numbers);
        for(int n : numbers){
            System.out.print(n + ",");
        }
    }
    
    public void quickSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        
        quickSortHelper(nums, 0, nums.length-1);
    }
    
    private void quickSortHelper(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        
        int pivot = nums[left];
        int i = left;
        int j = right;
        while(i <= j){
            while(i <= j && nums[i] < pivot){
                i++;
            }
            while(i <= j && nums[j] > pivot){
                j--;
            }
            if(i <= j){
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        quickSortHelper(nums, left, j);
        quickSortHelper(nums, i, right);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
class MergeSort {
    public static void main(String[] argus){
        int[] numbers = new int[]{9,7,5,6,8,4,2,3,1,0};
        MergeSort s = new MergeSort();
        s.mergeSort(numbers);
        for(int n : numbers){
            System.out.print(n + ",");
        }
    }
    
    public void mergeSort(int[] nums){
        if(nums == null || nums.length < 2){
            return;
        }
        int[] temp = new int[nums.length];
        mergeSortHelper(nums, temp, 0, nums.length-1);
    }
    
    private void mergeSortHelper(int[] nums, int[] temp, int left, int right){
        if(left >= right){
            return;
        }
        
        int mid = left + (right - left) / 2;
        mergeSortHelper(nums, temp, left, mid);//partition left
        mergeSortHelper(nums, temp, mid+1, right);//partition right
        merge(nums, temp, left, mid, right);//merge left and right
    }
    
    private void merge(int[] nums, int[] temp, int left, int mid, int right){
        int i = left;
        int j = mid+1;
        for(int k=0; k < right - left + 1; k++){//注意需要merge的数组总长度为right-left+1
            if(i <= mid && (j > right || nums[i] < nums[j])){//注意一定先判断i，j是否越界，再比较大小
                temp[k] = nums[i];
                i++;
            }else{
                temp[k] = nums[j];
                j++;
            }
        }
        for(int k=0; k < right - left + 1; k++){//不要忘记把临时数组的元素copy回原来数组！
            nums[left + k] = temp[k];
        }
    }
}
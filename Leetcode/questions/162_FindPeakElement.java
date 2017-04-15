public class 162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 0;
        }
        int l = 0;
        int r = len-1;
        while(l+1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(l == len - 1 || nums[l] > nums[l+1]){
            return l;
        }else{
            return r;
        }
    }

    public int findPeakElement2(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        
        int low = 0;
        int high = nums.length-1;
        
        while(low < high){
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2]){
                low = mid2;
            }else{
                high = mid1;
            }
        }
        return low;
    }
}


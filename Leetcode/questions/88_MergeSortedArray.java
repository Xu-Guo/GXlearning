//merge two array from the tail, at last if there are still nums in nums2, put all of them into nums1
public class 88_MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2 == null || nums2.length ==0){
            return;
        }
        int t1 = m-1;
        int t2 = n-1;
        int tail = m+n-1;
        
        while(t1 > -1 && t2 > -1){
            if(nums1[t1] >= nums2[t2]){
                nums1[tail--] = nums1[t1--];
            }else{
                nums1[tail--] = nums2[t2--];
            }
        }
        while(t2 > -1){
            nums1[tail--] = nums2[t2--];
        }
    }
}
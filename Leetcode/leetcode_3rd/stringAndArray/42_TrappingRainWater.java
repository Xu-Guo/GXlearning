public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3){
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        
        while (left < right && height[left] <= height[left + 1]){
            left++;
        }
        while (left < right && height[right] <= height[right - 1]){
            right--;
        }
        
        int res = 0;
        while (left < right){
            int l = height[left];
            int r = height[right];
            
            if (l <= r){
                while (left < right && l >= height[left + 1]){
                    res += l - height[left + 1];
                    left++;
                }
                left++;
            } else {
                while (left < right && r >= height[right - 1]){
                    res += r - height[right - 1];
                    right--;
                }
                right--;
            }
        }
        return res;
    }
}
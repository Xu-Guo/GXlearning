/*
preorder sequence of a BST: first num is the root, 
follow by some number small than root or not,
then, follow by some number bigger or not,
-Find the right tree start and looking for is there a number < root
    id so after right start,  return false if so
-recursive call the function on the left and the right sub-sequence

*/
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0){
            return true;
        }
        return verify(preorder, 0, preorder.length - 1);
    }
    
    private boolean verify(int[] preorder, int start, int end){
        if (start > end){
            return true;
        }
        int p = preorder[start];
        int rs = -1;//start index of the right subtree
        for (int i = start + 1; i < preorder.length; i++){
            if (rs == -1 && preorder[i] > p){
                rs = i;
            }
            if (rs != -1 && preorder[i] < p){
                return false;
            }
        }
        if (rs == -1){
            return verify(preorder, start + 1, end);
        } else {
            return verify(preorder, start + 1, rs - 1) && verify(preorder, rs, end);
        }
    }
}
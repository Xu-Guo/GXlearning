/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        if(root == null){
            return root;
        }
        if(!contains(root, A) || !contains(root, B)){
            return null;
        }
        if(root == A || root == B){
            return root;
        }
        
        Set<ParentTreeNode> set = new HashSet<>();
        ParentTreeNode node1 = A;
        while(node1 != null){
            set.add(node1);
            node1 = node1.parent; 
        }
        ParentTreeNode node2 = B;
        while(node2 != null && !set.contains(node2)){
            node2 = node2.parent;
        }
        return node2;
    }
    
    private boolean contains(ParentTreeNode root, ParentTreeNode target){
        if(root == null){
            return false;
        }
        if(root == target){
            return true;
        }
        return contains(root.left, target) || contains(root.right, target);
    }
}

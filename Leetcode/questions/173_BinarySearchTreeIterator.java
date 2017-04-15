public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        cur = null;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()){
            return false; 
        }
        cur = stack.pop();
        TreeNode node = cur.right;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        return cur.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
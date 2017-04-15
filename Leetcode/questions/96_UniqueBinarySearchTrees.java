//就跟斐波那契数列一样，我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，
//那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，
//所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。
//n = 2的情况可由下面式子算出：

// dp[2] =  dp[0] * dp[1]　　　(1为根的情况)

// 　　　　+ dp[1] * dp[0]　　  (2为根的情况)

// 同理可写出 n = 3 的计算方法：

// dp[3] =  dp[0] * dp[2]　　　(1为根的情况)

// 　　　　+ dp[1] * dp[1]　　  (2为根的情况)

//  　　　  + dp[2] * dp[0]　　  (3为根的情况)
public class 96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n<2){
            return 1;
        }
        
        int[] num = new int[n+1];
        num[0]=1;
        for(int i=1; i<n+1; i++){
            for(int j = 1; j<i+1; j++){//get number of BST's with 1...i  
                num[i] += num[j-1]*num[i-j];
            }
        }
        return num[n];
    }
}
//二叉树的种类等于左子树和右子树种类之积

public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
        
    }
}
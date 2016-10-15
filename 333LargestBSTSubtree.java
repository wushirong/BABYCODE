
public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        if(isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) return count(root);
        else return Math.max( largestBSTSubtree(root.left), largestBSTSubtree(root.right) ) ;
    }
    
    private boolean isValid(TreeNode tn, int min, int max) {
        if(tn == null) return true;
        if(tn.val > min && tn.val < max) return isValid(tn.left, min, tn.val) && isValid(tn.right, tn.val, max);
        else return false;
    }
    
    private int count(TreeNode tn) {
        if(tn == null) return 0;
        return 1 + count(tn.left) + count(tn.right);
    }
}

//wrap the result with a class
public class Solution {
    class res {
        int res;
        int max;
        int min;
        public res(int res, int max, int min) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }
    public int largestBSTSubtree(TreeNode root) {
        res result = helper(root);
        return Math.abs(result.res);
    }
    
    private res helper(TreeNode tn) {
        if(tn == null) return new res(0, Integer.MIN_VALUE, Integer.MAX_VALUE); 
        res left = helper(tn.left);
        res right = helper(tn.right);
        if(left.res < 0 || right.res < 0|| tn.val < left.max || tn.val > right.min) 
            return new res(-1 * Math.max(Math.abs(left.res), Math.abs(right.res)) , 0, 0);
        else return new res(1 + left.res + right.res, Math.max(tn.val, right.max), Math.min(tn.val, left.min));
    }
}
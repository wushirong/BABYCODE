int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int res = helper(root);
        return Math.max(max, res);
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return root.val;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int plus = Math.max(left, right);
        max = Math.max(max, Math.max(plus + root.val, (left + right + root.val)));
        return root.val + (plus > 0? plus:0);
    }
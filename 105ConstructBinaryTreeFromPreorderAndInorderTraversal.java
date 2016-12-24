public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int prestart, int instart, int inend) {
        if (prestart > preorder.length-1 || inend < instart) return null;
        TreeNode tn = new TreeNode(preorder[prestart]);
        int in = instart;
        for (; in < inend; in++) {
            if (inorder[in] == tn.val) break;
        }
        tn.left = helper(preorder, inorder, prestart+1, instart, in-1);
        tn.right = helper(preorder, inorder, prestart+1 + in-instart, in+1, inend);
        return tn;
    }
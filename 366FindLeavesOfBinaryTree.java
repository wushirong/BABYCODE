public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        helper(root, res);
        return res;
    }
    
    private int helper(TreeNode tn, List<List<Integer>> res) {
        if (tn == null) return 0;
        int level = Math.max(helper(tn.left, res), helper(tn.right, res)) + 1;
        if (res.size() < level) res.add(new ArrayList<Integer>());
        res.get(level-1).add(tn.val);
        return level;
    }
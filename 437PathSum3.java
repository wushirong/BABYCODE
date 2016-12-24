//can use map to get better 
public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        List<Integer> path = new ArrayList<>();
        
        return helper(root, path, 0, sum);
    }
    
    private int helper(TreeNode tn, List<Integer> path, int count, int target) {
        if (tn == null) return count;
        
        List<Integer> newpath = new ArrayList<>();
        for (int cur: path) {
            if (cur - tn.val == 0) {
                count += 1;
                newpath.add(0);
            }
            else newpath.add(cur-tn.val);
        }
        if (target == tn.val) {
            count++;
            newpath.add(0);
        }
        else newpath.add(target - tn.val);
        count = helper(tn.left, newpath, count, target);
        count = helper(tn.right, newpath, count, target);
        return count;
    }
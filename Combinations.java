public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < 1 || k > n) return res;
        boolean[] nums = new boolean[n];
        helper(res, new ArrayList<Integer>(), 0, k, n, nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> item, int index, int k, int n, boolean[] nums) {
        if(index >= k && item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int j = index; j < n; j++) {
            if(! nums[j]){
                nums[j] = true;
                item.add(j + 1);
                helper(res, item, j + 1, k, n, nums);
                item.remove(item.size() - 1);
                nums[j] = false;
            }
        }
    }
}
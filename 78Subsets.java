public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> ini = new ArrayList<Integer>();
        res.add(ini);
        if(nums == null)  return res;
        Arrays.sort(nums);
        res = helper(nums, res);
        return res;
    }
    private List<List<Integer>> helper(int[] nums, List<List<Integer>> res) {
        
        for(int i = 0; i < nums.length; i++) {
            int length = res.size();
            for(int j = 0; j < length; j++) {
                List<Integer> append = new ArrayList<Integer>(res.get(j));
                append.add(nums[i]);
                res.add(append);
            }
        }
        return res;
    }
}
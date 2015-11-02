public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        List<Integer> str = new ArrayList<Integer>();
        str.add(nums[0]);
        res.add(str);

        
        for(int i= 1; i < nums.length; i++) {
            res = helper(i, nums, res);
        }
        return res;
    }
    private List<List<Integer>> helper(int index, int[] nums, List<List<Integer>> res) {
        List<Integer> newstr = new ArrayList<Integer>();
        int length = res.size();
        for(int i = 0; i < length; i++) {
            newstr = res.get(0);
            res.remove(0);
            for(int j = 0; j < newstr.size() + 1; j++) {
                List<Integer> append = new ArrayList<Integer>(newstr);
                if(j < newstr.size()) append.add(j, nums[index]);
                else append.add(nums[index]);
                if(!res.contains(append)) res.add(append);
            }
        }
        return res;
    }
}

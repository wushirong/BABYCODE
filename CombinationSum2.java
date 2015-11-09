public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res =  new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0 || target < 0) return res;
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<Integer>(), res, 0);
        return res;
    }
    
    private void helper(int[]candidates, int target, ArrayList<Integer> item, List<List<Integer>> res, int index) {
        if(target < 0) return;
        else if(target == 0) {
            if(!res.contains(item)) res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            item.add(candidates[i]);
            helper(candidates, target - candidates[i], item, res, i + 1);
            item.remove(item.size() - 1);
            if(target < 0) break;
        }
    }
}
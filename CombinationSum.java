public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, target, candidates);
        return res;
    }
    
    private void helper(List<List<Integer>> res, ArrayList<Integer> item, int index, int target, int[] candidates) {
        if(target < 0) return;
        else if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            item.add(candidates[i]);
            helper(res, item, i , target - candidates[i], candidates);
            item.remove(item.size() - 1);
            if(target <= candidates[i]) break;
        }
    }
}
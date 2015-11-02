public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n < k || k < 1) return res;
        
        helper(k, n, res, new ArrayList<Integer>(), 1, 0);
        return res;
    }
    
    private void helper(int k, int n,List<List<Integer>> res, ArrayList<Integer> item, int index, int count) {
        if(n != 0 && count == k) return;
        else if(n == 0 && k == count) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = index; i < 10; i++) {
            item.add(i);
            helper(k, n - i, res, item, i + 1, count + 1);
            item.remove(item.size() - 1);
            if(n <= i ) break;
        }
    }
}
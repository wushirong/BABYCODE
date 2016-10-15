public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        return helper(nestedList, 1, 0);
    }
    
    private int helper(List<NestedInteger> nl, int level, int sum) {
        if(nl == null || nl.size() == 0) return sum;
        for(NestedInteger item: nl) {
            if(item.isInteger()) {
                sum += item.getInteger() * level;
            }
            else {
                sum = helper(item.getList(), level + 1, sum);
            }
        }
        return sum;
    }
}
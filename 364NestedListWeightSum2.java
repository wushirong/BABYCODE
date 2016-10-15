public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) return 0;
        int depth = findDepth(nestedList, 1);
        return visit(nestedList, 0, depth);
    }
    
    private int findDepth(List<NestedInteger> nestedList, int dep) {
        int max = dep;
        for(int i = 0; i < nestedList.size(); i++) {
            NestedInteger cur = nestedList.get(i);
            if(!cur.isInteger()) max = Math.max(max, findDepth(cur.getList(), dep + 1));
        }
        return max;
    }
    private int visit (List<NestedInteger> list, int step, int depth) {
        int res = 0;
        for( int i = 0; i < list.size(); i++) {
            NestedInteger cur = list.get(i);
            if(cur.isInteger()) {
                res += cur.getInteger() * (depth - step);
            }
            else {
                res += visit(cur.getList(), step + 1, depth);
            }
        }
        return res;
    } 
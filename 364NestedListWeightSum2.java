//using prev and levelsum to help calculate depth inside sum
public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for (NestedInteger each: nestedList) queue.offer(each);
        int prev = 0;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelsum = 0;
            
            for (int i = 0; i < size; i++) {
                NestedInteger cur = queue.poll();
                if (cur.isInteger()) levelsum += cur.getInteger();
                else {
                    for(NestedInteger item: cur.getList()) queue.offer(item);
                }
            }
            prev += levelsum;
            res += prev;
        }
        return res;
    }

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
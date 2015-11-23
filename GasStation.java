public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost == null) return -1;
        int i, j, n = gas.length;
        for( i = 0; i < n; i += j) {
            int reach = 0;
            for( j = 1; j <=n; j++) {
                int station = (j + i - 1) % n;
                reach += gas[station] - cost[station];
                if(reach < 0) break;
            }
            if(j > n) return i;
        }
        return -1;
    }
}
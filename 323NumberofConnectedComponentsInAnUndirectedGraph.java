//bucket sort
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0) return n;
  
        int[] roots = new int[n];
        for(int i = 0; i < n; i++ ) roots[i] = i;
        for(int[] edge: edges) {
            int root1 = helper(roots, edge[0]);
            int root2 = helper(roots, edge[1]);
            if (root1 != root2) {
               roots[root2] = root1;
               n--;
            }
        }
        return n;
    }
    
    private int helper(int[] roots, int target) {
        int i = target;
        while(i != roots[i]) {
            i = roots[roots[i]];
        }
        return i;
    }
}
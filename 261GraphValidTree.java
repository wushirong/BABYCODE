public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] record = new int[n];
        for(int i = 0; i < n; i++) record[i] = i;
        
        for(int[] edge: edges) {
            int root1 = finder(record, edge[0]);
            int root2 = finder(record, edge[1]);
            if(root1 == root2) return false;
            else {
                if(root1 < root2) record[edge[1]] = root1;
                else record[edge[0]] = root2;
                n--;
            }
        }
        return n == 1;
    }
    
    private int finder(int[] record, int target) {
        int i = target;
        while(i != record[i]) {
            i = record[record[i]];
        }
        return i;
    }
}
public class Solution {
    public int numSquares(int n) {
        if (n <= 0 ) return 0;
        int[] res = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int minval = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minval = Math.min(minval, res[i - j*j] + 1);
            }
            res[i] = minval;
        }
        return res[n];
    }
}
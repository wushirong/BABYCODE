public class Solution {
    public int climbStairs(int n) {
        if(n < 1) return 0;
        if(n == 1) return 1;
        
        int[] steps = new int[n + 1];
        steps[2] = 2;
        steps[1] = 1;
        for(int i = 3; i <= n; i++) {
            steps[i] = steps[i - 2] + steps[i - 1];
        }
        return steps[n];
    }
}

// using O1 space
public class Solution {
    public int climbStairs(int n) {
        if(n < 1) return 0;
        if(n == 1) return 1;
        int steps1 = 1;
        int steps2 = 1;
        int steps3 = steps1 + steps2;
        for(int i = 2; i <= n; i++) {
            steps3 = steps1 + steps2;
            steps1 = steps2;
            steps2 = steps3; 
        }
        return steps3;
    }
}
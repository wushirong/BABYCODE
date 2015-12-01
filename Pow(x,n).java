public class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || n == 0) return 1;
        if(n == 1) return x;
        if(n < 0) {
            x = 1 / x;
            n = -n;
        }
       if(n % 2 == 0) return myPow(x*x, n/2);
       else return x * myPow(x, n - 1);
    }
}
//converge to long can avoid Integer.MIN_VALUE problem
public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        long ldividend = (long)dividend;
        long ldivisor = (long)divisor;
        long res = helper(ldividend, ldivisor);
        return res > Integer.MAX_VALUE? Integer.MAX_VALUE: (int) res;
    }
    private long helper(long dividend, long divisor) {
        long res = 1;
        boolean neg = dividend < 0 != divisor < 0;
        if(dividend < 0) dividend = -dividend;
        if(divisor < 0) divisor = -divisor;
        long sum = divisor;
        if(dividend < divisor) return 0;
        while(sum + sum <= dividend) {
            sum += sum;
            res += res;
        }
        return neg? -(res + helper(dividend - sum, divisor)): (res + helper(dividend - sum, divisor));
    }

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0 || divisor == 0) return 0;
        boolean neg = (long)dividend < 0 != (long)divisor < 0;
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        
        long res = divideLong(ldividend, ldivisor);
        return neg? (int)(0 - res): (res > Integer.MAX_VALUE? Integer.MAX_VALUE: (int)res);
    }
    
    private long divideLong(long dividend, long divisor) {
        if(dividend < divisor) return 0;
        boolean neg = dividend < 0 != divisor < 0;
        long sum = divisor;
        long res = 1;
        // if(dividend < 0) dividend  = -dividend;
        // if(divisor < 0) divisor = -divisor;
        if(divisor == dividend) return neg? -1: 1;
        else if(dividend < divisor) return 0;
        while(sum+sum <= dividend) {
            res+= res;
            sum += sum;
        }
        return neg? -res - divideLong(dividend - sum, divisor) : res + divideLong(dividend - sum, divisor);
    }
}
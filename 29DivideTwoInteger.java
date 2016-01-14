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
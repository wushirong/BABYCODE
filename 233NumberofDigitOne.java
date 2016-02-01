//this is a math problem. Figure out the mathemetical realtion and then answer is as follow
// another thing is that i and front should be set to long to avoid int digit exceed
public class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for(long i = 1; i <= n; i = i * 10) {
            long front = n / i, end = n % i;
            res += (front + 8) / 10 * i + (front % 10 == 1? end + 1 : 0);
        }
        return res;
    }
}
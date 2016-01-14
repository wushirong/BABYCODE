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
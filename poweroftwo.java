public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 1) return false;
        int num = n;
        while(num != 1) {
            if(num % 2 != 0) return false;
            num = num / 2;
        }
        return true;
    }
}
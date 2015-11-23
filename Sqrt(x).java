public class Solution {
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        if(x == 1) return 1;
        int hi = 1 + x / 2;
        int lo = 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(mid <= x/mid && mid + 1 > x/(mid + 1)) return mid;
            if(mid > x/mid) hi = mid - 1;
            else lo =  mid + 1;
        }
        return 0;
    }
}
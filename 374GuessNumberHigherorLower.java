public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int hi = n;
        int lo = 1;
        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            if (guess(mid) > 0) lo = mid+1;
            else if (guess(mid) == 0) return mid;
            else hi = mid-1;
        }
        return lo;
    }
}
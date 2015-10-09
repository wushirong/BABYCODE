public class Solution {
    public int reverse(int x) {
        
        int res = 0;
        int num = (x < 0)? -x : x;
        
        while(num>0) {
            if(res > (double)(Integer.MAX_VALUE- num % 10) / 10) return 0;
            res = res * 10 + num % 10;
            num = num /10;
        }
        if(x < 0) return -res;
        else return res;
    }
}
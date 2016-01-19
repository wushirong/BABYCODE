
// all trailing zero come from 5 in factorial, thus counting how many 5 is contained equals the number of 0
public int trailingZeroes(int n) {
        return n == 0? 0:n / 5 + trailingZeroes(n / 5);
    }

public class Solution {
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        int num5 = 0;
        
        for(int i = n/5; i > 0; i = i / 5){
            num5 += i;
        }
        return num5;
    }
}
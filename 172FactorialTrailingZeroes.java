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
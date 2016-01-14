public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int length = 1;
        int num = x;
        while(num >= 10) {
            length *= 10;
            num /= 10;
        }
        while(x > 0) {
            if(x / length != x % 10) return false;
            x = (x % length) / 10;
            length /= 100;
            
        }
        return true;
    }
}
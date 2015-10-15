public class Solution {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        str = str.trim();
        int count = 0;
        int index = 0;
        boolean isNeg = false;
        int sum = 0;
        while(index < str.length()) {
            char c = str.charAt(index);
            if(count > 1) return 0;
            if(c != '-' && c !='+') break;
            else if(c == '-') isNeg = true;
            count ++;
            index ++;
        }
        while(index < str.length()) {
            char c = str.charAt(index);
            int num = c - '0';
            if(num < 0 || num > 9) break;
            // whether index out of bound
            if(!isNeg && sum > (double)((Integer.MAX_VALUE - num) / 10)) return Integer.MAX_VALUE;
            if(isNeg && -sum < (double)((Integer.MIN_VALUE + num) / 10)) return Integer.MIN_VALUE;
            sum = sum * 10 + num;
            index ++;
        }
        return isNeg? -sum : sum;
    }
}
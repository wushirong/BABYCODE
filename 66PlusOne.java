public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        boolean carry = true;
        int length;
        for(int i = 0; i < digits.length; i++) {
            if(digits[i] != 9) carry = false;
        }
        if(carry) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        else {
            int index = digits.length - 1;
            digits[index ] = digits[index] + 1 > 9? 0: digits[index] + 1;
            boolean ten = digits[index] == 0;
            for(int i = index - 1; i >= 0; i--) {
                if(ten) {
                    digits[i] = digits[i] + 1 > 9? 0: digits[i] + 1;
                    ten = digits[i] == 0;
                }
            }
            return digits;
        }
    }
}
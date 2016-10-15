public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n = n >> 1;
        }
        return res;
    }

//>>> means moving bite to right with adding 0 instead of what should be 
public int reverseBits(int n) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if(i < 31) res <<= 1;
        }
        return res;
    }
//正数负数直接转换和二进制计算间有显著差异

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] digits = new int[32];
        int res = 0;
        if(n < 0) {
            digits[31] = 1;
            n = n ^ Integer.MIN_VALUE;
        }
        for(int i = 0; i < 31; i++) {
            digits[i] = n % 2;
            n /= 2;
        }
        for(int i = 1; i < 32; i++) {
            res  = res * 2 + digits[i];
        }
        return digits[0] == 1? res | Integer.MIN_VALUE: res;
    }
}
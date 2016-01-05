public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(denominator == 0) return sb.toString();
        else if(numerator == 0) return "0";
        boolean neg = false;
        if((numerator ^ denominator) < 0) neg = true;
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if(denominator < -Integer.MAX_VALUE) numerator = numerator < 0? numerator: - numerator;
        long res = numerator / denominator;
        sb.append(res);
        if(res < 0) sb.delete(0,1);
        
        numerator %= denominator;
        if(numerator != 0) sb.append(".");
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int index = sb.indexOf(".") + 1;
        long n = numerator;
        while(true) {
            if(n == 0) break;
            n *= 10;
            if(map.containsKey((int)n)) {
                int key = map.get((int)n);
                sb.insert(key, '(').append(')');
                break;
            }
            else map.put((int)n, index++);
            sb.append(Math.abs(n / denominator));
            n = n % denominator;
        }
        
        return neg? sb.insert(0, '-').toString(): sb.toString();
    }
}
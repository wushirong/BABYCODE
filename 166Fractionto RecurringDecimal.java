//clean version. Using hashmap to store teh numerator of every step and check whehter
//an endless loop is formed. Corner case is speically handled in the end.
public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        boolean nonneg = (numerator < 0) == (denominator < 0);
        long numL = Math.abs(numerator);
        long denL = Math.abs(denominator);
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        long res = numL / denL;
        numL %= denL;
        sb.append(res);
        if(numL != 0) sb.append(".");
        int index = sb.indexOf(".") + 1;
        while(numL != 0) {
            numL *= 10;
            if(map.containsKey(numL)) {
                sb.insert(map.get(numL), "(");
                sb.append(")");
                break;
            }
            else {
                map.put(numL, index++);
            }
            sb.append(Math.abs(numL / denL));
            numL %= denL;
        }
        if(denominator < -Integer.MAX_VALUE) sb.toString();
        if(numerator < -Integer.MAX_VALUE) {
            if(denominator < 0) return sb.delete(0, 1).toString();
            else return sb.toString();
        }
        else return nonneg? sb.toString(): sb.insert(0, "-").toString();
    }

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
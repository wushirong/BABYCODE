public class Solution {
    public int countPrimes(int n) {
        if(n < 2) return 0;
        int count =  0;
        boolean[] record = new boolean[n];

        for(int i = 2; i * i < n; i++) {
            if(record[i]) continue;
            for(int j = i*i; j < n; j += i) {
                if(!record[j] ){
                    record[j] = true;
                    count++;
                }
            }
        }
        return n-2-count;
    }
}
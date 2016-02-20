public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] index = new int[primes.length];
        int[] val = new int[primes.length];
        
        int next = 1;
        Arrays.fill(val, 1);
        for(int i = 0; i < n; i++) {
            ugly[i] = next;
            next = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                if(ugly[i] == val[j]) val[j] = ugly[index[j]++] * primes[j];
                next = Math.min(next, val[j]);
            }
            
        }
        return ugly[n-1];
    }

public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0) return 0;
         PriorityQueue<Num> pq = new PriorityQueue<>();
         int[] ugly = new int[n];
         for(int each: primes) pq.add(new Num(each, 1, each));
         ugly[0] = 1;
         for(int i = 1; i < n; i++) {
             ugly[i] = pq.peek().val;
             while(ugly[i] == pq.peek().val) {
                 Num cur = pq.poll();
                 pq.add(new Num(cur.p*ugly[cur.index], cur.index + 1, cur.p));
             }
         }  

         return ugly[n-1];
    }
    private class Num implements Comparable<Num> {
        int val;
        int index;
        int p;
        
        public Num(int val, int index, int p) {
            this.val = val;
            this.index = index;
            this.p = p;
        }
        public int compareTo(Num that) {
            return this.val - that.val;
        }
    }
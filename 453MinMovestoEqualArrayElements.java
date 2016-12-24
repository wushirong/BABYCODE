//math problem: (minHeight + m(step of move)) * len = sumOfElements + (len-1)*m;
public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int n: nums) {
            min = Math.min(min, n);
            sum += n;
        }
        return sum - min*len;
        
    }
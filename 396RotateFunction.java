public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
     
        int sum = 0;
        int candidate = 0;
        for (int i = 0; i < A.length; i++){
            sum += A[i];
             candidate += i * A[i];
        }
        int max = candidate;
        for (int i = A.length - 1; i > 0; i--) {
            candidate = candidate + sum - A.length * A[i];
            max = Math.max(max, candidate);
        }
        return max;
    }
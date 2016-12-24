public int candy(int[] ratings) {
        
        if (ratings == null || ratings.length == 0) return 0;
        int len = ratings.length;
        
        int[] candy = new int[len];
        Arrays.fill(candy, 1);
        for (int i = 0; i < len-1; i++) {
            if (ratings[i] < ratings[i+1]) candy[i+1] = candy[i]+1;
        }
        int count = candy[len-1];
        for (int i = len-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) candy[i] = candy[i+1]+1;
            count += candy[i];
        }
        return count;
    }
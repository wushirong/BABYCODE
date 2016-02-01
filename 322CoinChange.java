//very important to use dynamic programming, try also use recursive next time
public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int sum = 1;
        
        int[] track = new int[amount + 1];
        
        while(sum <= amount) {
            int min = -1;
            for(int coin: coins) {
                if(sum >= coin && track[sum - coin] != -1) {
                    int temp = track[sum - coin] + 1;
                    min = min < 0? temp: (temp < min? temp: min);
                }
            }
            track[sum] = min;
            sum++;
        }
        return track[amount] <= 0? -1: track[amount];
    }
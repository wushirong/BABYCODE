public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;
        int[] record = new int[amount + 1];
        int l = coins.length;
        int min = 0;
        for(int i = 0; i < l; i++) if (coins[i] <= amount) record[coins[i]] = 1; 
        
        for(int i = 1; i < amount + 1; i++) {
            for(int j = 0; j < l; j++) {
                if(record[i] == 0 || (i + coins[j] > amount)) continue;
                else if ((record[i + coins[j]] == 0) || (record[i + coins[j]] > record[i] + 1)) 
                    record[i + coins[j]] = record[i] + 1; 
            }
        }
        
        return record[amount] == 0? -1: record[amount];
    }
}

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
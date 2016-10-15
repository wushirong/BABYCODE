public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        if(updates == null || updates.length == 0) return res;
        
        for(int[] update: updates) {
            res[update[0]] += update[2];
            int end = update[1];
            if(update[1] + 1 < length) res[update[1] + 1] -= update[2];
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }
        
        return res;
    }
}
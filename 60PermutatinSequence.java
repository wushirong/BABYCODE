public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < n; i++) num.add(i+1);
        int[] counts = new int[n];
        counts[0] = 1;
        for (int i = 1; i < n; i++) counts[i] = i*counts[i-1];
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 0; i < n; i++) {
            int index = k / counts[n-i-1];
            k = k % counts[n-i-1];
            sb.append(num.get(index));
            num.remove(index);
        }
        return sb.toString();
    }

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder res = new StringBuilder();
        int[] nums = new int[10];
        int fact = 1;
        int index = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = i + 1;
            fact *= (i + 1);
        }
        k--;
        for(int i = 0; i < n; i++) {
            fact = fact/(n - i);
            index = k / fact;
            res.append(nums[index]);
            for(int j = index; j < n; j++) nums[j] = nums[j+1];
            k %= fact;
        }
        return res.toString();
    }
    
}
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) return new LinkedList<Integer>();
        Arrays.sort(nums);
        List<Integer> res = new LinkedList<Integer>();
        int max = 0;
        int maxIndex = 0;
        int l = nums.length;
        int[] pre = new int[l];
        int[] count = new int[l];
        
        for(int i = 0; i < l; i++) {
            int cur = nums[i];
            pre[i] = -1;
            count[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(cur % nums[j] == 0 && (1 + count[j] > count[i])) {
                    pre[i] = j;
                    count[i] = count[j] + 1;
                } 
            }
            if(max < count[i]) {
                max = count[i];
                maxIndex = i;
            }
        }
        
        while(maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        return res;
    }
}
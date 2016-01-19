//using bucket sort, two bucket. One store array in order without the max value, 
//and the other bucket store array in order withou the min value

public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        //find min and max value in the array
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min ) min = nums[i];
            if(nums[i] > max ) max = nums[i];
        }

        //determine gap in bucket
        int step = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        
        //put numbers into correspondent bucket in MIN/MAX array
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == min || nums[i] == max) continue;
            else {
                int index = (nums[i] - min)/step;
                bucketMin[index] = Math.min(bucketMin[index], nums[i] );
                bucketMax[index] = Math.max(bucketMax[index], nums[i] );
            }
        }
        
        //find max gao 
        int prev = min;
        for(int i = 0; i < nums.length - 1; i++) {
            if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}
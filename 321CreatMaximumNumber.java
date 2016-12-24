public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length + nums2.length < k) return null;
        int[] res = new int[k];
        for (int i = Math.max(0, k-nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] sub1 = maxArray(nums1, i);
            int[] sub2 = maxArray(nums2, k-i);
            int[] cur = merge(sub1, sub2, k);
            res = greater(res, 0, cur, 0)? res: cur;
        }
        return res;
    }
    
    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i=0, j = 0, x = 0; x < k; x++) {
            res[x] = greater(nums1, i, nums2, j)? nums1[i++]:nums2[j++]; 
        }
        return res;
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while ( i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
    
    private int[] maxArray(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (nums.length-(i-j) > k && j > 0 && nums[i] > res[j-1]) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
}
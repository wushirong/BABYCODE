public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0;
        int hi = nums.length-1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi] ) lo = mid+1;
            else if (nums[mid] < nums[hi] ) hi = mid;
            else hi--;
        }
        return Math.min(nums[lo], nums[hi]);
    }
public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k % nums.length == 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            nums[l] ^= nums[r];
            nums[r] ^= nums[l];
            nums[l++] ^= nums[r--];
        }
    }

//basic slow solution
public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k % nums.length == 0) return;
        int len = nums.length;
        k = k % len;
        int[] store = new int[k];
        int i = len-1;
        for (; i >= len-k; i--) store[i-(len-k)] = nums[i];
        for (; i >= 0; i--) nums[i+k] = nums[i];
        for (int j = 0; j < k; j++) nums[j] = store[j];
    }
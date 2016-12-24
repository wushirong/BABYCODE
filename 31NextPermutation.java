// find the first num[i] > num[i-1], swap num[i-1] with the first number in [i, len] that is bigger than num[i-1], sort[i, len];
public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = nums.length-1; i > 0; i--) {
                if (nums[i] > nums[i-1]) {
                    for (int j = nums.length-1; j >= i; j--) {
                        if (nums[j] > nums[i-1]) {
                            int temp = nums[i-1];
                            nums[i-1] = nums[j];
                            nums[j] = temp;
                            Arrays.sort(nums, i, nums.length);
                            return;
                        }
                    }
                }
            
        }
        Arrays.sort(nums);
    }
public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int l = nums.length;
        int[] res = Arrays.copyOf(nums, l);
        Arrays.sort(res);
        for(int i = 0; i < l/2; i++) {
            nums[2 * i] = res[i];
            nums[2 * i + 1] = res[l - 1 - i];
        }
        if(l % 2 == 1) nums[l - 1] = res[l / 2];

    }
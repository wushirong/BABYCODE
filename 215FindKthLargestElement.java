    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        int index = partition(nums, 0, nums.length-1);
        int target = nums.length - k;
        int start = 0;
        int end = nums.length-1;
        while (index != target) {
            if (index < target) start = index+1;
            else end = index-1;
            index = partition(nums, start, end);
        }
        return nums[index];
    }
    
    private int partition(int[] nums, int start, int end) {
        if (start == end) return end;
        int init = nums[start];
        int i = start;
        int j = end+1;
        while (i < j) {
            while (nums[++i] < init) if (i == end) break;
            while (nums[--j] > init) if (j == start) break;
            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, start, j);
        return j;
    }
    
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
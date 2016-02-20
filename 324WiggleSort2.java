//not best, best solution can be in place
public void wiggleSort(int[] nums) {
        if(nums == null || nums.length < 2) return;
        int l = nums.length;
        int mid = l%2 == 0? l/2-1:l/2;
        int[] sort = Arrays.copyOf(nums, l);
        Arrays.sort(sort);
        int index = 0;
        for(int i = 0; i <= mid; i++) {
            nums[index] = sort[mid - i];
            if(index+1 < l) nums[index+1] = sort[l - 1 - i];
            index += 2;
        }

    }
public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i]-1)%nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) if (nums[i] <= nums.length) res.add(i+1);
        return res;
    }
public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int[] record = new int[target + 1];
        for(int i = 1; i < target + 1; i++) {
            for(int num: nums) {
                if(num > i) continue;
                else if(num == i) record[num] += 1;
                else if(num < i) record[i] += record[i - num];
            }
        }
        return record[target];
    }

//TML
public int combinationSum4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        ArrayList<ArrayList<Integer>> res = helper(nums, target);
        return res.size();
    }
    
    private ArrayList<ArrayList<Integer>> helper(int[] nums, int target) {
        if(target == 0) return new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur < target) {
                ArrayList<ArrayList<Integer>> result = helper(nums, target - cur);
                for(ArrayList<Integer> each: result) {
                    each.add(cur);
                    res.add(each);
                }
            }
            else if(cur == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(cur);
            }
        }
        return res;
    }
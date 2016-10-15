int[] original;
    int[] shuffle;
    Random random;
    public Solution(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
        shuffle = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int curIndex = 0;
        while (curIndex < original.length) {
            int r =  random.nextInt(curIndex+1);
            int temp = shuffle[r];
            shuffle[r] = shuffle[curIndex] ;
            shuffle[curIndex] = temp;
            curIndex++;
        }
        return shuffle;
    }
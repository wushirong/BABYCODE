public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int median = findMid(nums, (nums.length+1)/2);
        int n = nums.length;
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            int temp = newIndex(i,n);
            if (nums[newIndex(i,n)] > median) {
                exch(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                exch(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }
    }
    
    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    public int findMid(int[] nums, int k) {
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
}

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
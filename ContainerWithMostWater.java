public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int hi = height.length - 1;
        int lo = 0; 
        int max = 0;
        while(lo <= hi) {
            int water = Math.min(height[lo], height[hi]) * (hi - lo);
            max = water > max? water: max;
            if(height[lo] > height[hi]) hi --;
            else lo++;
        }
        return max;
    }
}
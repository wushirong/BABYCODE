public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        Set<Integer> res = new HashSet<Integer>();
        while(p1 < nums1.length && p2 < nums2.length) {
            if(nums1[p1] > nums2[p2]) p2++;
            else if(nums1[p1] < nums2[p2]) p1++;
            else {
                res.add(nums1[p1]);
                p2++;
                p1++;
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for(int item: res) {
            result[i++] = item;
        }
        return result;
    }
}
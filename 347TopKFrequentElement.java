//bucket sort, list as buckets
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<Integer>();
        List<Integer>[] list = new List[nums.length + 1];
        for(int item: map.keySet()) {
            int count = map.get(item);
            if (list[count] == null) list[count] = new ArrayList<Integer>();
            list[count].add(item);
        }
        for(int i = nums.length ; i >= 0 && res.size() < k; i--) {
            if (list[i] != null) res.addAll(list[i]);
        }
        return res;
    }

}
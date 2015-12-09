public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) return 0;
        int n = triangle.get(triangle.size() - 1).size();
        int[] last = new int[triangle.get(0).size()];
        last[0] = triangle.get(0).get(0);
        
        for(int i = 1; i < triangle.size(); i++) {
            int len = triangle.get(i).size();
            int[] current = new int[len];
            for(int j = 0; j < len; j++) {
                int element = triangle.get(i).get(j);
                if(j == 0) current[j] = last[j] + element;
                else if(j == len - 1) current[j] = last[j - 1] + element;
                else current[j] = Math.min(last[j] + element, last[j - 1] + element);
            }
            last = current;
        }
        int min = Integer.MAX_VALUE;
        for(int i: last) {
            min = Math.min(min, i);
        }
        return min;
    }
}
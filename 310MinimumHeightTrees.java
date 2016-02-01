public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new LinkedList<Integer>();
        if(n == 1) {
            res.add(0);
            return res;
        }
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        int[] degree = new int[n];
        
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < degree.length; i++) {
            if(degree[i] == 0) return res;
            else if(degree[i] == 1) queue.offer(i);
        }
        
        while(! queue.isEmpty()) {
            res = new LinkedList<Integer>();
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                degree[cur]--;
                for(int j = 0; j < graph.get(cur).size(); j++) {
                    int next = graph.get(cur).get(j);
                    if(degree[next] == 0) continue;
                    if(degree[next] == 2) {
                        queue.offer(next);
                    }
                    degree[next]--;
                }
            }
        }
        return res;
    }
}
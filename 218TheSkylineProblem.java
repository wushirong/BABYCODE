//check based on the height
public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<int[]>();
        List<int[]> height = new LinkedList<int[]>();
        if(buildings == null || buildings.length == 0) return res;
        for(int[] b: buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }
        Collections.sort(height, (a,b)-> {
            if(a[0] != b[0])
                return a[0] - b[0];
            else return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->b-a);
        int prev = 0;
        pq.offer(0);
        for(int[] h: height) {
            if(h[1] < 0) pq.offer(-h[1]);
            else pq.remove(h[1]);
            int cur = pq.peek();
            if(prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
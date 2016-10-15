public class Solution {
    private static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0 ,-1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer>();
        UF uf = new UF(m, n);
        for(int[] position: positions) {
            int id = uf.add(position[0], position[1]);
            for(int[] dir: dirs) {
                int getID = uf.getID(position[0] + dir[0], position[1] + dir[1]);
                if(getID > 0 && !uf.find(id, getID)) {
                    uf.union(id, getID);
                }
            }
            res.add(uf.size());
        }
        return res;
    }
    private class UF {
        int[] id;
        int[] size;
        int m, n, count;
        
        public UF(int x, int y) {
            this.m = x;
            this.n = y;
            id = new int[x * y + 1];
            size = new int[x * y + 1];
            count = 0;
        }
        
        public int index(int x, int y) {
            return x * n + y +1;
        }
        public int getID(int x, int y) {
            if(x >= 0 && x < m && y >= 0 && y < n) return id[index(x,y)];
            else return 0;
        }
        public int size() {
            return count;
        }
        
        public int add(int x, int y) {
            int index = index(x, y);
            size[index] = 1;
            id[index] = index;
            count++;
            return index;
        }
        
        public boolean find(int x, int y) {
            return root(x) == root(y);
        }
        public int root(int x) {
            while(id[x] != x ) {
                id[x] = id[id[x]];
                x = id[x];
            }
            return x;
        }
        public void union(int x, int y) {
            int rootx = root(x);
            int rooty = root(y);
            if(rootx == rooty) return;
            else if(size[rootx] > size[rooty] ) {
                size[rootx] += size[rooty];
                id[rooty] = rootx;
                count--;
            }
            else {
                size[rooty] += size[rootx];
                id[rootx] = rooty;
                count--;
            }
            
        }
    }
}
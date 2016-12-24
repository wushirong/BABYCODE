//implementation of minstack
class Tuple implements Comparable<Tuple> {
        int val;
        int row ;
        int col;
        public Tuple(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
        
        @Override
        public int compareTo(Tuple t2) {
            return this.val - t2.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Tuple> queue = new  PriorityQueue<Tuple>();
        for (int i = 0; i < col; i++) queue.offer(new Tuple(matrix[0][i], 0, i));
        for (int i = 0; i < k - 1; i++) {
            Tuple tp = queue.poll();
            if(tp.row == row - 1) continue;
            queue.offer(new Tuple(matrix[tp.row + 1][tp.col], tp.row + 1, tp.col));
        }
        return queue.poll().val;
    }
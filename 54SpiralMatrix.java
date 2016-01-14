//注意重叠重复累加问题
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return res;
        return helper(matrix, 0, matrix.length-1, 0, matrix[0].length-1, res);
        
    }
    
    private List<Integer> helper(int[][] matrix, int rowS, int rowE, int colS, int colE, List<Integer> res) {
        if(rowS > rowE || colS > colE) return res;
        if(rowS == rowE) {
            for(int i = colS; i <= colE; i++) {
                res.add(matrix[rowS][i]);
            }
            return res;
        }
        else if(colS == colE) {
            for(int i = rowS; i <= rowE; i++ ) {
                res.add(matrix[i][colE]);
            }
            return res;
        }
        for(int i = colS; i <= colE; i++) {
            res.add(matrix[rowS][i]);
        }
        for(int i = rowS+1; i <= rowE; i++ ) {
            res.add(matrix[i][colE]);
        }
        for(int i = colE-1; i >= colS; i--) {
            res.add(matrix[rowE][i]);
        }
        for(int i = rowE-1; i > rowS; i--) {
            res.add(matrix[i][colS]);
        }
        return helper(matrix, rowS+1, rowE-1, colS+1, colE-1, res);
    }
}
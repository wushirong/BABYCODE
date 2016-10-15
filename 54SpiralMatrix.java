public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(true) {
            for (int i = left; i <= right; i++ ) res.add(matrix[top][i]);
            top++;
            if (top > bottom || left > right) break;
            
            for (int i = top; i <= bottom; i++ ) res.add(matrix[i][right]);
            right--;
            if (top > bottom || left > right) break;
            
            for (int i = right; i >= left; i-- ) res.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom || left > right) break;
            
            for (int i = bottom; i >= top; i-- ) res.add(matrix[i][left]);
            left++;
            if (top > bottom || left > right) break;
        }
        return res;
    }


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
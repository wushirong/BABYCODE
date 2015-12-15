public class NumArray {
    int[] numArray;
    int[] sum;
    public NumArray(int[] nums) {
        this.numArray = nums;
        sum = new int[numArray.length + 1];
        sum[0] = 0;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + numArray[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if(i > j || i < 0 || j >= numArray.length) return 0;
        return sum[j + 1] - sum[i];
    }
}
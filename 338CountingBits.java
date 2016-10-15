public class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for(int i= 1; i <= num; i++) {
            res[i] = res[i / 2] + i % 2;
        }
        return res;
    }
}


public int[] countBits(int num) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(0);
        al = helper(al, num, 1);
        int[] res = new int[num + 1];
        for(int i = 0; i < num + 1; i++) {
            res[i] = al.get(i);
        }
        return res;
    }
    
    private ArrayList<Integer> helper(ArrayList<Integer> al, int num, int cur) {
        int size = al.size();
        if(size > num ) return al;
        for(int i = 0; i < size; i++) {
            al.add(al.get(i) + 1);
        }
        return helper(al, num, cur + 1);
    }
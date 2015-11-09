public class Solution {
    public final numComparator CMP = new numComparator();
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] item = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            item[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(item, CMP);
        if(item[item.length - 1].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for(int i = item.length - 1; i >= 0 ; i--) {
            res.append(item[i]);
        }
        return res.toString();
    }
    public class numComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            String com1 = str1 + str2;
            String com2 = str2 + str1;
            for(int i = 0; i < com1.length(); i++) {
                if(com1.charAt(i) < com2.charAt(i)) return -1;
                else if(com1.charAt(i) > com2.charAt(i)) return 1;
            }
            return 0;
        }
    }
}
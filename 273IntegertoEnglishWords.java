public class Solution {
    String[] nums = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] nums2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    public String numberToWords(int num) {
        StringBuilder res = new StringBuilder();
        if(num == 0) return res.append(nums[0]).toString();
        if(num / 1000000000 > 0) {
            res.append(nums[num / 1000000000] + " Billion");
            num %= 1000000000;
        }
        if(num / 1000000 > 0) {
            if(res.length() != 0) res.append(" ");
            String mi = hundred(num / 1000000);
            res.append(mi + " Million");
            num %= 1000000;
        }
        if(num / 1000 > 0) {
            if(res.length() != 0) res.append(" ");
            res.append(hundred(num / 1000) + " Thousand");
            num %= 1000;
        }
        String hu = hundred(num);
        if(hu.length() != 0) {
            if(res.length() != 0) res.append(" ");
            res.append(hu);
        }
        
        return res.toString();
    }
    private String hundred(int num) {
        StringBuilder sb = new StringBuilder();
        if(num > 99) {
            sb.append(nums[num / 100] + " Hundred");
            num %= 100;
        }
        if(num >19) {
            if(sb.length() != 0) sb.append(" ");
            sb.append(nums2[num / 10 - 2]);
            num %= 10;
        }
        if(num > 0) {
            if(sb.length() != 0) sb.append(" ");
            sb.append(nums[num]);
        }
        
        return sb.toString();
    }
}
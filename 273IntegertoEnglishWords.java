// clean version
public class Solution {
    private String[] less20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",                         "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] thousands = {" ", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int i = 0;
        String word ="";
        while(num > 0) {
            if(num % 1000 > 0) {
                word = helper(num % 1000) + thousands[i] + " " + word;
            }
            num /= 1000;
            i++;
        }
        return word.trim();
    }
    
    private String helper(int num) {
        String res = "";
        if(num == 0) return res;
        else if(num < 20) return less20[num] + " ";
        else if(num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return less20[num / 100] + " Hundred " + helper(num % 100);
    }
}

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
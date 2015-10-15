public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        int count = 1;
        String input = "1";
        char c = input.charAt(0);
        
        while(count < n) {
            StringBuilder res = new StringBuilder();
            int repeat = 1;
            for(int i = 0; i < input.length()-1; i++) {
                c = input.charAt(i);
                if(input.charAt(i) != input.charAt(i+1)) {
                    res.append(repeat);
                    res.append(c);
                    c = input.charAt(i + 1);
                    repeat = 1;
                }
                else {
                    repeat++;
                }
            }
            res.append(repeat);
            res.append(c);
            input = res.toString();
            count++;
        }
        return input;
    }
}

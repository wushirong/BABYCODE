//将大问题拆为小问题逐个解决
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
         List<Integer> res = new ArrayList<Integer>();
         for(int i = 0; i < input.length(); i++) {
             if(input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*') {
                    String part1 = input.substring(0, i);
                    String part2 = input.substring(i+1);
                    List<Integer> res1 = diffWaysToCompute(part1);
                    List<Integer> res2 = diffWaysToCompute(part2);
                    int sum = 0;
                    for(int num1: res1) {
                        for(int num2: res2) {
                            switch(input.charAt(i)) {
                                case '+':
                                    sum = num1 + num2;
                                    break;
                                case '-':
                                    sum = num1 - num2;
                                    break;
                                case '*':
                                    sum = num1 * num2;
                            }
                            res.add(sum);
                        }
                    }
                }
         }
         if(res.size() == 0) res.add(Integer.valueOf(input));
         return res;
    }
}
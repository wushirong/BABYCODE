//simplified version If an integer is like 100a+10b+c, then (100a+10b+c)%9=(a+99a+b+9b+c)%9=(a+b+c)%9
public int addDigits(int num) {
    if （num == 0) return 0;
    return num % 9 == 0? 9 : num % 9;
}

public class Solution {
    public int addDigits(int num) {
        if(num < 0) return 0;
        
        
        while((num / 10) > 0) {
            int sum = 0;
            while(num > 0){
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
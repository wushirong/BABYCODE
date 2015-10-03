public class Solution {
    public boolean isHappy(int n) {
        if(n == 0){
            return false;
        }
    int sum = 0;
    int transform = n;
    HashSet digit=new HashSet();
    while(sum != 1){
        sum=0;
        while(transform>0) {
            sum += (transform % 10)*(transform % 10);
            transform /= 10;
        }
        if(digit.contains(sum)) {
            return false;
        }
        digit.add(sum);
        transform=sum;
    }
    return true;
    }
}
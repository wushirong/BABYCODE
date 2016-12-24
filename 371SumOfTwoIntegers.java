// explain: http://stackoverflow.com/questions/9070937/adding-two-numbers-without-operator-clarification
public int getSum(int a, int b) {
        if(b == 0) return a;
        int sum = a^b;
        int carry = (a&b)<<1;
        return getSum(sum, carry);
    }
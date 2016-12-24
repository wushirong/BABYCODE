public int findNthDigit(int n) {
        long count = 1;
        long plus = 9;
        int len = 1;
        while (n > count*plus) {
            n -= count*plus;
            count++;
            plus *= 10;
            len *= 10;
        }
        len += (n-1)/count;
        String s = Long.toString(len);
        char ch = s.charAt((int)((n-1)%count));
        return ch-'0';
    }
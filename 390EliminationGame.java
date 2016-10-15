public int lastRemaining(int n) {
        boolean left = true;
        int step = 1;
        int head = 1;
        int remain = n;
        while (remain > 1) {
            if (left || remain % 2 == 1) head = head + step;
            remain = remain / 2;
            step = step * 2;
            left = ! left;
        }
        return head;
    }
public class Solution {
    public boolean isUgly(int num) {
        if(num < 1) return false;
        if(num == 1) return true;
        int pre = num;
        int post = num;
        
        while(true) {
            post = post % 2 == 0? post/2 : post;
            post = post % 3 == 0? post/3 : post;
            post = post % 5 == 0? post/5 : post;
            if(pre == post) return false;
            if(post == 1) break;
            pre = post;
        }
        
        return true;
        
    }
}
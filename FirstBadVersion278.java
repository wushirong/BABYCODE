/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int pre = 1;
        int post = n;
        int check = pre + (post - pre)/2;;
        
        while(pre < post) {
            check = pre + (post - pre)/2;
            if(isBadVersion(check)) post = check;
            else pre = check + 1;
        }
        return post;
    }
}
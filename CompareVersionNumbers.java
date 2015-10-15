public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] remain1 = version1.split("\\.");
        String[] remain2 = version2.split("\\.");
        
        for(int i = 0; i < remain1.length && i < remain2.length; i++) {
            if(Integer.parseInt(remain1[i]) > Integer.parseInt(remain2[i])) return 1;
            if(Integer.parseInt(remain1[i]) < Integer.parseInt(remain2[i])) return -1;
            if(i == remain1.length - 1 && i <remain2.length - 1) break;
            if(i == remain2.length - 1 && i <remain1.length - 1) break;
        }
        if(remain1.length > remain2.length) {
            for(int i = remain2.length; i < remain1.length; i++) {
                if (Integer.parseInt(remain1[i]) > 0) return 1;
            }
        }
        if(remain1.length < remain2.length) {
            for(int i = remain1.length; i < remain2.length; i++) {
                if (Integer.parseInt(remain2[i]) > 0) return -1;
            }
        }
        return 0;
    }
}
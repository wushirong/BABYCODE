//project all 1 to one side of col and row
public int minArea(char[][] image, int x, int y) {
        int rl = image.length;
        int cl = image[0].length;
        int left = columns(image, 0, y, 0, rl, true);
        int right = columns(image, y + 1, cl, 0, rl, false);
        int top = rows(image, 0, x, left, right, true);
        int bottom = rows(image, x + 1, rl, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int columns(char[][] image, int x, int y, int top, int bottom, boolean lr) {
        while(x < y) {
            int mid = (x + y) / 2;
            int k = top;
            while(k < bottom && image[k][mid] == '0') ++k;
            if(k < bottom == lr) y = mid;
            else x = mid + 1;
        }
        return x;
    }
    private int rows(char[][] image, int x, int y, int left, int right, boolean tb) {
        while(x < y) {
            int mid = (x + y) / 2;
            int k = left;
            while(k < right && image[mid][k] == '0') ++k;
            if(k < right == tb) y = mid;
            else x = mid + 1;
        }
        return x;
    }
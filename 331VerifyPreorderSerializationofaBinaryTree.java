//stupid version can be long and unless, using math solution
public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0) return true;
        int sum = 0;
        String[] split = preorder.split(",");
        for(int i = 0; i < split.length - 1; i++) {
            if(split[i].equals("#")) sum--;
            else sum++;
            if(sum < 0) return false;
            
        }
        if(sum != 0) return false;
        return split[split.length -  1].equals("#");
    }
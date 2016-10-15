public boolean isValidSerialization(String preorder) {
        if(preorder == null) return true;
        if(preorder.length() > 1 && preorder.charAt(0) == '#') return false;
        int degree = 0;
        String[] items = preorder.split(",");
        for(int i = 0; i < items.length - 1; i++) {
            String item = items[i];
            if(item.equals("#")) degree --;
            else degree ++;
            if(degree < 0) return false;
        }
        if (degree != 0) return false;
        return items[items.length - 1].equals("#");
    }

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
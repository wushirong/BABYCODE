public boolean isValidSerialization(String preorder) {
        if(preorder == null ) return false;
        String[] order = preorder.split(",");
        int degree = -1;
        for(String item: order) {
            degree++;
            if(degree > 0) return false;
            if(!item.equals("#")) degree -= 2;
        }
        
        return degree == 0;
    }
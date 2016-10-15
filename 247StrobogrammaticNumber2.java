public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if(n == 0) return new ArrayList<String>(Arrays.asList(""));
        if(n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> list = new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        list = helper(n-2, m);
        for(String str: list) {
            if(n != m) res.add("0" + str + "0");
            res.add("1" + str + "1");
            res.add("9" + str + "6");
            res.add("6" + str + "9");
            res.add("8" + str + "8");
        }
        return res;
    }
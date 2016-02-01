public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res; 
        char[] chars = num.toCharArray();
        helper(num, "", target, 0, 0, 0, res);
        return res;
        
    }
    private void helper(String num, String path, int target, int pos, long eval, long mult, List<String> list) {
        if(num == null || num.length() == 0) return; 
        else if(pos == num.length()) {
            if(target == eval) list.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(i != pos && num.charAt(pos) == '0') break;  //handle case like + 0/ * 0/ - 0. These case is allowed, but + 08 is not allowed, thus need this sentence to break the loop
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0) {
                helper(num, path + cur, target, i + 1, cur, cur, list);
            }
            else {
                helper(num, path + "+" + cur, target, i + 1, eval + cur, cur, list);
                helper(num, path + "-" + cur, target, i + 1, eval - cur, -cur, list);
                helper(num, path + "*" + cur, target, i + 1, eval - mult + mult * cur, mult * cur, list);
            }
        }
        
    }
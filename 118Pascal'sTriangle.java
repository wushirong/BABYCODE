public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) return res;
        List<Integer> init = new ArrayList<>();
        init.add(1);
        res.add(init);
        while (--numRows > 0) {
            List<Integer> prev = res.get(res.size()-1);
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int i = 0; i< prev.size()-1; i++) {
                cur.add(prev.get(i) + prev.get(i+1));
            }
            cur.add(prev.get(prev.size()-1));
            res.add(cur);
        }
        return res;
    }
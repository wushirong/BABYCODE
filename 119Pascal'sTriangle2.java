public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) return res;
        List<Integer> prev = new ArrayList<Integer>();
        prev.add(1);
         List<Integer> next = new ArrayList<Integer>();
        while (--rowIndex >= 0) {
            next.add(1);
            for (int i = 0; i < prev.size()-1; i++) {
                next.add(prev.get(i) + prev.get(i+1) );
            }
            next.add(prev.get(prev.size()-1));
            prev = next;
            next = new ArrayList<Integer>();
        }
        return prev;
    }
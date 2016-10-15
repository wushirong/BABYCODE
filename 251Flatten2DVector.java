public class Vector2D implements Iterator<Integer> {
    private List<List<Integer>> list;
    private int row;
    private int col;
    private int totalR;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
        row = 0;
        col = 0;
        totalR = vec2d.size();
    }

    @Override
    public Integer next() {
       int res = list.get(row).get(col++);
        if (col == list.get(row).size()) {
            row++;
            col = 0;
        }
        return res;
    }

    @Override
    public boolean hasNext() {
        while (row < list.size() && (list.get(row) == null || list.get(row).size() == 0)) row++;
        return row < totalR;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
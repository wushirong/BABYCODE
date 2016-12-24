public class RandomizedCollection {
    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    Random r;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Set<Integer>>();
        this.r = new Random();
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (!res) map.put(val, new HashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);  
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int pos = map.get(val).iterator().next();
        map.get(val).remove(pos);
        if (pos != list.size()-1) {
            int last = list.get(list.size()-1);
            list.set(pos, last);
            map.get(last).remove(list.size()-1);
            map.get(last).add(pos);
        }
        
        if (map.get(val).size() == 0) map.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public Integer getRandom() {
        
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<String>();
        if(tickets == null || tickets.length == 0) return res;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String[] item: tickets) {
            if(map.containsKey(item[0])) {
                ArrayList<String> al = map.get(item[0]);
                listAdd(item[1], al);
            }
            else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(item[1]);
                map.put(item[0], al);
            }
        }
        res.add("JFK");
        helper("JFK", map, res, tickets.length + 1, 1);
        return res;
    }
    private boolean helper(String current, HashMap<String, ArrayList<String>> map, List<String> result, int total, int num) {
        if(num >= total) return true;
        if(!map.containsKey(current) || map.get(current).size() == 0) {
            return false;
        }
        
        ArrayList<String> curList = map.get(current);
        int i = 0;

        while(i < curList.size()){
            String next = curList.remove(i);
            result.add(next);

            if(helper(next, map, result, total, num + 1)){
                return true;
            }

            result.remove(result.size() - 1);
            listAdd(next, curList);
            i++;
        }
        return false;
    }
    
    public void listAdd(String value, ArrayList<String> list){
        if(list.size() == 0) {
            list.add(value);
            return;
        }
        else {
            for(int i = 0; i < list.size(); i++) {
                if(value.compareTo(list.get(i)) < 0) {
                    list.add(i, value);
                    return;
                }
            }
            list.add(value);
        }
    }
}
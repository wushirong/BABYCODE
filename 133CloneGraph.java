private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(res.label, res);
        for (UndirectedGraphNode item: node.neighbors) {
            UndirectedGraphNode cur = cloneGraph(item);
            res.neighbors.add(cur);
        }
        return res;
    }
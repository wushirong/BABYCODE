public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<String>> graph = new HashMap<>();
        HashMap<String, List<Double>> pair = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] str = equations[i];
            double val = values[i];
            if (!graph.containsKey(str[0])) {
                graph.put(str[0], new ArrayList<String>());
                pair.put(str[0], new ArrayList<Double>());
            }
            if (!graph.containsKey(str[1])) {
                graph.put(str[1], new ArrayList<String>());
                pair.put(str[1], new ArrayList<Double>());
            }
            graph.get(str[0]).add(str[1]);
            graph.get(str[1]).add(str[0]);
            pair.get(str[0]).add(val);
            pair.get(str[1]).add(1/val);
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) res[i] = -1.0;
            else res[i] = helper(queries[i][0], queries[i][1], graph, pair, new HashSet<String>());
        }
        return res;
    }
    
    private double helper(String start, String end, HashMap<String, List<String>> graph, HashMap<String, List<Double>> pair, HashSet<String> route) {
        if (route.contains(start) || !graph.containsKey(start)) return -1.0;
        if (start.equals(end)) return 1.0;
        route.add(start);
        List<String> list = graph.get(start);
        double res = -1.0;
        for (int i = 0; i < list.size(); i++) {
            String newstart = list.get(i);
            double temp = helper(newstart, end, graph, pair, route);
            res = temp < 0? res:temp * (pair.get(start).get(i));
        }
        return res;
    } 
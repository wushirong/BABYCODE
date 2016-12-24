// pay attention to corner case
public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return null;
        Deque<String> dq = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir: path.split("/")) {
            if (dir.equals("..")  && !dq.isEmpty()) dq.pop();
            else if (!set.contains(dir)) dq.push(dir);
        }
        StringBuilder sb = new StringBuilder();
        for (String dir: dq) sb.insert(0, "/" + dir);
        return sb.length()==0? "/": sb.toString();
    }
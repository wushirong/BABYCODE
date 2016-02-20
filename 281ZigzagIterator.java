public class ZigzagIterator {
    Queue<Integer> queue = new LinkedList<Integer>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int index = 0;
        if(v1.size() == 0 && v2.size() == 0) return;
        while(index < v1.size() && index < v2.size()) {
            queue.offer(v1.get(index));
            queue.offer(v2.get(index));
            index++;
        }
        while(index < v1.size()) {
            queue.offer(v1.get(index++));
        }
        while(index < v2.size()) {
            queue.offer(v2.get(index++));
        }
    }

    public int next() {
        if(hasNext()) return queue.poll();
        else return -1;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
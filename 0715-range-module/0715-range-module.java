class RangeModule {
    private TreeMap<Integer, Integer> intervals;
    public RangeModule() {
        intervals = new TreeMap<>();
    }
    public void addRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) >= left) {
            left = Math.min(left, start);
            right = Math.max(right, intervals.get(start));
            intervals.remove(start);
        }
        while (true) {
            Integer next = intervals.ceilingKey(left);
            if (next == null || next > right) break;
            right = Math.max(right, intervals.get(next));
            intervals.remove(next);
        }
        intervals.put(left, right);
    }
    public boolean queryRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        return start != null && intervals.get(start) >= right;
    }
    public void removeRange(int left, int right) {
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) > left) {
            int startEnd = intervals.get(start);
            if (startEnd > right) {
                intervals.put(right, startEnd);
            }
            intervals.put(start, left);
        }
        while (true) {
            Integer next = intervals.ceilingKey(left);
            if (next == null || next >= right) break;
            if (intervals.get(next) > right) {
                intervals.put(right, intervals.get(next));
            }
            intervals.remove(next);
        }
    }
}

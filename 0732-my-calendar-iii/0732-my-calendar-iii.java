class MyCalendarThree {
    private TreeMap<Integer, Integer> events;
    public MyCalendarThree() {
        events = new TreeMap<>();
    }
    public int book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);
        int maxOverlap = 0;
        int currentOverlap = 0;
        for (int count : events.values()) {
            currentOverlap += count;
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }
        return maxOverlap;
    }
}

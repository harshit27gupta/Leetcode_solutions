import java.util.*;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            if (time + duration <= lastDay) {
                time += duration;
                maxHeap.offer(duration);
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                time += duration - maxHeap.poll();
                maxHeap.offer(duration);
            }
        }
        return maxHeap.size();
    }
}

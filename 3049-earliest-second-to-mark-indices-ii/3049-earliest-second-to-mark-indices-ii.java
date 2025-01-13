class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        if (nums.length == 1 && nums[0] == 0) {
            return 1;
        }

        changeIndices = Arrays.stream(changeIndices).map(x -> x - 1).toArray();

        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        total += nums.length;

        int low = 0, high = changeIndices.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, changeIndices, mid, total)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return isPossible(nums, changeIndices, low, total) ? low + 1 : -1;
    }

    private boolean isPossible(int[] nums, int[] changeIndices, int mid, long total) {
        if (mid >= changeIndices.length) {
            return false;
        }

        HashMap<Integer, Integer> firstIndices = new HashMap<>();
        for (int i = 0; i <= mid; i++) {
            if (nums[changeIndices[i]] > 0 && !firstIndices.containsKey(changeIndices[i])) {
                firstIndices.put(changeIndices[i], i);
            }
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int available = 0;
        for (int i = mid; i >= 0; i--) {
            if (firstIndices.get(changeIndices[i]) != null && firstIndices.get(changeIndices[i]) == i) {
                if (available > 0) {
                    priorityQueue.offer(new int[]{nums[changeIndices[i]], changeIndices[i]});
                    available--;
                } else if (!priorityQueue.isEmpty() && priorityQueue.peek()[0] < nums[changeIndices[i]]) {
                    priorityQueue.poll();
                    priorityQueue.offer(new int[]{nums[changeIndices[i]], changeIndices[i]});
                    available++;
                } else {
                    available++;
                }
            } else {
                available++;
            }
        }

        while (!priorityQueue.isEmpty()) {
            total -= (priorityQueue.poll()[0] + 1);
        }

        return total <= available;
    }
}
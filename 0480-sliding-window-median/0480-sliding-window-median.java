class Solution {
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        Map<Integer, Integer> removed = new HashMap<>();

        PriorityQueue<Integer> mins = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> maxs = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (int i=0; i<k; i++) {
            maxs.add(nums[i]);
            mins.add(maxs.poll());
            if (mins.size() - maxs.size() > 1) {
                maxs.add(mins.poll());
            }
        }

        for (int i=k; i<=nums.length; i++) {
            res[i-k] = mediane(mins, maxs, k);

            if (i < nums.length) {
                int balance = nums[i-k] <= mins.peek() ? -1 : 1;
                markRemove(nums[i-k], removed);

                if (nums[i] <= mins.peek()) {
                    mins.add(nums[i]);
                    balance++;
                } else {
                    maxs.add(nums[i]);
                    balance--;
                }
                
                if (balance < 0) {
                    mins.add(maxs.poll());
                }
                if (balance > 0) {
                    maxs.add(mins.poll());
                }

                tryRemove(mins, removed);
                tryRemove(maxs, removed);
            }
        }

        return res;
    }

    private void tryRemove(PriorityQueue<Integer> queue, Map<Integer, Integer> removed) {
        while (!queue.isEmpty() && removed.getOrDefault(queue.peek(), 0) > 0) {
            int a = queue.poll();
            removed.put(a, removed.get(a) - 1);
        }
    }

    private void markRemove(int a, Map<Integer, Integer> removed) {
        removed.put(a, removed.getOrDefault(a, 0) + 1);
    }

    private double mediane(PriorityQueue<Integer> mins, PriorityQueue<Integer> maxs, int k) {
        if (k % 2 == 0) {
            double val = mins.peek() * 0.5 + maxs.peek() * 0.5;
            return val; 
        } else {
            return mins.peek();
        }
    }
}
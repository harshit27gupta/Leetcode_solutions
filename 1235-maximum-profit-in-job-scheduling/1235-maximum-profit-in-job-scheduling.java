class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1])); // Sort by endTime

        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0); // base: 0 profit at time 0

        for (int[] job : jobs) {
            int curStart = job[0], curEnd = job[1], curProfit = job[2];
            int maxBefore = dp.floorEntry(curStart).getValue();
            int totalProfit = maxBefore + curProfit;

            if (totalProfit > dp.lastEntry().getValue()) {
                dp.put(curEnd, totalProfit);
            }
        }

        return dp.lastEntry().getValue();
    }
}

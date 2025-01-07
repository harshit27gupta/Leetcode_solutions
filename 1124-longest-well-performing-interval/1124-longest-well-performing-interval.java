class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int prefixSum = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            prefixSum += (hours[i] > 8 ? 1 : -1);
            if (prefixSum > 0) {
                maxLength = i + 1;
            } else {
                if (firstSeen.containsKey(prefixSum - 1)) {
                    maxLength = Math.max(maxLength, i - firstSeen.get(prefixSum - 1));
                }
                firstSeen.putIfAbsent(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}

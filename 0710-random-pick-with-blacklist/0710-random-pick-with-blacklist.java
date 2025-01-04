class Solution {
    private int validCount;
    private Map<Integer, Integer> mapping;
    private Random random;
    public Solution(int n, int[] blacklist) {
        validCount = n - blacklist.length;
        mapping = new HashMap<>();
        random = new Random();
        Set<Integer> blacklistSet = new HashSet<>();
        for (int b : blacklist) {
            blacklistSet.add(b);
        }
        int last = n - 1;
        for (int b : blacklist) {
            if (b < validCount) {
                while (blacklistSet.contains(last)) {
                    last--;
                }
                mapping.put(b, last);
                last--;
            }
        }
    }

    public int pick() {
        int idx = random.nextInt(validCount); 
        return mapping.getOrDefault(idx, idx); 
    }
}

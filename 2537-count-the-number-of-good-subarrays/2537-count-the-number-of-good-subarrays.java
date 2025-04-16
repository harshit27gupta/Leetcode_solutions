class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0; int left = 0;
        for (int i = 0; i < nums.length; i++) {
            k -= map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (k <= 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                k += map.get(nums[left++]);
            }
            cnt += left;
        }
        return cnt;
    }
}
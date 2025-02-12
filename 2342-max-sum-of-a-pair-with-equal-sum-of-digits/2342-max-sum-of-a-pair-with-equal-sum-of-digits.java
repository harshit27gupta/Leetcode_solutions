import java.util.HashMap;

class Solution {
    static int sum(int n) {
        int s = 0;
        while (n > 0) {
            s += n % 10;
            n = n / 10;
        }
        return s;
    }

    public int maximumSum(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int s = sum(nums[i]);
            if (map.containsKey(s)) {
                ans = Math.max(ans, nums[i] + map.get(s));
                map.put(s, Math.max(nums[i], map.get(s)));
            } else {
                map.put(s, nums[i]);
            }
        }

        return ans;
    }
}

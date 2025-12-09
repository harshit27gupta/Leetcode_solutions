import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> rightFreq = new HashMap<>();
        Map<Integer, Integer> leftFreq = new HashMap<>();
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }

        long result = 0;

        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            rightFreq.put(num, rightFreq.get(num) - 1); 

            int target = num * 2;
            int leftCount = leftFreq.getOrDefault(target, 0);
            int rightCount = rightFreq.getOrDefault(target, 0);

            result += (1L * leftCount * rightCount) % MOD;
            result %= MOD;

            leftFreq.put(num, leftFreq.getOrDefault(num, 0) + 1); 
        }

        return (int) result;
    }
}

import java.util.*;

public class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }
        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (!freq.containsKey(mod) || freq.get(mod) == 0) break;
            freq.put(mod, freq.get(mod) - 1);
            mex++;
        }
        return mex;
    }
}

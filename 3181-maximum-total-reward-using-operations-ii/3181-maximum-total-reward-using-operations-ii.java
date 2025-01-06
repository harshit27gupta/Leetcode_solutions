import java.util.*;

class Solution {
   public int maxTotalReward(int[] rewardValues) {
       TreeSet<Integer> set = new TreeSet<>();
       for (int num : rewardValues) set.add(num);
       return set.last() + DFS(set, new HashMap<>(), set.last());
   }

   private int DFS(TreeSet<Integer> nums, Map<Integer, Integer> map, int limit) {
       if (limit == 0) {
           return 0;
       }
       if (map.containsKey(limit)) {
           return map.get(limit);
       }
       if (nums.contains(limit - 1)) {
           return limit - 1;
       }
       int res = 0;
       for (int num : nums.headSet(limit, false)) {
           res = Math.max(res, num + DFS(nums, map, Math.min(limit - num, num)));
       }
       map.put(limit, res);
       return res;
   }
}

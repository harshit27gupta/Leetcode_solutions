import java.util.*;

class Solution {
    static boolean check(int idx, int order[], int k, int n) {
        ArrayList<Integer> ind = new ArrayList<>();
        ind.add(-1);
        for (int i = 0; i <= idx; i++)
            ind.add(order[i]);
        Collections.sort(ind);
        long ans = 0;
        for (int i = 1; i < ind.size(); i++)
            ans += (long) (ind.get(i) - ind.get(i - 1)) * (n - ind.get(i));
        return ans >= k;
    }
    public int minTime(String s, int[] order, int k) {
        int n = order.length;
        int l = 0;
        int r = n - 1;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, order, k, n)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }
}

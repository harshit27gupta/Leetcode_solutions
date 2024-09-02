class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        for (int i = 0; i < n; ++i) {
            health[i] = (health[i] + power - 1) / power;
        }
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            indices.add(i);
        }
        indices.sort((i, j) -> {
            return Integer.compare(health[i] * damage[j], health[j] * damage[i]);
        });
        long add = 0;
        int curTime = 0;
        for (int i : indices) {
            curTime += health[i];
            add += curTime * damage[i];
        }
        return add;
    }
}
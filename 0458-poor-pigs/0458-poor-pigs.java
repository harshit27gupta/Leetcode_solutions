class Solution {
    public int poorPigs(int buckets, int a, int b) {
        int pigs = 0;
        while (Math.pow((b / a + 1), pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
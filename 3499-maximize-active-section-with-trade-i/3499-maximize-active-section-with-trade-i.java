class Solution {
       public int maxActiveSectionsAfterTrade(String s) {
        int ones = s.chars().map(i -> i == '1' ? 1 : 0).sum();
        int maxGains = 0, prev = 0, cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++cur; 
            }else if (prev == 0) {
                prev = cur;
                cur = 0;
            }else if (prev > 0 && cur > 0) {
                maxGains = Math.max(maxGains, prev + cur);
                prev = cur;
                cur = 0;
            }
        }
        if (prev > 0 && cur > 0) {
            maxGains = Math.max(maxGains, prev + cur);
        }
        return ones + maxGains;
    }
}
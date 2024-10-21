class Solution {
    int maxCount = 0;
    public int maxUniqueSplit(String s) {
        backtracking(s, 0, new HashSet<>());
        return maxCount;
    }
    private void backtracking(String s, int curr, Set<String> set) {
        if(curr == s.length()) {
            maxCount = Math.max(set.size(), maxCount);
        }

        for(int i = curr + 1; i <= s.length(); i++) {
            String temp = s.substring(curr, i);
            if(!set.contains(temp)) {
                set.add(temp);
                backtracking(s, i, set);
                set.remove(temp);
            }
        }
    }
}
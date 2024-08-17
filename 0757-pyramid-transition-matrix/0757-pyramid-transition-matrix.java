class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> sequenceHolder = new HashMap<>();

        for (String str : allowed) {
            String key = str.substring(0, 2);
            String val = str.substring(2);

            if (!sequenceHolder.containsKey(key)) {
                sequenceHolder.put(key, new ArrayList<>());
            }    
            sequenceHolder.get(key).add(val);
        }
        return recur(sequenceHolder, bottom, new StringBuilder(), 1, new HashMap<String, Boolean>());
    }

    private boolean recur(Map<String, List<String>> sequenceHolder, String currRow, StringBuilder nextRow, 
        int currIndex, HashMap<String, Boolean> memo) {

        if (currRow.length() == 1) {
            return true;
        }

        if (currIndex == currRow.length()) {
            return recur(sequenceHolder, nextRow.toString(), new StringBuilder(), 1, memo);
        }
        String memokey = currRow + "|" + nextRow + "|" + currIndex;
        String key = "" + currRow.charAt(currIndex - 1) + currRow.charAt(currIndex);

        if (memo.containsKey(memokey)) {
            return memo.get(memokey);
        }
        boolean ans = false;

        if (sequenceHolder.containsKey(key)) {

            for (String child : sequenceHolder.get(key)) {
                nextRow.append(child);

                if (recur(sequenceHolder, currRow, nextRow, currIndex + 1, memo)) {
                    ans = true;
                    break;
                }
                nextRow.deleteCharAt(nextRow.length() - 1);
            }
        }
        memo.put(memokey, ans);
        return ans;
    }
}
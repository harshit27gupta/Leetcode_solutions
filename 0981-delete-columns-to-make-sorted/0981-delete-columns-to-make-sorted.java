class Solution {
    public int minDeletionSize(String[] strs) {
            int c = 0;
        for (int i = 0; i < strs[0].length(); i++){
            char temp = strs[0].charAt(i);
            for (String str : strs) {
                if (temp <= str.charAt(i)) {
                    temp = str.charAt(i);
                }else {
                    c++;
                    break;
                }
            }
        }

        return c;
    }
}
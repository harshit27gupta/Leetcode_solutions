class Solution {
    private static final char[] ROTATE_SAME = {'0', '1', '8'};
    private static final char[] ROTATE_DIFF = {'2', '5', '6', '9'};
    private int count = 0;
    private String high;
    
    public int rotatedDigits(int N) {
        this.high = String.valueOf(N);
        
        for (int len = 1; len <= high.length(); len++) 
            dfs(0, new char[len], false);
        
        return count;
    }
    
    private void dfs(int idx, char[] arr, boolean valid) {
        if (idx == arr.length) {
            if (!valid) return;
            String res = new String(arr);
            if (!(res.length() == high.length() && res.compareTo(high) > 0)) count++;
            return;
        }
        
        for (char c : ROTATE_SAME) {
            if (idx == 0 && c == '0') continue;
            arr[idx] = c;
            dfs(idx + 1, arr, valid);
        }
        
        for (char c : ROTATE_DIFF) {
            arr[idx] = c;
            dfs(idx + 1, arr, true);
        }
    }
}
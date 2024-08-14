class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        boolean turn = true;
        int cnt = 0;
        StringBuilder get = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            get.append(s.charAt(i));
            cnt++;
            
            if (cnt == k) {
                if (turn) {
                    ans.append(get.reverse());
                } else {
                    ans.append(get);
                }
                cnt = 0;
                turn = !turn;
                get.setLength(0);
            }
        }
        if (turn) {
            ans.append(get.reverse());
        } else {
            ans.append(get);
        }
        
        return ans.toString();
    }
}

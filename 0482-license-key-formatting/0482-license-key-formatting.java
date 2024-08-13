class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String str = "";
        for (char ch : s.toCharArray()) {
            if (ch != '-') {
                str += Character.toUpperCase(ch);
            }
        }     
        int len = str.length();
        int firstGroupLen = len % k;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        if (firstGroupLen > 0) {
            ans.append(str.substring(0, firstGroupLen));
            i = firstGroupLen;
            if (i < len) {
                ans.append('-');
            }
        }
        while (i < len) {
            ans.append(str.substring(i, i + k));
            i += k;
            if (i < len) {
                ans.append('-');
            }
        }
        
        return ans.toString();
    }
}

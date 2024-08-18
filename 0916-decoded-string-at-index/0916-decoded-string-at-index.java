class Solution {
    public String decodeAtIndex(String s, int k) {
    long size = 0;  
    int n = s.length();
    for (int i = 0; i < n; i++) {
        char ch = s.charAt(i);
        if (Character.isDigit(ch)) {
            int digit = Character.getNumericValue(ch);
            size *= digit;  
        } else {
            size++;
        }
    }
    for (int i=s.length()-1;i>=0;i--) {
        char ch = s.charAt(i);

        if (Character.isDigit(ch)) {
            int digit = Character.getNumericValue(ch);
            size /= digit; 
            k %= size;  
        } else {
            if (k == 0 || size==k) {
                return Character.toString(ch);
            }
            size--;  
        }
    }

    return null;  

    }
}
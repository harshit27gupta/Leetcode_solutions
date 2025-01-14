import java.util.*;

class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> no = new HashSet<>(forbidden); 
        int maxLength = 0;
        int j = 0;  
        StringBuilder window = new StringBuilder(); 
        
        for (int i = 0; i < word.length(); i++) {
            window.append(word.charAt(i)); 
            while (containsForbiddenSubstring(window.toString(), no)) {
                window.deleteCharAt(0); 
                j++;
            }
            
            maxLength = Math.max(maxLength, i - j + 1); 
        }
        
        return maxLength;
    }
    private boolean containsForbiddenSubstring(String window, Set<String> no) {
        for (int len = 1; len <= Math.min(10, window.length()); len++) {
            if (no.contains(window.substring(window.length() - len))) {
                return true;
            }
        }
        return false;
    }
}

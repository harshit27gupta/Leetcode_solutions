class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (true) {
            boolean digitFound = false;
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (!Character.isDigit(sb.charAt(j))) {
                            sb.deleteCharAt(i);
                            sb.deleteCharAt(j);
                            digitFound = true;
                            break;
                        }
                    }
                    if (digitFound) break;
                }
            }
            if (!digitFound) break;
        }
        
        return sb.toString();
    }
}

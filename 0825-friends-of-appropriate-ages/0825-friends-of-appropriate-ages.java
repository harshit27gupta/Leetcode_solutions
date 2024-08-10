import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        int[] freq = new int[121];
        int[] prefix = new int[121];
        for (int age : ages) {
            freq[age]++;
        }
        for (int i = 1; i <= 120; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        
        int ans = 0;
        for (int age = 15; age <= 120; age++) {
            if (freq[age] > 0) {
                int lowerBound = age / 2 + 7;
                int upperBound = age;
                int validRange = prefix[upperBound] - prefix[lowerBound];
                
                ans += freq[age] * (validRange - 1); 
            }
        }
        
        return ans;
    }
}

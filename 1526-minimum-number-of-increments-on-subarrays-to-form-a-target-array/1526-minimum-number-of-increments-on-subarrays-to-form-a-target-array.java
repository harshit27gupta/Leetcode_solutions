class Solution {
    public int minNumberOperations(int[] target) {
        int ans=0,prev=0;
        for(int i=0; i<target.length; i++) {
            if(target[i] > prev) {
                ans+=(target[i]-prev);
            }
            prev=target[i];
        }
        return ans;
    }
}
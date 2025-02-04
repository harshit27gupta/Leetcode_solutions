class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=0;
        int prev=0;
        int ans=0;
        for(int i:nums){
            if(i>prev)
            sum+=i;
            else{
            ans=Math.max(ans,sum);
            sum=i;
            }
            prev=i;
        }
        ans=Math.max(ans,sum);
        return ans;
    }
}
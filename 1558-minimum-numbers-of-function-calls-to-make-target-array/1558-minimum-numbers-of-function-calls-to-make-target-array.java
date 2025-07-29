class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        int maxp=0;
int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=30;j>=0;j--){
                int bit=(nums[i]&(1<<j));
                if(bit>0){
                ans++;
                maxp=Math.max(maxp,j);
                }
            }
        }
        return ans+maxp;
    }
}
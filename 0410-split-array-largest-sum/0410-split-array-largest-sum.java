class Solution {
    public int splitArray(int[] nums, int k) {

        int l = 0,r = 0,m;

        for(int i = 0; i< nums.length;i++){
            l = Math.max(l,nums[i]);
            r+=nums[i];
        }

        while(l<r){
            m=(l+r)/2;
            if(canBeSplitted(m, k, nums)){
                r=m;
            }else{
                l=m+1;
            }
        }
        return l;
    }
    public boolean canBeSplitted(int m, int k, int[] nums){
        int count = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>m){
                count++;
                sum=0;
            }
            sum+=nums[i];
        }
        return count<=k;
    }
}
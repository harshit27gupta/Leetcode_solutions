class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
       int ans[][]=new int[nums.length/3][3];
        int j=0;
        for(int i=2;i<nums.length;i+=3){
            if(nums[i]-nums[j]<=k){
                j=i+1;
            continue;
            }
            else
           return new int[0][0];
        }
        j=0;
        int indR=0;
        int indC=0; 
        for(int i=2;i<nums.length;i+=3){
            j=i-2;
while(j<=i){
ans[indR][indC]=nums[j];
indC++;
j++;
}
indR++;
indC=0;
        }

return ans;

    }
}
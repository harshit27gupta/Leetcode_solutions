class Solution {
    public int beautifulSplits(int[] nums) {
        final int n = nums.length;
        final int[][] rd = new int[n][n];
        for(int i=n-2;i>=0;--i){
            for(int j=i+1;j<n;++j){
                if(nums[i] == nums[j]){
                    rd[i][j] = 1 + (j > i+1 && j+1 < n ? rd[i+1][j+1] : 0);
                }
            }
        }
        int res = 0;
        for(int i=n-2;i>0;--i) {
            for(int j=i+1;j<n;++j) {
                final boolean f = j-i >= i && rd[0][i] >= i;
                final boolean f2 = j-i <= n-j && rd[i][j] >= j-i;
                if(f || f2){
                    res++;
                }
            }
        }
        return res;
    }
}
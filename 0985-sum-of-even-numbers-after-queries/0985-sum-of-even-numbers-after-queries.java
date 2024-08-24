class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int s = 0;
        // Calculate the initial sum of all even numbers in the array
        for (int i : nums) {
            if (i % 2 == 0) {
                s += i;
            }
        }
        
        int[] ans = new int[queries.length];
        
        // Iterate over each query
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int ind = queries[i][1];
            if (nums[ind] % 2 == 0) {
                s -= nums[ind];
            }
            nums[ind] += val;
            if (nums[ind] % 2 == 0) {
                s += nums[ind];
            }
            ans[i] = s;
        }
        
        return ans;
    }
}

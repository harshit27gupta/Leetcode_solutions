class Solution
{
    private boolean isSafe(int a, int b)
    {
        int sum = a + b;
        int sqrt = (int) Math.sqrt(sum);
        return sqrt * sqrt == sum;
    }
    private void solve(int[] nums, List<Integer> perms, List<List<Integer>> ans, boolean[] visited)
    {
       
        if(perms.size() == nums.length)
        {
            ans.add(new ArrayList<>(perms));
            return;
        }
        for (int index = 0; index < nums.length; index++)
        {
            if(!visited[index] && (index == 0 || nums[index] != nums[index-1] || visited[index-1]) && (perms.isEmpty() || isSafe(perms.get(perms.size()-1), nums[index])))
            {
                visited[index] = true;
                perms.add(nums[index]);
                solve(nums, perms, ans, visited);
                perms.removeLast();
                visited[index] = false;
            }
        }
    }
    public int numSquarefulPerms(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perms = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        solve(nums,perms,ans, visited);
        return ans.size();
    }
}
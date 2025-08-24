class Solution {
    public int longestSubarray(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
            ans.add(i);
        }
        if(ans.size()<=1)
           return nums.length-1;
        int ans1=0;
        ans1=ans.get(0);
        for(int i=1;i<ans.size();i++)
        ans1=Math.max(ans1,ans.get(i)-ans.get(i-1)-1);
        ans1=Math.max(ans1,nums.length-1-ans.get(ans.size()-1));
for(int i=0;i<ans.size()-2;i++)
ans1=Math.max(ans1,ans.get(i+2)-ans.get(i)-2);
ans1=Math.max(ans1,ans.get(1)-1);
 ans1=Math.max(ans1,nums.length-1-ans.get(ans.size()-2)-1);
 return ans1;
    }
}
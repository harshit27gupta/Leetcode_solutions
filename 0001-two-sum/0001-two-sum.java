class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        ArrayList<Integer> ans=new ArrayList<>();
        int result[]=new int[2];
        for(int i=0;i<n;i++)
        ans.add(nums[i]);
        for(int i=0;i<n;i++){
            int val1=ans.get(i);
            int rem=target-val1;
            int ind=ans.lastIndexOf(rem);
            if(ind>=0 && ind!=i)
            {
                result[0]=i;
                result[1]=ind;
            break;
            }
        }
        return result;
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int n=nums.length;
        int ele1=0,ele2=0;
        int cnt1=0,cnt2=0;
        int i=0;
        while(i<n){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1=1;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2=1;
            }
            else if(nums[i]==ele1)
            cnt1++;
            else  if(nums[i]==ele2)
            cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
            i++;
        }
        cnt1=0;
        cnt2=0;
        i=0;
        for(i=0;i<n;i++){
            if(nums[i]==ele1)
            cnt1++;
            else if(nums[i]==ele2)
            cnt2++;
        }
        if(cnt1>n/3)
        ans.add(ele1);
        if(cnt2>n/3)
        ans.add(ele2);
        return ans;
    }
}
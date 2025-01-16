class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans1=0;
        int ans2=0;
        for(int i:nums1)
        ans1^=i;
        for(int i:nums2)
        ans2^=i;
        if(nums1.length%2==0 && nums2.length%2==0)
        return 0;
        if(nums1.length%2==0)
        return ans1;
        if(nums2.length%2==0)
        return ans2;
        return ans1^ans2;

    }
}
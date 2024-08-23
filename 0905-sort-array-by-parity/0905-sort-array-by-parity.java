class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int freq[]=new int[5001];
        for(int i:nums)
        freq[i]++;
        int ind=0;
        for(int i=0;i<=5000;i+=2){
            while(freq[i]>0){
                nums[ind]=i;
                freq[i]--;
                ind++;
            }
        }
          for(int i=1;i<5000;i+=2){
            while(freq[i]>0){
                nums[ind]=i;
                freq[i]--;
                ind++;
            }
        }
        return nums;
    }
}
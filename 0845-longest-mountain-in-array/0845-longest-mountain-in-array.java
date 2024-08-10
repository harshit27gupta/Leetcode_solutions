class Solution {
    public int longestMountain(int[] arr) {
        int ans=0;
        for(int i=1;i<arr.length-1;i++){
        int left=0;
        int right=0;
        for(int j=i;j>0;j--){
            if(arr[j]>arr[j-1])
            left++;
            else
            break;
        }
        for(int k=i;k<arr.length-1;k++){
            if(arr[k]>arr[k+1])
            right++;
            else
            break;
        }
        if(left!=0 && right!=0)
        ans=Math.max(left+right+1,ans);
        }
        return ans;
    }
}
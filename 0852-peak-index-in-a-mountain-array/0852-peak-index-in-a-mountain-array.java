class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=1;
        int r=arr.length-2;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]>=arr[mid-1] && arr[mid]>arr[mid+1]){
                ans=mid;
                break;
            }
         if(arr[mid]>=arr[mid-1])
         l=mid+1;
         else
         r=mid-1;
        }
        return ans;
    }
}
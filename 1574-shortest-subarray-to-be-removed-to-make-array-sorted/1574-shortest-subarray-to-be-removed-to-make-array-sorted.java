class Solution {
    static boolean left_increase[];
      static boolean right_increase[];
      static boolean check(int mid,int arr[],int n){
        for(int i=mid-1;i<n;i++){
            int idx1=i-mid;
            int idx2=i+1;
            int l=(idx1<0?Integer.MIN_VALUE:arr[idx1]);
                int r=(idx2>=n?Integer.MAX_VALUE:arr[idx2]);
            boolean left=(idx1<0?true:left_increase[idx1]);
             boolean right=(idx2>=n?true:right_increase[idx2]);
             if(left && right && l<=r)
             return true;
        }
        return false;
      }
      static void fill(int n,int arr[]){
        for(int i=1;i<n;i++){
if(arr[i]>=arr[i-1])
left_increase[i]=true;
else
break;
        }
          for(int i=n-2;i>=0;i--){
if(arr[i]<=arr[i+1])
right_increase[i]=true;
else
break;
        }
      }
    public int findLengthOfShortestSubarray(int[] arr) {
        int n=arr.length;
        left_increase=new boolean[n];
        left_increase[0]=true;
        right_increase=new boolean[n];
             right_increase[n-1]=true;
        fill(n,arr);
        int l=0;
        int r=n-1;
        int ans=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(check(mid,arr,n)){
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}
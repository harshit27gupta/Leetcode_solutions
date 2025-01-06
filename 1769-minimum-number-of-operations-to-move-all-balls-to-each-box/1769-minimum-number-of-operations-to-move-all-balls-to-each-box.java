class Solution {
    public int[] minOperations(String s) {
        int n=s.length();
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        prefix[0]=(s.charAt(0)=='0'?0:1);
         suffix[n-1]=(s.charAt(n-1)=='0'?0:1);
                for(int i=1;i<n;i++)
prefix[i]=prefix[i-1]+(s.charAt(i)=='1'?1:0);
     for(int i=n-2;i>=0;i--)
suffix[i]=suffix[i+1]+(s.charAt(i)=='1'?1:0);
            for(int i=1;i<n;i++)
prefix[i]+=prefix[i-1];
     for(int i=n-2;i>=0;i--)
suffix[i]+=suffix[i+1];
int ans[]=new int[n];
for(int i=0;i<n;i++){
    int left=0,right=0;
    if(i<n-1)
    right=suffix[i+1];
    if(i>=1)
    left=prefix[i-1];
    ans[i]=left+right;
}
return ans;
    }
}
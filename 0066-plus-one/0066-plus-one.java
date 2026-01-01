class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int i=n-1;
        while(i>=0 && digits[i]==9)
        i--;
       if(i<0){
            int ans[]=new int[n+1];
           ans[0]=1;
           for(int j=1;j<=n;j++)
           ans[j]=0;
           return ans;
       }
       else{
            int ans[]=new int[n];
           for(int j=0;j<=i;j++)
           ans[j]=digits[j];
           ans[i]+=1;
           for(int j=i+1;j<n;j++)
           ans[j]=0;
       return ans;
       }
        
       
    }
}
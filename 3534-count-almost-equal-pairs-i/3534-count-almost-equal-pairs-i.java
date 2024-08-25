class Solution {
    public int countPairs(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(eql(nums[i],nums[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static boolean eql(int x,int y){
        int[] a1=arr(x);
        int[] a2=arr(y);
        int a=-1;
        int b=-1;
        int c=0;
        for(int k=0;k<7;k++){
            if(a1[k]!=a2[k]){
                b=a;
                a=k;
                c++;
            }
        }
        if(c==0) return true;
        if(c==1) return false;
        if(c>2) return false;
        if(a1[a]==a2[b]&&a1[b]==a2[a]) return true;
        return false;
    }
    public static int[] arr(int num){
        int[] cnt=new int[7];
        int i=0;
        while(num>0){
            cnt[i]=num%10;
            num/=10;
            i++;
        }
        return cnt;
    }
}
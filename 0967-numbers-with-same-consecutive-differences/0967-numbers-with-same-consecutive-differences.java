class Solution {
    static void ways(int n,int len,int k,int num,List<Integer> ans){
        if(len==n)
        {
ans.add(num);
return ;
        }
        for(int i=0;i<=9;i++){
            if(Math.abs(i-num%10)==k)
            ways(n,len+1,k,num*10+i,ans);
        }
    }
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++)
       ways(n,1,k,i,ans);
       int arr[]=new int[ans.size()];
       for(int i=0;i<ans.size();i++)
       arr[i]=ans.get(i);
       return arr;
    }
}
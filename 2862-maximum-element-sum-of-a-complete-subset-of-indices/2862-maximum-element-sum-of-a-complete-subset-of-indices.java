class Solution {
    public long maximumSum(List<Integer> nums) {
int n=nums.size();
long ans[]=new long[n];
for(int i=1;i<=n;i++){
    long prod=1;
    long num=i;
    for(int j=2;j*j<=num;j++){
    if(num%j==0){
        int cnt=0;
        while(num%j==0){
            num=num/j;
            cnt++;
        }
        if(cnt%2==1)
        prod*=j;
    }
    }
    if(num>0)
    prod*=num;
    ans[i-1]=prod;
}
HashMap<Long,Long> map=new HashMap<>();
for(int i=0;i<n;i++){
    long cc=ans[i];
    map.put(cc,map.getOrDefault(cc,0L)+nums.get(i));
}
long res=0;
for(long i:map.values())
res=Math.max(res,i);
return res;

    }
}
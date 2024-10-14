class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
for(int i:nums)
pq.offer(i);
long ans=0;
while(k>0){
int cc=pq.poll();
ans+=cc;
pq.offer(cc/3+Math.min(cc%3,1));
k--;
}
return ans;
    }
}
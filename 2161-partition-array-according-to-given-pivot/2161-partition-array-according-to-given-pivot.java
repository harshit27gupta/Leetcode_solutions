class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int ans[]=new int[nums.length];
        int idx=0;
        ArrayList<Integer> less=new ArrayList<>();
                ArrayList<Integer>great=new ArrayList<>();
int cnt=0;
for(int i:nums){
    if(i==pivot)
    cnt++;
    else if(i<pivot)
    less.add(i);
    else
    great.add(i);
}
for(int i:less)
ans[idx++]=i;
while(cnt>0){
    ans[idx++]=pivot;
    cnt--;
}
for(int i:great)
ans[idx++]=i;
return ans;

    }
}
class Solution {
    public int[] finalPrices(int[] prices) {
        int nextsmaller[]=new int[prices.length];
        Arrays.fill(nextsmaller,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i]){
                nextsmaller[st.pop()]=i;
            }
            st.push(i);
        }
int ans[]=new int[prices.length];
for(int i=0;i<prices.length;i++){
    if(nextsmaller[i]==-1)
    ans[i]=prices[i];
    else
    ans[i]=prices[i]-prices[nextsmaller[i]];
}
return ans;
    }
}
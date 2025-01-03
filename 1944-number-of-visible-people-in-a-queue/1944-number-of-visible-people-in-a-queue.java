class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int right[]=new int[n];
        Arrays.fill(right,-1);
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]<heights[i])
            right[st.pop()]=i;
            st.push(i);
        }
       
        int ans[]=new int[n];
        Arrays.fill(ans,1);
        ans[n-1]=0;
      for(int i=n-3;i>=0;i--){
        int num1=heights[i];
        int j=i+1;
        if(num1<heights[j])
        continue;
        while(right[j]!=-1 && heights[right[j]]<num1){
            j=right[j];
            ans[i]++;
        }
        if(right[j]!=-1)
        ans[i]++;
      }
        return ans;
        
    }
}
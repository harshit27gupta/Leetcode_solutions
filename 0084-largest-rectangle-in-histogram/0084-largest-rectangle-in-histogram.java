class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int base=st.pop();
                int previous_smaller_element=(st.isEmpty()?-1:st.peek());
                int next_smaller_element=i;
                maxArea=Math.max(maxArea,heights[base]*(next_smaller_element-previous_smaller_element-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
             int base=st.pop();
                int previous_smaller_element=(st.isEmpty()?-1:st.peek());
                int next_smaller_element=heights.length;
                maxArea=Math.max(maxArea,heights[base]*(next_smaller_element-previous_smaller_element-1));
        }
        return maxArea;
    }
}
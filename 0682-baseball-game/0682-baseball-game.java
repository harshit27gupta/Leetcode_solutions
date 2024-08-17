class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("+")){
int num1=st.pop();
int nums2=st.pop();
st.push(nums2);
st.push(num1);
st.push(num1+nums2);
            }
            else if(operations[i].equals("D")){
st.push(2*st.peek());
            }
           else if(operations[i].equals("C")){
st.pop();
            }
            else
            st.push(Integer.parseInt(operations[i]));
        }
        int sum=0;
        while(!st.isEmpty())
        sum+=st.pop();
        return sum;
    }
}
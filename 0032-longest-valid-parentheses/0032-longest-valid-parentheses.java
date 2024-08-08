class Solution {
    public static int longestValidParentheses(String s) 
    {
      Stack<Integer> ss=new Stack<>();
ss.push(-1);
int ans=0;
for(int i=0;i<s.length();i++){
    if(s.charAt(i)=='(')
    ss.push(i);
    else{
ss.pop();
if(ss.isEmpty()){
    ss.push(i);
}
else
ans=Math.max(ans,i-ss.peek());
    }
}
return ans;
    }
}
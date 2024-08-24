class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<n;i++)
        {
            stk.push(s.charAt(i));
            if(s.charAt(i)=='c' && stk.size()>=3)
            {
                char c,b,a;
                c = stk.pop();
                b = stk.pop();
                a = stk.pop();
                if(a=='a' && b=='b' && c=='c')
                  continue;
                else
                {
                    stk.push(a);
                    stk.push(b);
                    stk.push(c);
                }
            }
            else if(s.charAt(i)=='c')
                return false;
        }
        return stk.empty();
    }
}
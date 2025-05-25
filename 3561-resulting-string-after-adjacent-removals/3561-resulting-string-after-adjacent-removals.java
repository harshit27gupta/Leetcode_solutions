class Solution {
    static char prev(char c){
        if(c=='a')
        return 'z';
        return (char)((int)c-1);
    }
    static char next(char c){
          if(c=='z')
        return 'a';
        return (char)((int)c+1);
    }
    public String resultingString(String s) {
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            int future=next(ch);
            int back=prev(ch);
            if(!st.isEmpty() && (st.peek()==future || st.peek()==back))
            st.pop();
            else
            st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}
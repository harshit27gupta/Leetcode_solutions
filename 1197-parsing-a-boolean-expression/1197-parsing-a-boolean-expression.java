class Solution {
    char AND(Stack<Character> st){
        while(!st.isEmpty())
            if(st.pop() == 'f') return 'f';
        return 't';
    }
    char OR(Stack<Character> st){
        while(!st.isEmpty())
            if(st.pop() =='t') return 't';
        return 'f';
    }
    char NOT(Stack<Character> st){
        return st.pop()=='t'?'f':'t';
    }
    Stack<Character> helper(StringBuilder exp){
        Stack<Character> st  = new Stack<Character>();
        for(int i=2;i<exp.length()-1;i++){
            char ch = exp.charAt(i);
            if(ch=='f' || ch=='t') st.push(ch);
            else if(ch==',') continue;
            else {
                StringBuilder str  = new StringBuilder(""+exp.charAt(i));
                int top = -1;
                for(int j = i+1;j<exp.length()-1;j++){
                    char t = exp.charAt(j);
                    if(t=='(') top++;
                    else if(t==')') top--;
                    str.append(t);
                    if(top==-1) {
                        i = j+1;
                        break;
                    }
                }
                st.push(parse(str));
            }
        }
        return st;
    }
    char parse(StringBuilder exp){
        if(exp.length()==1) return exp.charAt(0);
        Stack<Character> st = helper(exp);
        if(exp.charAt(0)=='&')    return AND(st);
        else if(exp.charAt(0)=='|')    return OR(st);
        return NOT(st);
    }
    public boolean parseBoolExpr(String expression) {
        return parse(new StringBuilder(expression))=='t';
    }
}
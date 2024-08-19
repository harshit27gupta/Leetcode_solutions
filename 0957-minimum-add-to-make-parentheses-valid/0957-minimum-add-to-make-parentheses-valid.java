class Solution {
    public int minAddToMakeValid(String S) {
        Stack s = new Stack<>();
        int c = 0;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                s.add(S.charAt(i));
            }
            else{
                if(!s.isEmpty()){
                    s.pop();
                }
                else{
                    c++;
                }
            }
        }
        c = c + s.size();
        return c;
    }
}
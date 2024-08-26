class Solution {
    static String generate(String s){
            Stack<Character> st1=new Stack<>();
          for(char c:s.toCharArray()){
            if(c=='#'){
                if(!st1.isEmpty())
                st1.pop();
            }
            else
            st1.push(c);
        }
        String res="";
        while(!st1.isEmpty())
        res+=st1.pop();
        return res;
    }
    public boolean backspaceCompare(String s, String t) {
    String t1=generate(s);
    String t2=generate(t);
    return (t1.equals(t2));
       
    }
}
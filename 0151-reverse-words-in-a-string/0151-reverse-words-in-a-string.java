class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        s=s+" ";
        String ans="";
        int j=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(s.charAt(i-1)==' ')
                j=i+1;
                else
            {
                String get=s.substring(j,i+1);
                ans=get+ans;
                j=i+1;
            }
            }
        }
        ans=ans.trim();
        return ans;
    }
}
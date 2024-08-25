class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> st=new HashSet<>();
        for(String c:emails){
            String str="";
            boolean skip=false;
            int i=0;
            for(;i<c.length() && c.charAt(i)!='@';i++){
                if(skip)
                continue;
                if(c.charAt(i)=='+'){
                    skip=true;
                    continue;
                }
                if(c.charAt(i)=='.')
                continue;
                str+=c.charAt(i);
            }
            str+=c.substring(i);
            st.add(str);
        }
        return st.size();
    }
}
class Solution {
    public boolean hasMatch(String s, String p) {
        int idx=p.indexOf('*');
        s=" "+s+" ";
        String s1=p.substring(0,idx);
        String s2=p.substring(idx+1);
        int idx1=s.indexOf(s1);
        int len=s1.length();
        int idx2=s.lastIndexOf(s2);
        if(idx1!=-1 && idx2!=-1 && (idx1+len)<=idx2)
        return true;
        return false;
    }
}
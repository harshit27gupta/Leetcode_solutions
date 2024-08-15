class Solution {
    public boolean checkRecord(String s) {
        int cnt=0;
        int abs=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                abs++;
                cnt=0;
                if(abs==2)
                return false;
            }
            else if(s.charAt(i)=='L'){
                cnt++;
                if(cnt==3)
                return false;
            }
            else
                cnt=0;
        }
        return true;
    }
}
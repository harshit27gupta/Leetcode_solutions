class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb=new StringBuilder();
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=s.charAt(i)-'a';
            if((i+1)%k==0){
                int rem=sum%26;
                sb.append((char)(rem+97));
                sum=0;
            }
        }
        return sb.toString();
    }
}
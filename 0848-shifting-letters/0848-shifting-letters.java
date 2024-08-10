class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        long shift[]=new long[shifts.length];
        shift[shifts.length-1]=shifts[shifts.length-1];
        for(int i=shifts.length-2;i>=0;i--)
        shift[i]=shift[i+1]+shifts[i];
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            long res=s.charAt(i)-'a';
            res=(res+shift[i]%26)%26;
            sb.append((char)((int)res+'a'));
        }
        return sb.toString();
    }
}
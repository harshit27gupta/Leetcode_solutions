class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char s11[]=new char[2];
        char s12[]=new char[2];
        int j=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i))
            continue;
            if(j==2)
            return false;
            s11[j]=s1.charAt(i);
            s12[j]=s2.charAt(i);
            j++;
        }
        return (s11[0]==s12[1] && s11[1]==s12[0]);
    }
}
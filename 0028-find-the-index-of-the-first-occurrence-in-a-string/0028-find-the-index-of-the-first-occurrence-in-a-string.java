class Solution {
    static int[] lps(String needle){
        int lps[]=new int[needle.length()];
        int j=0,i=1;
        while(i<needle.length()){
            if(needle.charAt(i)==needle.charAt(j)){
                lps[i++]=++j;
            }
            else if(j!=0)
            j=lps[j-1];
            else
            lps[i++]=0;
        }
        return lps;
    }
    public int strStr(String haystack, String needle) {
        //compute lps array
        int lps[]=lps(needle);
        //now perform string match
        int i=0,j=0;
        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }
             if(j==needle.length())
                return i-needle.length();
           if(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j))
           if(j!=0)
           j=lps[j-1];
           else
           i++;
        }
        return -1;
    }
}
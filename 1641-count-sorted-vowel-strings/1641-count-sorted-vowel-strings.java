class Solution {
    public int countVowelStrings(int n) {
        //basically x1+x2+x3+x4+x5==n
        //ans->n+r-1Cr-1
        return (n+1)*(n+2)*(n+3)*(n+4)/24;
    }
}
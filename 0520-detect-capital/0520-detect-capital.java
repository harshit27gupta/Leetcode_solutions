class Solution {
    public boolean detectCapitalUse(String word) {
        int cap=0;
     for(int i=0;i<word.length();i++){
        int val=(int)(word.charAt(i));
        if(val>=65 && val<=90)
        cap++;
     }
     if(cap==word.length() || cap==0 || (cap==1 && word.charAt(0)>='A' && word.charAt(0)<='Z'))
     return true;
     return false;

    }
}
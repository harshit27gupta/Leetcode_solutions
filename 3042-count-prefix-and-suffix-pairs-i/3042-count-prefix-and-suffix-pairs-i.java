class Solution {
    static boolean isprefix_and_suffix(String s1,String s2){
        if(s1.length()>s2.length())
            return false;
        int i=0;
        int n=s2.length();
        int n1=s1.length();
        for(;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i) && s1.charAt(n1-i-1)==s2.charAt(n-i-1))
                continue;
            else
                break;
        }
        if(i!=s1.length())
            return false;
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int ans=0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if(isprefix_and_suffix(words[i],words[j]))
                    ans++;
            }
        }
        return ans;
    }
}
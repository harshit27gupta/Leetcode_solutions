class Solution {
    static String check(String t) {
    String res = "";
    int ct = 0;
    char ch = '@';
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < t.length(); i++) {
        char currentChar = t.charAt(i);
        if (ch == '@' || ch == currentChar) {
            ct++;
        } else {
            res += ct;
            res += ch;
            ct = 1;
        }
        ch = currentChar;
    }

    if (ct > 0) {
        res += ct;
        res += ch;
    }

    return res;
}
static boolean stretchy(String orig,String checker){
if(orig.length()!=checker.length())
return false;
for(int i=1;i<orig.length();i+=2){
    char ch1=orig.charAt(i);
    int freq1=orig.charAt(i-1)-'0';
      char ch2=checker.charAt(i);
    int freq2=checker.charAt(i-1)-'0';
    if(ch1!=ch2)
    return false;
    if(freq1<freq2)
    return false;
    if(freq1<=2 && freq1!=freq2)
    return false;
    continue;
}
return true;
}

    public int expressiveWords(String s, String[] words) {
        String str=check(s);
        int ans=0;
        for(int i=0;i<words.length;i++){
            String comp=check(words[i]);
ans+=stretchy(str,comp)?1:0;
        }
        return ans;
    }
}
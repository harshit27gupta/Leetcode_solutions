class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int freql[]=new int[26];
        int frequ[]=new int[26];
        for(int i=0;i<stones.length();i++){
            char ch=stones.charAt(i);
            if(ch>='a' && ch<='z')
            freql[ch-'a']++;
            else
            frequ[ch-'A']++;
        }
        int ans=0;
        for(char c:jewels.toCharArray()){
            if(c>='A' && c<='Z')
            ans+=frequ[c-'A'];
            else
            ans+=freql[c-'a'];
        }
        return ans;
    }
}
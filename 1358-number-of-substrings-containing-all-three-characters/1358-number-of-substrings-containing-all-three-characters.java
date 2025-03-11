class Solution {
    public int numberOfSubstrings(String s) {
        int ans=0;
        int freq[]=new int[3];
        int i=0;
        int n=s.length();
        int j=0;
        for(char c:s.toCharArray()){
            freq[c-'a']++;
            while(i<j && freq[0]>0 && freq[1]>0 && freq[2]>0){
                ans+=(n-j);
                freq[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return ans;
    }
}
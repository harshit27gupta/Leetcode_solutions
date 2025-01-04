class Solution {
    public int countPalindromicSubsequence(String s) {
        int first[]=new int[26];
        Arrays.fill(first,-1);
        int last[]=new int[26];
        Arrays.fill(last,-1);
        int n=s.length();
        for(int i=0;i<n;i++){
last[s.charAt(i)-'a']=i;
if(first[s.charAt(i)-'a']==-1)
first[s.charAt(i)-'a']=i;
        }
          Set<Character> st=new HashSet<>();
        int ans=0;
        for(int i=0;i<26;i++){
            int i1=first[i];
            int i2=last[i];
            if(i1==i2)
            continue;
            i1+=1;
            i2-=1;
            for(;i1<=i2;i1++)
            st.add(s.charAt(i1));
            ans+=st.size();
            st.clear();
        }
        return ans;
    }
}
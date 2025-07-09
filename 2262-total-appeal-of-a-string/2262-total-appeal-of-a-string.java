class Solution {
    static long ways(char ch,String s){
        long cnt=0;
        long ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                ans+=(cnt*(cnt+1))/2;
                cnt=0;
            }
            else
            cnt++;
        }
        ans+=(cnt*(cnt+1))/2;
        long k=s.length();
        return (k*(k+1))/2-ans;

    }
    public long appealSum(String s) {
        long ans=0;
        for(int i=0;i<26;i++)
        ans+=ways((char)(i+97),s);
        return ans;
    }
}
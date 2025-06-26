class Solution {
    public int longestSubsequence(String s, int k) {
        if(Integer.parseInt(s,2)<=k)
        return s.length();
        int n=s.length();
     int cnt=0;
     int last=-1;
     for(int i=0;i<n;i++){
        char c=s.charAt(i);
        if(c=='0'){
        cnt++;
        last=i;
     }
     }
if(cnt==0)
return Integer.bitCount(k);
//try checking for 000{1}000{1}0 type i.e last digit is 0 only
int idx=1;
int tmp=last;
int val=0;
while(tmp>=0){
    if(s.charAt(tmp)=='1' && val+(1<<idx)<=k){
        cnt++;
        val+=(1<<idx);
    }
    else if(s.charAt(tmp)=='1')
    break;
    idx++;
    tmp--;
}
if(last!=s.length()-1){
    if(val+1<=k)
    cnt++;
}
return cnt;


    }
}
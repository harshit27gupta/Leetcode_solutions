class Solution {
  static String encode(String str){
    char ch=str.charAt(0);
    int cnt=0;
    StringBuilder sb=new StringBuilder();
for(int i=0;i<str.length();i++){
if(str.charAt(i)==ch)
cnt++;
else{
sb.append(cnt+""+(ch));
cnt=0;
ch=str.charAt(i);
i--;
}
}
if(cnt>0)
    sb.append(cnt+""+(ch));
return sb.toString();
  }
    public String countAndSay(int n) {
       if(n==1)
        return "1";
        if(n==2)
        return "11";
        if(n==3)
        return "21";
        String ans="21";
        for(int i=4;i<=n;i++)
        ans=encode(ans);
        return ans;

    }
}
class Solution {
    public String maskPII(String s) {
        StringBuilder sb=new StringBuilder();
        if(s.indexOf('@')>0){
            int j=s.indexOf('@');
sb.append(Character.toLowerCase(s.charAt(0))+"*****"+Character.toLowerCase(s.charAt(j-1))+"@");
int k=s.indexOf('.');
sb.append(s.substring(j+1,k).toLowerCase()+s.substring(k).toLowerCase());
        }
        else{
            int len=s.length();
            int temp=len;
            for(int i=0;i<s.length();i++){
                if(!Character.isDigit(s.charAt(i)))
                len--;
            }
            if(len==11)
            sb.append("+*-");
            else if(len==12)
            sb.append("+**-");
            else if(len==13)
            sb.append("+***-");
            sb.append("***-***-");
           String res="";
           int max=4;
           for(int i=temp-1;i>=0 && max>0;i--){
            if(Character.isDigit(s.charAt(i))){
                max--;
                res+=s.charAt(i);
            }
           }
           sb.append(new StringBuilder(res).reverse())  ;  
             }
             return sb.toString();
    }
}
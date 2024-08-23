class Solution {
    public String toGoatLatin(String sentence) {
        String arr[]=sentence.split(" ");
        String str="aeiouAEIOU";
        String ans="";
        String add="a";
        for(int i=0;i<arr.length;i++){
            String word1=arr[i];
            if(str.indexOf(word1.charAt(0))<0){
                if(word1.length()>1)
                ans+=word1.substring(1);
                ans+=word1.charAt(0);
            }
            else
            ans+=word1;
            ans+="ma";
            ans+=add;
         add+="a";   
         ans+=" ";
        }
        return ans.trim();
    }
}
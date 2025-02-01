class Solution {
    public String findValidPair(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            int digit=c-'0';
            map.put(digit,map.getOrDefault(digit,0)+1);
        }
        int n=s.length();
        for(int i=0;i<n-1;i++){
            int j=i+1;
                int dig1=s.charAt(i)-'0';
                int dig2=s.charAt(j)-'0';
if(dig1!=dig2 && map.get(dig1)==dig1 && map.get(dig2)==dig2){
StringBuilder sb=new StringBuilder();
sb.append(s.charAt(i));
sb.append(s.charAt(j));
return sb.toString();
            }
        }
        return "";
    }
}
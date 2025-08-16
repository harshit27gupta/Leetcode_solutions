class Solution {
    public int maximum69Number (int num) {
        String str=Integer.toString(num);
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='6')
                return Integer.parseInt(str.substring(0,i)+"9"+str.substring(i+1));
        }
        return num;
    }
}
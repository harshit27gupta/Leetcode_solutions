class Solution {
    public int binaryGap(int n) {
       String s=Integer.toBinaryString(n);
        int mx=0;
        int start=s.indexOf('1');
        for(int i=0;i<s.length();i++)
        {

            if(s.charAt(i)=='1')
            {
                 mx=Math.max(mx,i-start);
                 start=i;
            }
        }
        return mx;
    }
}
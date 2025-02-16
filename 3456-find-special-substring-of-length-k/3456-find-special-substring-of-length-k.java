class Solution {
    public boolean hasSpecialSubstring(String s, int k) {
        if(k==s.length() && k==1)
        return true;
        char arr[]=s.toCharArray();
        for(int i=0;i<arr.length-k+1;i++){
            Set<Character> st=new HashSet<>();
            for(int j=i;j<=i+k-1;j++)
            st.add(arr[j]);
            if(st.size()>1)
            continue;
            boolean left=(i==0?true:arr[i-1]!=arr[i]?true:false);
            boolean right=(i==arr.length-k?true:arr[i+k-1]!=arr[i+k]?true:false);
            if(left && right)
            return true;
        }
    return false;
}
}
class Solution {
    static int  check(int A[],int B[],int i){
        Set<Integer> st=new HashSet<>();
        for(int k=0;k<=i;k++)
        st.add(A[k]);
        int cnt=0;
        for(int k=0;k<=i;k++){
            if(st.contains(B[k]))
            cnt++;
        }
        return cnt;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int ans[]=new int[n];
        ans[n-1]=n;
for(int i=0;i<n-1;i++)
ans[i]=check(A,B,i);
return ans;
    }
}
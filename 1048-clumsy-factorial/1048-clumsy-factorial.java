class Solution {
    public int clumsy(int n) {
        
        int ans=n;
        int j=n-1;
        boolean t=true;
        Stack<Integer>stk=new Stack<>();
        for(int i=1;i<n;i++)
        {
            if(i%4==0||i%4==3)
            {
                stk.push(ans);
                
                if(t)
                    ans=j--;
                else
                    ans=(-1*j--);
                t=!t;
                
            }
            else if(i%4==1)
                ans*=j--;
            else
                ans/=j--;
        }
        int sum=0;
        while(!stk.isEmpty())
        {
            sum+=stk.pop();
            
        }
        return sum+ans;
        
    }
}
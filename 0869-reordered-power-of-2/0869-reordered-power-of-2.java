class Solution {
    static List<Integer> digit(int num){
        List<Integer> digits=new ArrayList<>();
        while(num>0){
            digits.add(num%10);
            num=num/10;
        }
        return digits;
    }
    static boolean isposs(int i,int n){
        List<Integer> digi1=digit(i);
        List<Integer> digi2=digit(n);
        if(digi1.size()!=digi2.size())
        return false;
        Collections.sort(digi1);
        Collections.sort(digi2);
        for(int ii=0;ii<digi1.size();ii++){
            if(digi1.get(ii)!=digi2.get(ii))
            return false;
        }
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        List<Integer> digits=digit(n);
        Collections.sort(digits,Collections.reverseOrder());
        long maxposs=0;
        for(int i=0;i<digits.size();i++)
        maxposs=maxposs*10+digits.get(i);
        int i=1;
        while(i<=maxposs){
            if(isposs(i,n))
            return true;
            i*=2;
        }
        return false;
    }
}
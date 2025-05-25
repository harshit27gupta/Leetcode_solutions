class Solution {
    static boolean prime(long num){
        if(num==1)
        return false;
        for(long i=2;i*i<=num;i++){
            if(num%i==0)
            return false;
        }
        return true;
    }
    public long sumOfLargestPrimes(String s) {
        Set<Long> st=new HashSet<>();
        for(int i=0;i<s.length();i++){
            long num=0;
            for(int j=i;j<s.length();j++){
num=(num*10)+s.charAt(j)-'0';
if(st.contains(num))
continue;
if(prime(num))
st.add(num);
            }
        }
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(long i:st){
        pq.offer(i);
        }
        long sum=0;
        int cnt=3;
        cnt=Math.min(cnt,pq.size());
        while(cnt-->0)
        sum+=pq.poll();
        return sum;

    }
}
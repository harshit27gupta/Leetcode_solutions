class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        long sum=0;
        int len=pizzas.length;
            int doit=((len/4)%2==1?len/4:len/4-1);
            int idx=len-1;
            while(doit>0){
                sum+=pizzas[idx];
                idx--;
                doit--;
              }
              idx--;
              if((len/4)%2==0)
              sum+=pizzas[idx];
              return sum;
    }
}
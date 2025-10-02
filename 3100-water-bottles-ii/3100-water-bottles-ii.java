class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptybottle=0;
        int drunk=0;
        while(numBottles!=0 ){
            drunk+=numBottles;
            emptybottle+=numBottles;
            numBottles=0;
            while(numExchange<=emptybottle){
                emptybottle-=numExchange;
                numExchange++;
                numBottles++;
            }
            
        }
        return drunk;
    }
}
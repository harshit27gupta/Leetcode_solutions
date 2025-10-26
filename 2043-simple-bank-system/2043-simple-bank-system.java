class Bank {
Map<Integer,Long> bal;
static int maxAcc;
    public Bank(long[] balance) {
        bal=new HashMap<>();
        maxAcc=0;
        for(int i=1;i<=balance.length;i++){
        bal.put(i,balance[i-1]);
        }
        maxAcc=bal.size();
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1>maxAcc || account2>maxAcc)
        return false;
        long amc=bal.get(account1);
        if(amc<money)
        return false;
        bal.put(account1,amc-money);
        bal.put(account2,bal.get(account2)+money);
        return true;
    }
    
    public boolean deposit(int account, long money) {
            if(account>maxAcc)
        return false;
        bal.put(account,bal.get(account)+money);
        return true;
    }
    
    public boolean withdraw(int account, long money) {
         if(account>maxAcc)
        return false;
        if(bal.get(account)<money)
        return false;
        bal.put(account,bal.get(account)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
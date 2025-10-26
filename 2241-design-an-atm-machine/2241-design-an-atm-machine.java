class ATM {
    int[] denoms;
    int[] bankNotes;
    public ATM() {
        bankNotes = new int[5];
        denoms = new int[]{20, 50, 100, 200, 500};
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            bankNotes[i] += banknotesCount[i];
        }    
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        for(int i = 4; i >=0; i--){
            if(amount>=denoms[i] * bankNotes[i]){
                ans[i] = bankNotes[i];
            } else {
                ans[i] = amount/denoms[i];
            }
            amount -= denoms[i]*ans[i];
            if(amount==0)break;
        }
        if(amount>0)return new int[]{-1};
        for(int i = 0; i < 5; i++){
            bankNotes[i] -= ans[i];
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
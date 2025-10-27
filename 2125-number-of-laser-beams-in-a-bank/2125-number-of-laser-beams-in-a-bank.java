class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0;
        int res = 0;
        for(int i = 0; i < bank.length; i++){
            int count = 0;
            for(int j = 0; j < bank[i].length(); j++){
                if(bank[i].charAt(j)=='1')count++;
            }
            if(count==0)continue;
            res += prev * count;
            prev = count;
        }
        return res;
    }
}
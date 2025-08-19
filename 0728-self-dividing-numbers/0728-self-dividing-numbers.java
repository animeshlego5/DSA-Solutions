class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        outer:
        for(int i = left; i <= right; i++){
            if(i<10){res.add(i); continue;}
            int num = i;
            while(num>0){
                int digit = num%10;
                if(digit==0)continue outer;
                if(i%digit!=0)continue outer;
                num = num/10;
            }
            res.add(i);
        }
        return res;
        
    }
}
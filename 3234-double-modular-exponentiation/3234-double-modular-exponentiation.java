class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < variables.length; i++) {
            int a = variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            int power = (int) customPow(a,b,10);
            int ans = (int) customPow(power,c,m);
            
            if (target == ans) {
                result.add(i);
            }
        }
        return result;
    }

    public long customPow(int base, int exponent, int modulus) {
        long answer = 1;
        base = base%modulus;
        while(exponent>0){
            if(exponent%2!=0){
                exponent -=1;
                answer = (answer * base)%modulus;
            }
            exponent /=2;
            base =(base*base)%modulus;
        }
        return answer;
    }
}
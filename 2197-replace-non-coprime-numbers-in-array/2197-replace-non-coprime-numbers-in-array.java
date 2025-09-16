class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int num : nums){
            res.add(num);

            while(res.size()>=2){
                int b = res.remove(res.size()-1);
                int a = res.remove(res.size()-1);

                int g = gcd(a, b);
                if(g > 1){
                    long l = (long)a/g * b;
                    res.add((int)l);
                } else {
                    res.add(a);
                    res.add(b);
                    break;
                }

            }
        }
        int size = res.size();
        return res;
    }
    private int gcd(int a, int b){
        while(b>0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
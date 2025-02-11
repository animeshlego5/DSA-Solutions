class Solution {
    public int superPow(int a, int[] b) {
        a = a % 1337;
        if (a == 0) {
            return 0;
        }
        Integer ans = 1;
        for (int powerj : b) {
            ans = powerz(ans, 10)%1337 * powerz(a, powerj)%1337;
            
        }
        return ans % 1337;
    }
    public static int powerz(int number, int powerz){
        int ans = 1;
        while (powerz > 0) {
                if (powerz % 2 == 1) {
                    ans = (ans * number) % 1337;
                    powerz = powerz - 1;
                } else {
                    powerz = powerz / 2;
                    number = (number * number) % 1337;
                }
            }
   return  ans%1337;}
}
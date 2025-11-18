class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        if(length%2==0){
            return false;
        } else {
            if(bits[length-1]==0)return true;
        }
        return false;
    }
}
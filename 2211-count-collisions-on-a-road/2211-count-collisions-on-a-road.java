class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        int left = 0, right = directions.length()-1;
        int n = directions.length();
        while(left<n && directions.charAt(left)=='L')left++;
        while(right>=0 && directions.charAt(right)=='R')right--;

        for(int i = left; i <=right; i++){
            if(directions.charAt(i)!='S')count++;
        }
        return count;
    }
}
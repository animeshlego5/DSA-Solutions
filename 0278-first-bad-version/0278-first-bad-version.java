/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left<=right){
            int middle = right - (right - left)/2;
            if(isBadVersion(middle)==true){
                right = middle - 1;
            } else left = middle + 1;
        }
        return right+1;
    }
}
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        int t = target;
        char answer = letters[0];

        while(start<=end){
            int mid = end + (start - end)/2;

            if (letters[mid] == target){
                start = mid + 1;
            } else if (letters[mid] > target) {
                end = mid - 1;
                answer = letters[mid];
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}
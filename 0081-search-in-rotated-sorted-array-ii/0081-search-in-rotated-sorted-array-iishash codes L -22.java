class Solution {
    public boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        boolean ans= false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return true;
            }
            if (arr[start]==arr[mid] && arr[mid]==arr[end]){
            start = start + 1;
            end = end - 1;
            }
            // left side is sorted
            else if (arr[start] <= arr[mid]) {
                // can ans be found in left side?
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } // right side is sorted 
            else {
                // can ans be found in right side?
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
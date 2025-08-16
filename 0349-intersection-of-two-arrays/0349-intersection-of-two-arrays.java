class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int n1 : nums1){
            int left = 0;
            int right = nums2.length- 1;
            while(left<=right){
                int middle = left + (right- left)/2;
                if(n1 == nums2[middle]){
                    res.add(n1);
                    break;
                }
                if(n1>nums2[middle]){
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        int size = res.size();
        int[] arr = new int[size];
        int idx = 0;
        for(int j : res){
            arr[idx] = j;
            idx++;
        }
        return arr;
    }
}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> s1 = new ArrayList<>();
        
        for(int n : nums1){
            s1.add(n);
        }
        List<Integer> res = new ArrayList<>();
        for(int j : nums2){
            if(s1.contains(j)){
                res.add(j);
                s1.remove(Integer.valueOf(j));
            }
        }
        int[] arr = new int[res.size()];
        int idx = 0;
        for(int k : res){
            arr[idx++] = k;
        }
        return arr;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }
        return quickSelect(list, k);
    }
    public int quickSelect(List<Integer>list, int k){
        if(list.size()==1)return list.get(0);
        Random rand = new Random();
        int pivotIndex = rand.nextInt(list.size());
        int pivot = list.get(pivotIndex);
        List<Integer> greater = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> lesser = new ArrayList<>();
        for(int num: list){
            if(num>pivot)greater.add(num);
            else if(num==pivot)equal.add(num);
            else lesser.add(num);
        }
        if(greater.size()>=k)return quickSelect(greater, k);
        if(greater.size()+equal.size()<k)return quickSelect(lesser, k-(greater.size()+equal.size()));
        return pivot;
    }
}
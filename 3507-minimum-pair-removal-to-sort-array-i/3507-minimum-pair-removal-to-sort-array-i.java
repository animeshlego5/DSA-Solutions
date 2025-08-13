class Solution {
    public int minimumPairRemoval(int[] nums) {
        if(nums.length == 0 || nums.length == 1)return 0;
        int ans = 0;
        List<Integer> list =  new ArrayList<>();
        for(int n : nums)list.add(n);

        while(hasIncrement(list)){
            int minSum = Integer.MAX_VALUE;
            int pairIndex = -1;
            for(int i = 0; i < list.size() - 1; i++){
                    int sum = list.get(i) + list.get(i+1);
                    if(minSum > sum){
                        minSum = sum;
                        pairIndex = i;
                    }  
            }

            //merge
            list.set(pairIndex, minSum);
            list.remove(pairIndex + 1);     
            ans++;       
        }
        return ans;
    }
    private boolean hasIncrement(List<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i)>list.get(i+1))return true;
        }
        return false;
    }
}
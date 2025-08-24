class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit = 0;
        List<int[]> jobProfile = new ArrayList<>();

        for(int i = 0; i < difficulty.length; i++){
            jobProfile.add(new int[]{difficulty[i],profit[i]});
        }
        Arrays.sort(worker);
        jobProfile.sort((a,b)-> Integer.compare(a[0],b[0]));

        int index = 0, maxProfit = 0, netProfit = 0;
        for(int w : worker){
            
            while(index<difficulty.length && w>=jobProfile.get(index)[0]){
                maxProfit = Math.max(maxProfit, jobProfile.get(index)[1]);
                index++;
            }
            netProfit += maxProfit; 
        }
    return netProfit;
    }
}
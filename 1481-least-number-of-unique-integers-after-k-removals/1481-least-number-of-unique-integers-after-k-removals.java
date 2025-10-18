class Solution {
    private class Count{
        int num;
        int freq;
        Count(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        int length = arr.length;
        PriorityQueue<Count> pq = new PriorityQueue<>((a,b) -> a.freq-b.freq);
        int current = arr[0];
        int count = 1;
        for(int i = 1; i < length; i++){
            if(arr[i]==current){
                count++;
            } else {
                Count entry = new Count(current, count);
                pq.add(entry);
                count = 1;
                current = arr[i];
            }
        }
        pq.add(new Count(current, count));

        while(k > 0 && !pq.isEmpty()){
            Count pull = pq.poll();
            int f = pull.freq;
            if(f<=k){
                k -= pull.freq;
            } else {
                pq.add(new Count(pull.num, f - k));
                k=0;
            } 
        }
        return pq.size();
    }
}
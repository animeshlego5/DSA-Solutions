
class Solution {
    
class Project implements Comparable<Project> {
        int capital;
        int profits;
        Project(int capital, int profits){
            this.capital = capital;
            this.profits = profits;
        }
        public int compareTo(Project that){
            return this.capital - that.capital;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            minPQ.offer(new Project(capital[i], profits[i]));
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while(k>0){
            while(!minPQ.isEmpty() && minPQ.peek().capital<=w){
                maxPQ.offer(minPQ.poll().profits);
            }
            if(maxPQ.isEmpty())break;
            w+=maxPQ.poll();
            k--;

        }
        return w;
    }
}
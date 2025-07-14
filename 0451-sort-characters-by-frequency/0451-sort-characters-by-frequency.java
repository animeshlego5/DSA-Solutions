class Solution {
    class Element implements Comparable<Element>{
        int freq;
        char ch;
        public Element (int freq, char ch){
            this.freq = freq;
            this.ch = ch;
        }
        public int compareTo(Element that){
            return this.freq - that.freq;
        }
        
    }
    public String frequencySort(String s) {
        PriorityQueue<Element> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            Element element = new Element(entry.getValue(), entry.getKey());
            pq.offer(element);
        }
        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            Element element = pq.poll();
            while(element.freq>0){
                sb.append(element.ch);
                element.freq--;
            }
        }
        return sb.toString();

    }
}
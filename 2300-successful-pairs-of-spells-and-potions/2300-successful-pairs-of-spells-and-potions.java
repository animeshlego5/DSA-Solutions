class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        for(int i = 0; i < spells.length; i++){
            int spell = spells[i];
            long product = 0;
            int left = 0; 
            int right = potions.length  -1;
            while(left<=right){
                int mid = left + (right - left)/2;
                product = spell * potions[mid];
                if(product >= success){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }    
            }
            pairs[i] = potions.length - right -1;
        }
        return pairs;
    }
}
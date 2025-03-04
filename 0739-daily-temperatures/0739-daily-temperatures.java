class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack <Integer> stack = new Stack<>();
        int k = 0;
        for(int i = 0;i<temperatures.length;i++){
            while(stack.size()!=0 && temperatures[stack.peek()]<temperatures[i]){
                int pop = stack.pop();
                result[pop]=(i-pop);
            }
            stack.push(i);
        }
        return result;
    }

}
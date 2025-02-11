class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i<variables.length;i++){
            int a =variables[i][0];
            int b = variables[i][1];
            int c = variables[i][2];
            int m = variables[i][3];
            int power = (int)Math.pow(a,b)%10;
            int bracket1 = (int)Math.pow(power,c);
            int ans = bracket1 %m;
            if(target==ans){
                result.add(i);
            }
        }
    return result;}
}
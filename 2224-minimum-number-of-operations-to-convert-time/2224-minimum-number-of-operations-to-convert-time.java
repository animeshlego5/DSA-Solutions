class Solution {
    public int convertTime(String current, String correct) {
        String[] currentArray = current.split(":");
        String[] correctArray = correct.split(":");
        int ch = Integer.valueOf(currentArray[0]);
        int cm = Integer.valueOf(currentArray[1]);
        int coh = Integer.valueOf(correctArray[0]);
        int com = Integer.valueOf(correctArray[1]);

        int diffhours = (coh-ch);
        int diffmins = com - cm;

        if(diffmins==0){
            return diffhours;
        } else if (diffmins>0){
            return calculateMinuteSteps(diffmins) + diffhours;
        } else {
            diffhours--; 
            int restmins = 60 - cm +com;
            return calculateMinuteSteps(restmins) + diffhours;
        }
    }
    private int calculateMinuteSteps(int minutes){
        int min15 = minutes/15;
        int rest1 = minutes % 15;
        int min5 = rest1/5;
        int rest2 = rest1 % 5;
        int min1 = rest2;
        return min15 + min5 + min1; 
    }
}
class Solution {
    public int compareVersion(String version1, String version2) {
        StringBuilder whole1 = new StringBuilder("");
        StringBuilder dec1 = new StringBuilder("");
        Boolean isWhole = true;
        for(char c : version1.toCharArray()){
            if(c=='.'){
                isWhole = false;
                continue;
            }
            if(isWhole){
                whole1.append(c);
            } else {
                dec1.append(c);
            }
        }
        StringBuilder whole2 = new StringBuilder("");
        StringBuilder dec2 = new StringBuilder("");
        isWhole = true;
        for(char c : version2.toCharArray()){
            if(c=='.'){
                isWhole = false;
                continue;
            }
            if(isWhole){
                whole2.append(c);
            } else {
                dec2.append(c);
            }
        }
        if(Integer.parseInt(whole1.toString())>Integer.parseInt(whole2.toString())){
            return 1;
        } else if(Integer.parseInt(whole1.toString())<Integer.parseInt(whole2.toString())){
            return -1;
        } else {
            if(Integer.parseInt(dec1.toString())>Integer.parseInt(dec2.toString())){
                return 1;
            } else if(Integer.parseInt(dec1.toString())<Integer.parseInt(dec2.toString())){
                return -1;
            } else {
                return 0;
            }
        }
    }
}
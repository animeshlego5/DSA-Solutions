class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = players.length;
        int t = trainers.length;
        int player = 0;
        int trainer =0;
        int ans = 0;
        if(p==0  || t==0)return 0;
        if(players[0]>trainers[t-1])return 0;

        while(player<p && trainer<t){
            if(players[player]>trainers[trainer]){
                trainer++;
            } else {
                player++;
                trainer++;
                ans++;
            }
        }
        return ans;
    }
}
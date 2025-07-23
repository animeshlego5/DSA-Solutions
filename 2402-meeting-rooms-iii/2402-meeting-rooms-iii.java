class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);
        long[] timeWhenRoomsAreAvailable = new long[n];
        int[] meetingsHeld = new int[n];
        for(int[]meeting : meetings){
            int start = meeting[0];
            int end = meeting[1];
            long minTimeWhenRoomWillBeAvailable = Long.MAX_VALUE;
            int nextAvailableRoom = 0;
            boolean foundRoom = false;
            for(int i = 0; i < n; i++){
                if(timeWhenRoomsAreAvailable[i]<=start){
                    timeWhenRoomsAreAvailable[i]=end;
                    meetingsHeld[i]++;
                    foundRoom = true;
                    break;
                }
                if(minTimeWhenRoomWillBeAvailable>timeWhenRoomsAreAvailable[i]){
                    minTimeWhenRoomWillBeAvailable = timeWhenRoomsAreAvailable[i];
                    nextAvailableRoom = i;
                }
            }
            if(!foundRoom){
                timeWhenRoomsAreAvailable[nextAvailableRoom] +=end - start;
                meetingsHeld[nextAvailableRoom]++;

            }
        }
        int bestRoom = 0;
        int res = 0;
        for(int i = 0; i < n; i++){
            if(meetingsHeld[i]>bestRoom){
                bestRoom = meetingsHeld[i];
                res = i;
            }
        }
        return res;
    }
}
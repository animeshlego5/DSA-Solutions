class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n+1];
        boolean[] visited = new boolean[n*n+1];
        int idx = 1;
        boolean leftToRight = true;
        for(int i = n-1; i >=0; i--){
            if(leftToRight){
                for(int j = 0; j < n; j++){
                    arr[idx++] = board[i][j];
                }
            } else {
                for(int j = n -1; j>=0; j--){
                    arr[idx++] = board[i][j];
                }
            }  
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int moves = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            moves++;
            for(int i = 0 ; i<size; i++){
                int current = queue.poll();
                for(int dice = 1; dice <=6; dice++){
                    int next = current + dice;
                    if(arr[next]!=-1)next = arr[next];
                    if(next>n*n)break;
                    if(next==n*n)return moves;
                    if(!visited[next]){
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return -1;
    }
}
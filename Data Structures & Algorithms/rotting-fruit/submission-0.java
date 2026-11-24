class Solution {
    private int[][] DIRECTIONS = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[] {i, j});
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        while(!queue.isEmpty() && fresh > 0){
            int queueSize = queue.size();
            result++;

            for(int i = 0; i < queueSize; i++){
                int[] current = queue.poll();

                for(int[] direction : DIRECTIONS){
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];

                    if(
                        (newRow >= 0 && newRow < rows)
                        && (newCol >= 0 && newCol < cols)
                        && (grid[newRow][newCol] == 1)
                    ){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        queue.offer(new int[] {newRow, newCol});
                    }
                }
            }
        }

        return fresh == 0 ? result : -1;
    }
}

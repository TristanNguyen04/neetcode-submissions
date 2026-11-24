class Solution {
    private int intermediate = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    intermediate = 0;
                    dfs(grid, i, j);
                    result = Math.max(result, intermediate);
                }
            }
        }

        return result;
    }


    private void dfs(int[][] grid, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0){
            return;
        }

        intermediate++;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}

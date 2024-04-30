import java.util.Arrays;

class Solution {
    // This array will store the minimum path sums calculated for each cell
    int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        // fill the memo array with -1 to indicate that no cell has been computed yet
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    // recursive dp function to calculates the min path sum to reach cell(i, j) from the top-left corner
    private int dp(int[][] grid, int i, int j){
        // base case
        // when we reach the top-left corner, return its value
        if(i == 0 && j == 0){
            return grid[0][0];
        }

        // if out of grid bounds, return a large number that won't be chosen
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE;
        }

        // if the result has been calculated, just return
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        // chose the min path sum from previous path, then add the current cell's value
        memo[i][j] = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];

        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int res = solution.minPathSum(grid);
        System.out.println(res);
    }
}
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     dp[i][0] = 1;
        // }
        // for(int j = 0; j < n; j++){
        //     dp[0][j] = 1;
        // }

        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
        //     }
        // }
        // return dp[m-1][n-1];

        memo = new int[m][n];
        return dp(m-1, n-1);
    }

    // dp function is to calculate the number of unique path to point (x,y) from (0,0)
    private int dp(int i, int j){
        //base case if we're at the start, there's exactly one way to be there
        if(i == 0 && j == 0){
            return 1;
        }

        // if out of bounds, return 0 as invalid path
        if(i < 0 || j < 0){
            return 0;
        }

        // check if the result has been computed to avoid redundant calculations
        if(memo[i][j] > 0){
            return memo[i][j];
        }

        memo[i][j] = dp(i - 1, j) + dp(i, j - 1);

        return memo[i][j];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 3, n = 7;
        int res = solution.uniquePaths(m, n);
        System.out.println(res);
    }
}

//Time Complecity: O(m*n)
//Space Complecity: O(m*n)
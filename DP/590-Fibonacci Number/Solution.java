class Solution {
    public int fib(int n) {
        // if(n == 1 || n == 0)return n;

        // int[] dp = new int[n + 1];

        // // base case
        // dp[0] = 0;
        // dp[1] = 1;

        // for(int i = 2; i <= n; i++){
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }

        // return dp[n];
        // TC: O(n) SC: O(n)

        //optimization
        if(n == 1 || n == 0)return n;

        int dp_i_1 = 1, dp_i_2 = 0;

        for(int i = 2; i <= n; i++){
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
        // TC: O(n) SC: O(1)
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        System.out.println (solution.fib(n));
    }
}
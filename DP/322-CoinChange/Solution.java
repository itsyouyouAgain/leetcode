import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        // create an array to store the minimum number of coins needed for each amount up to 'amount'
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            // try every coin that doesn't exceed the amount
            for(int coin : coins){
                if(i - coin < 0)continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;

        int res = solution.coinChange(coins, amount);
        System.out.println(res);
    }
}

// Time Complecity: O(coins * amount)
// Space Complecity: O(amount)
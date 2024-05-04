class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        // check if the sum is odd, as it cannot be partitioned into two equal subset
        if(sum % 2 != 0){
            return false;
        }

        int n = nums.length;
        sum = sum / 2;

        // dp[i][j] represents whether there exists a sublet sum of j among the first i elements
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // base case : an empty subset has a sum of 0, hence dp[i][0] is true for all i
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(j - nums[i - 1] < 0){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,5,11,5};
        boolean res = solution.canPartition(nums);
        System.out.println(res);
    }
}
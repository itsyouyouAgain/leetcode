import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i] will store the length of LIS ending at index i
        int[] dp = new int[n];

        // base case: the minimum length of LIS is 1 (itself)
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            // consider all elements before the current element nums[i]
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i : dp){
            res = Math.max(res, i);
        }

        return res;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = solution.lengthOfLIS(nums);
        System.out.println(res);
    }
}

// Time Complecity : O(n^2)
// Space Complecity: O(n)
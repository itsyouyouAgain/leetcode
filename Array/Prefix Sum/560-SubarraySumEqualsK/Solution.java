import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};  // Example input array
        int k = 2;  // Example target sum

        Solution solution = new Solution();
        int result = solution.subarraySum(nums, k);
        System.out.println("Output: " + result);  // Should print "Output: 2"
    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];  // Prefix sum array
        HashMap<Integer, Integer> count = new HashMap<>();  // HashMap to store the frequency of prefix sums
        preSum[0] = 0;  // Initialize the prefix sum array
        count.put(0, 1);  // Prefix sum of 0 has been seen once
        int res = 0;  // Result variable to store the number of subarrays

        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];  // Calculate current prefix sum
            int need = preSum[i] - k;  // Calculate the needed prefix sum

            // Check if the needed prefix sum has been seen before
            if (count.containsKey(need)) {
                res += count.get(need);  // Add the count of that prefix sum to the result
            }

            // Update the frequency of the current prefix sum
            count.put(preSum[i], count.getOrDefault(preSum[i], 0) + 1);
        }
        return res;  // Return the result
    }
}

//Time Complecity; O(n)
//Space Complecity: O(n)
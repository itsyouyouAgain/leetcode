import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] nums = {0, 1, 0};
        int maxLength = solution.findMaxLength(nums);
        System.out.println("The length of the longest subarray is: " + maxLength);
    }

    public int findMaxLength(int[] nums) {
        // Map to store prefix sum and corresponding index
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();

        int n = nums.length;
        // Prefix sum array with an extra space to handle sum from the beginning
        int[] preSum = new int[n + 1];
        // Initialize to 0 for the sum of an empty subarray
        preSum[0] = 0;

        // Calculate prefix sum, treating 0s as -1 and 1s as +1
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }

        int res = 0; // Will store the length of the longest subarray
        for (int i = 0; i <= n; i++) {
            if (!valueToIndex.containsKey(preSum[i])) {
                valueToIndex.put(preSum[i], i);
            } else {
                // Calculate the length of the subarray if the prefix sum has been seen before
                res = Math.max(res, i - valueToIndex.get(preSum[i]));
            }
        }
        return res; // Return the length of the longest subarray
    }
}

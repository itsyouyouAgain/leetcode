import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        // Test case example
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Solution solution = new Solution();
        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println("Output: " + result); // Expected output: true
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // HashMap to store the modulus of the prefix sum and its corresponding index
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int n = nums.length;
        // Prefix sum array with an additional space for 0 at the start
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        valToIndex.put(0, 0);

        for (int i = 1; i <= n; i++) {
            // Calculate the prefix sum up to the current index
            preSum[i] = preSum[i - 1] + nums[i - 1];
            // Calculate the modulus of the prefix sum with k
            int mod = preSum[i] % k;

            if (valToIndex.containsKey(mod)) {
                // Check if the subarray between the first occurrence of this modulus and the current index is at least 2 elements long
                if (i - valToIndex.get(mod) >= 2) {
                    return true; // If so, return true as we have found a valid subarray
                }
            } else {
                // If this is the first time this modulus has been seen, store the index in the hash map
                valToIndex.put(mod, i);
            }
        }
        return false; // If no such subarray is found, return false
    }
}

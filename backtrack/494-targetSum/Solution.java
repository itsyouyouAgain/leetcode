class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int sum) {
        if(nums.length == 0)return res;
        // call the backtrack function to find the ways to achieve the target
        backtrack(nums, sum, 0);
        return res;
    }

    void backtrack(int[] nums, int remain, int i){
        // base case : if we have processed all elements in the array
        if(i == nums.length){
            // check if the remain sum is equal to the target
            if(remain == 0){
                res++;
            }
            return;
        }

        // every element has two options
        remain += nums[i];
        backtrack(nums, remain, i + 1);
        remain -= nums[i];

        remain -= nums[i];
        backtrack(nums, remain, i + 1);
        remain += nums[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1,1};
        int sum = 3;
        int res = solution.findTargetSumWays(nums, sum);
        System.out.println(res);
    }
}

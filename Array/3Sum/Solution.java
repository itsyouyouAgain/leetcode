import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length - 2; k++){
            int i = k + 1, j = nums.length - 1;
            // if nums[k] is positive, break the loop as no further negative sums are possible
            if(nums[k] > 0) break;
            // skip duplicate to avoid duplicate triplete
            if(k > 0 && nums[k] == nums[k - 1])continue;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                int left = nums[i];
                int right = nums[j];
                // if sum is negative, move the left pointer to right to increase the sum
                if(sum < 0){
                    // skip duplicate of nums[i]
                    while(i < j && nums[i] == left)i++;

                // if sum is positive, move the right pointer to left to decrease the sum
                }else if(sum > 0){
                    // skip duplicate of nums[j]
                    while(i < j && nums[j] == right)j--;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while(i < j && nums[i] == left)i++;
                    while(i < j && nums[j] == right)j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = solution.threeSum(nums);
        System.out.println(res);
    }
}

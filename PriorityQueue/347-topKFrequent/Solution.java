import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        // Example array and k value
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        // Create an instance of Solution to call the non-static method topKFrequent
        Solution solution = new Solution();
        int[] result = solution.topKFrequent(nums, k);

        // Output the results
        System.out.println("Top " + k + " frequent elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // create a frequency map to count occurences of each number
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // use a minimum heap to keep track of k most frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (entry1, entry2) -> {
                return entry1.getValue().compareTo(entry2.getValue());
            });

        // Iterate over frequency map entries
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.offer(entry);
            // if heap size exceeds k, remove the least frequent element
            if(pq.size() > k){
                pq.poll();
            }
        }

        // Extract the top k frequent elements from the pq
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}
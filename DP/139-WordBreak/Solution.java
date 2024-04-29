import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // create hashset from worddict to allow quick lookup
        HashSet<String> set = new HashSet<>(wordDict);

        // dp[i] will store where substring(0, i) can be segemented into words in the worddict
        boolean[] dp = new boolean[s.length() + 1];

        //base case
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                // check if the subdtring from j to i is in the dict and if the substring up to j can be segemented
                if(set.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        // return whether the entire string can be segemented
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        boolean res = solution.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
//O(n^2)
//O(n)